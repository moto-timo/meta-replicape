SUMMARY = "Pythonic manipulation of IPv4, IPv6, CIDR, EUI and MAC network addresses"
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/netaddr/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e0c5cc28e66c19626bc908b3a9402c2e"

SRC_URI = "git://github.com/drkjam/netaddr.git;protocol=https;branch=rel-0.7.x"
SRCREV = "21587e22a5436935aaf887c41fba6c5e61f55276"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
