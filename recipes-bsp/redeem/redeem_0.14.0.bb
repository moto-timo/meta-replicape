include redeem.inc

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;protocol=https"
SRCREV = "c92233ed047da8b50d5aed4aca16fa9a2313d543"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

DEPENDS += "swig-native"

RDEPENDS_${PN} = " \
	python-email \
	python-smbus \
	python-mmap \
    python-spi \
    python-multiprocessing \
    tty0tty \
"

inherit setuptools
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "redeem.service"

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

do_compile_prepend(){
    cd software/path_planner
}

do_install_prepend(){
    cd software/path_planner
}

do_install_append () {
    install -d ${D}/usr/
    install -d ${D}/usr/src/
    install -d ${D}/usr/src/redeem
    install -d ${D}/usr/src/redeem/software
    install -d ${D}/usr/src/redeem/software/gcodes
    install -d ${D}/usr/src/redeem/software/path_planner
    install -d ${D}/usr/src/redeem/firmware
    install -d ${D}/etc
    install -d ${D}/etc/redeem
    install -m 0744 ${S}/software/*.py ${D}/usr/src/redeem/software
    install -m 0744 ${S}/software/gcodes/*.py ${D}/usr/src/redeem/software/gcodes/
    install -m 0744 ${S}/software/path_planner/*.py ${D}/usr/src/redeem/software/path_planner/
    install -m 0644 ${S}/firmware/*.p  ${D}/usr/src/redeem/firmware
    install -m 0644 ${S}/firmware/*.h  ${D}/usr/src/redeem/firmware    
    install -m 0644 ${S}/configs/*.cfg ${D}/etc/redeem/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/systemd/redeem.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += " \
      /usr/src/redeem/software/*.py \
      /usr/src/redeem/software/gcodes/*.py \
      /usr/src/redeem/software/path_planner/*.py \
      /usr/src/redeem/firmware/*.p \
      /usr/src/redeem/firmware/*.h \
      /etc/redeem/*.cfg \
      ${systemd_unitdir}/system/redeem.service \
"

BBCLASSEXTEND = "native"
