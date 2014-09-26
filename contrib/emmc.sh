#!/bin/bash

# (c) Copyright 2013 Koen Kooi <koen@dominion.thruhere.net>
# Licensed under terms of GPLv2

export PATH=$PATH:/bin:/sbin:/usr/bin:/usr/sbin

FLASHIMG="Angstrom-systemd-thing-image-eglibc-ipk-v2014.06-beaglebone.rootfs.tar.xz"
PART1MOUNT="/media/1"
PART2MOUNT="/media/2"

HOSTARCH="$(uname -m)"

MLOMD5="992228bb0b6719905246b7b9fa6d3cb8"
UBOOTMD5="28141911ee2eefda727ac06a178183bf"

cd /build

HEADER=$(hexdump -e '8/1 "%c"' /sys/bus/i2c/devices/0-0050/eeprom -s 5 -n 3)

if [ ${HEADER} -eq 335 ] ; then
        echo "Valid EEPROM header found"
else
        echo "Invalid EEPROM header detected"
	if [ -e /eeprom.dump ] ; then
		echo "Adding header to EEPROM"
		dd if=/eeprom.dump of=/sys/devices/ocp.2/44e0b000.i2c/i2c-0/0-0050/eeprom
	fi
fi

if ! [ -e /dev/mmcblk1 ] ; then
	echo "eMMC device not found!"
	exit
fi

echo "Zeroing eMMC"
dd if=/dev/zero of=/dev/mmcblk1 bs=16M count=16
echo "Partitioning eMMC"
./mkcard.sh /dev/mmcblk1

echo "Mounting partitions"
mkdir -p ${PART1MOUNT}
mkdir -p ${PART2MOUNT}
mount /dev/mmcblk1p1 ${PART1MOUNT} -o sync
mount /dev/mmcblk1p2 ${PART2MOUNT} -o async,noatime

echo "Copying bootloader files"
cp MLO u-boot.img ${PART1MOUNT}
echo "optargs=drm.debug=7 consoleblank=0 vt.global_cursor_default=0 mtdoops.mtddev=2" > ${PART1MOUNT}/uEnv.txt

umount /dev/mmcblk1p1

sync

echo "Extracting rootfs"
tar Jxf ${FLASHIMG} -C ${PART2MOUNT} --numeric-owner

