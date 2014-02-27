include redeem.inc

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;branch=Rev-A4;protocol=https \
    file://redeem.service"
SRCREV = "57039c41da83a69cdce4768a4f082ca2bfcddbba"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "/software"

RDEPENDS_${PN} = " \
	python-email \
	python-smbus \
	python-mmap \
	python-profile \
    python-spi \
    python-multiprocessing \
    pypruss \
    tty0tty \
    redeem-firmware \
"

inherit distutils
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "redeem.service"

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
    install -m 0744 ${S}/*.py ${D}/usr/src/redeem/software
    install -m 0644 ${S}/*.c ${D}/usr/src/redeem/software
    
    install -m 0644 ${S}/config/*.cfg ${D}/etc/redeem/
    cd ${D}/etc/redeem/; ln -s Thing.cfg default.cfg

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${workdir}/redeem.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += " \
      /usr/src/redeem/software/*.py \
      /usr/src/redeem/software/*.c \
      /usr/src/redeem/software/config/*.cfg \
      ${systemd_unitdir}/system/redeem.service \
"
