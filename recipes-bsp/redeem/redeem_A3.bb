include redeem.inc

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;branch=Rev-A3;protocol=https"
SRCREV = "09d868dab213ff39077c604f8f7857776b29295a"

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
    tty0tty \
    redeem-firmware \
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
    cd ${D}/usr/src/redeem/software/config/; ln -s Thing.cfg default.cfg

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/../systemd/redeem.service ${D}${systemd_unitdir}/system
    install -d ${D}/etc/
    install -d ${D}/etc/init.d/
    install -m 0755 ${S}/../systemd/redeem.sh ${D}/etc/init.d
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
        /etc/ \
        /etc/init.d/ \
	    /etc/init.d/redeem.sh \
"
