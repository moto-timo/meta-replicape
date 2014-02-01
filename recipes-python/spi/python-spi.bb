SUMMARY = "Python bindings for Linux SPI access through spi-dev"

HOMEPAGE = "http://www.hs-augsburg.de/~vthoms"
SECTION = "devel"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;protocol=https"
SRCREV = "adaf070f3d1b4db9c8df566c41e721dce359c6c3"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git/libs/spi"

do_compile_prepend(){
    sed -i -e "s:/usr/include:${TMPDIR}/sysroots/beaglebone/usr/include:g" setup.py
}

FILES_${PN} += " \
"

inherit distutils

