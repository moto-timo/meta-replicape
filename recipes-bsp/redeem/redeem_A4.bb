include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "/software"

RDEPENDS_${PN} = " \
	python-email \
	python-smbus \
	python-mmap \
	python-profile \
    python-spi \
    pypruss \
	libprussdrv \
    redeem-firmware \
    tty0tty \
    tty0tty-systemd \
"

inherit distutils

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

do_install_append () {
    install -d ${D}/usr/
    install -d ${D}/usr/src/
    install -d ${D}/usr/src/redeem
    install -d ${D}/usr/src/redeem/software
    install -d ${D}/usr/src/redeem/software/config
    install -m 0644 ${S}/*.py ${D}/usr/src/redeem/software
    install -m 0644 ${S}/*.c ${D}/usr/src/redeem/software
    install -m 0644 ${S}/config/*.cfg ${D}/usr/src/redeem/software/config
    ln -s /usr/src/redeem/software/config/Thing.cfg /usr/src/redeem/software/config/default.cfg

    install -d ${D}${systemd_unitdir}/system
    install -d ${D}${systemd_unitdir}/system/redeem.d
    install -m 0644 ${S}/systemd/redeem.service ${D}${systemd_unitdir}/system
    sed -i 's:/etc/init.d/:${systemd_unitdir}/system/redeem.d/:g' ${D}${systemd_unitdir}/system/redeem.service
    install -m 0755 ${S}/systemd/redeem.sh ${D}${systemd_unitdir}/system/redeem.d/
}

FILES_${PN} += " \
	    /usr/ \
	    /usr/src/ \
	    /usr/src/redeem \
	    /usr/src/redeem/software \
            /usr/src/redeem/software/*.py \
            /usr/src/redeem/software/*.c \
	    /usr/src/redeem/software/config \
            /usr/src/redeem/software/config/*.cfg \
        ${systemd_unitdir}/system/redeem.service \
	    ${systemd_unitdir}/system/redeem.d/redeem.sh \
"
