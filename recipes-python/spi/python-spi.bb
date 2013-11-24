SUMMARY = "Python bindings for Linux SPI access through spi-dev"

HOMEPAGE = "http://www.hs-augsburg.de/~vthoms"
SECTION = "devel"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;protocol=https"
SRCREV = "532946f60329bb2c701d24c49030009209ac7a74"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git/libs/spi"

FILES_${PN} += " \
"

inherit distutils