echo "Populating VFAT partition"
mount /dev/mmcblk1p1 ${PART1MOUNT} -o async
if [ -d ${PART2MOUNT}/usr/share/beaglebone-getting-started ] ; then
	cp -r ${PART2MOUNT}/usr/share/beaglebone-getting-started/* ${PART1MOUNT}
fi

# Add ID and dogtag
echo "Systemd Thing Image 2014.09.21" > ${PART1MOUNT}/ID.txt
echo "Systemd Thing Image 2014.09.21" > ${PART2MOUNT}/etc/dogtag
echo -e "NAME=Thing\nID=thing\nPRETTY_NAME=The Thing\nANSI_COLOR=1;35" > ${PART2MOUNT}/etc/os-release
# Set hostname 
echo "thing" > ${PART2MOUNT}/etc/hostname
# Add thing package feeds
echo "src/gz thing-base http://feeds.thing-printer.com/feeds/v2014.06/ipk/eglibc/armv7at2hf-vfp-neon/machine/beaglebone" > ${PART2MOUNT}/etc/opkg/thing-base-feed.conf
echo "src/gz thing-beaglebone http://feeds.thing-printer.com/feeds/v2014.06/ipk/eglibc/beaglebone" > ${PART2MOUNT}/etc/opkg/thing-beaglebone-feed.conf

# Remove the Angstrom package feeds
echo "#src/gz base http://feeds.angstrom-distribution.org/feeds/v2014.06/ipk/eglibc/armv7at2hf-vfp-neon/base" > ${PART2MOUNT}/etc/opkg/base-feed.conf
echo "#src/gz beaglebone http://feeds.angstrom-distribution.org/feeds/v2014.06/ipk/eglibc/armv7at2hf-vfp-neon/machine/beaglebone" > ${PART2MOUNT}/etc/opkg/beaglebone-feed.conf

umount /dev/mmcblk1p1

if [ "${HOSTARCH}" = "armv7l" ] ; then

	echo "Generating machine ID"
	systemd-nspawn -D ${PART2MOUNT} /bin/systemd-machine-id-setup

	echo "Running Postinsts"
	cpufreq-set -g performance
	systemd-nspawn -D ${PART2MOUNT} /usr/bin/opkg-cl configure
	if [ -e ${PART2MOUNT}/etc/rcS.d/S98run-postinsts ] ; then 
		systemd-nspawn -D ${PART2MOUNT} /etc/rcS.d/S98run-postinsts
		rm -f ${PART2MOUNT}/etc/rcS.d/S98run-postinsts
	fi
	cpufreq-set -g ondemand

	# Hack to get some space back
	systemd-nspawn -D ${PART2MOUNT} /usr/bin/opkg-cl remove db-doc --force-depends

	#echo "Setting timezone to Europe/Paris"
	#systemd-nspawn -D ${PART2MOUNT} /usr/bin/timedatectl set-timezone Europe/Paris
fi

rm -f ${PART2MOUNT}/etc/pam.d/gdm-autologin

rm -f ${PART2MOUNT}/etc/systemd/system/multi-user.target.wants/xinput-calibrator.service
rm -f ${PART2MOUNT}/etc/systemd/system/multi-user.target.wants/busybox*
rm -f ${PART2MOUNT}/etc/dropbear/dropbear_rsa_host_key
ln -s /dev/null ${PART2MOUNT}/etc/systemd/system/xinetd.service
# Disable tty1 login
rm -f ${PART2MOUNT}/etc/systemd/system/getty.target.wants/getty@tty1.service
# Mask the ttyGS0 service
rm -f ${PART2MOUNT}/etc/systemd/system/getty.target.wants/serial-getty@ttyGS0.service

# link libprussdrv.so to libprussdrv.so.1
#cd ${PART2MOUNT}/usr/lib/
#ln -s libprussdrv.so.1 libprussdrv.so

touch ${PART2MOUNT}/etc/default/locale

cd /build

# enable wifi
mkdir -p ${PART2MOUNT}/var/lib/connman/
cp connman.settings ${PART2MOUNT}/var/lib/connman/settings

rm -f ${PART2MOUNT}/etc/network/interfaces

# Replace wallpaper
cp thing.jpg ${PART2MOUNT}/usr/share/pixmaps/

umount ${PART2MOUNT}

sync

# verification stage

mount /dev/mmcblk1p1 ${PART1MOUNT}

ERROR=""

if [ -e ${PART1MOUNT}/ID.txt ] ; then
	echo "ID.txt found"
else
	echo "ID.txt missing - ERROR"
	ERROR="ID.txt"
fi

if [ -e ${PART1MOUNT}/START.htm ] ; then
	echo "START.htm found"
else
	echo "START.htm missing - ERROR"
	#ERROR="${ERROR}, START.htm"
fi

if [ "${MLOMD5}" != "$(md5sum ${PART1MOUNT}/MLO | awk '{print $1}')" ] ; then        
	echo "MLO MD5sum failed"       
	ERROR="${ERROR}, MLO"  
fi   
 
if [ "${UBOOTMD5}" != "$(md5sum ${PART1MOUNT}/u-boot.img | awk '{print $1}')" ] ; then
	echo "u-boot MD5sum failed"
	ERROR="${ERROR}, uboot"
fi

umount /dev/mmcblk1p1

mount /dev/mmcblk1p2 ${PART2MOUNT} -o async,noatime

BGMD5SUM_VALID="82891982dbc8effa7a79baad5959f24a"
BGMD5SUM="$(md5sum ${PART2MOUNT}/usr/share/pixmaps/thing.jpg | awk '{print $1}')"

if [ "${BGMD5SUM_VALID}" != "${BGMD5SUM}" ] ; then
	echo "Wallpaper MD5sum failed"
	ERROR="${ERROR}, bgmd5"
fi
umount ${PART2MOUNT}

# force writeback of eMMC buffers
dd if=/dev/mmcblk1 of=/dev/null count=100000

echo "ERRORS found: ${ERROR}" > emmc_install.log
sync

if [ -z "$ERROR" ] ; then
  echo default-on > /sys/class/leds/beaglebone\:green\:usr0/trigger
  echo default-on > /sys/class/leds/beaglebone\:green\:usr1/trigger
	echo default-on > /sys/class/leds/beaglebone\:green\:heartbeat/trigger
	echo default-on > /sys/class/leds/beaglebone\:green\:mmc0/trigger
  echo default-on > /sys/class/leds/beaglebone\:green\:usr2/trigger
  echo default-on > /sys/class/leds/beaglebone\:green\:usr3/trigger
else
	echo none > /sys/class/leds/beaglebone\:green\:usr0/trigger
	echo none > /sys/class/leds/beaglebone\:green\:usr1/trigger
	echo none > /sys/class/leds/beaglebone\:green\:heartbeat/trigger
	echo none > /sys/class/leds/beaglebone\:green\:mmc0/trigger
	echo none > /sys/class/leds/beaglebone\:green\:usr2/trigger
	echo none > /sys/class/leds/beaglebone\:green\:usr3/trigger
fi
