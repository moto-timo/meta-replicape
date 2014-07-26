include redeem.inc

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;protocol=https"
SRCREV = "000a040927742e7d6ec387263d41f157e7caa82d"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

RDEPENDS_${PN} = " \
	python-email \
	python-smbus \
	python-mmap \
	python-profile \
    python-spi \
    python-multiprocessing \
    pypruss \
    tty0tty \
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

do_compile(){
    cd software; python setup.py build_ext
}

do_install(){
    cd software; python setup.py install
}

do_install_append () {
    install -d ${D}/usr/
    install -d ${D}/usr/src/
    install -d ${D}/usr/src/redeem
    install -d ${D}/usr/src/redeem/software
    install -d ${D}/usr/src/redeem/software/gcodes
    install -d ${D}/usr/src/redeem/firmware
    install -d ${D}/etc
    install -d ${D}/etc/redeem
    install -m 0744 ${S}/software/*.py ${D}/usr/src/redeem/software
    install -m 0744 ${S}/software/gcodes/*.py ${D}/usr/src/redeem/software/gcodes
    install -m 0644 ${S}/firmware/*.p  ${D}/usr/src/redeem/firmware
    install -m 0644 ${S}/firmware/*.h  ${D}/usr/src/redeem/firmware    
    install -m 0644 ${S}/configs/*.cfg ${D}/etc/redeem/
    install -m 0644 ${S}/configs/Thing.cfg ${D}/etc/redeem/default.cfg

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/systemd/redeem.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += " \
      /usr/src/redeem/software/*.py \
      /usr/src/redeem/software/gcodes/*.py \
      /usr/src/redeem/firmware/*.p \
      /usr/src/redeem/firmware/*.h \
      /etc/redeem/*.cfg \
      ${systemd_unitdir}/system/redeem.service \
"
