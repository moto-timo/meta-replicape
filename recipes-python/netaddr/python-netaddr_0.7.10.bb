SUMMARY = "Pythonic manipulation of IPv4, IPv6, CIDR, EUI and MAC network addresses"
HOMEPAGE = "http://github.com/drkjam/netaddr/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64c24df6c6be03cf388a97f707e8405e"

SRC_URI = "https://pypi.python.org/packages/source/n/netaddr/netaddr-0.7.10.tar.gz"
SRC_URI[md5sum] = "605cfd09ff51eaeff0ffacdb485e270b"
SRC_URI[sha256sum] = "9b79763141a855079b0589717696a4ccb5c56c0b807b6e584bfe12333399e0b7"

S = "${WORKDIR}/netaddr-${PV}"

inherit distutils

RDEPENDS_${PN} = "python-modules"
