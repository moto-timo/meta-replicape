SUMMARY = "Pythonic manipulation of IPv4, IPv6, CIDR, EUI and MAC network addresses"
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/netaddr/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4ee508e838b58bfd618ebc4ef9ba371"

SRC_URI = "git://github.com/drkjam/netaddr.git;protocol=https"
SRCREV = "f64ae19e533ffa5522dcba1fc833975cb2ee88a5"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
