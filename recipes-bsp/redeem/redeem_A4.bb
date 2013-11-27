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
    redeem-systemd \
    tty0tty \
    tty0tty-systemd \
"

inherit distutils

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

do_install_append () {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/Replicape
    install -d ${D}${bindir}/Replicape/software
    install -d ${D}${bindir}/Replicape/software/config
    install -m 0644 ${S}/*.py ${D}${bindir}/Replicape/software
    install -m 0644 ${S}/*.c ${D}${bindir}/Replicape/software
    install -m 0644 ${S}/config/*.cfg ${D}${bindir}/Replicape/software/config
#    ln -s ${bindir}/Replicape/software/config/Thing.cfg ${bindir}/Replicape/software/config/default.cfg
}

FILES_${PN} += " \
	    ${bindir}/Replicape \
	    ${bindir}/Replicape/software \
            ${bindir}/Replicape/software/*.py \
            ${bindir}/Replicape/software/*.c \
	    ${bindir}/Replicape/software/config \
            ${bindir}/Replicape/software/config/*.cfg \
"
