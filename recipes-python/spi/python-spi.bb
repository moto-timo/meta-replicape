SUMMARY = "Python bindings for Linux SPI access through spi-dev"

HOMEPAGE = "http://www.hs-augsburg.de/~vthoms"
SECTION = "devel"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://spimodule.c;beginline=1;endline=17;md5=c1f3e404b7e6e74564a570fbe9c601f1"

SRC_URI = "http://elk.informatik.fh-augsburg.de/da/da-49/trees/pyap7k.tar.bz2 \
           file://0001-setup-py-changes.patch \
           file://0002-spimodule-c-changes.patch \
"
SRC_URI[md5sum] = "42c52facbeb09bfcee93b1c5ca9f3d0f"
SRC_URI[sha256sum] = "e24a76bc6279516412b67418df4d69c7955ebc26e48640f05d35bc84a55dd361"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/pyap7k/lang/py-spi/src"

inherit distutils

