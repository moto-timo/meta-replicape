SUMMARY = "A wrapper for subprocess which provides command pipeline functionality."
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/sarge"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5b7bcb59dada77822aa4d479a96cc6d"

SRC_URI = "https://pypi.python.org/packages/source/s/sarge/sarge-${PV}.tar.gz"

SRC_URI[md5sum] = "5fa790cc26a97c66be735629b0e6671c"
SRC_URI[sha256sum] = "c929be34d0a242f15e063d91f0ce0af8679b2fab0c92712ff21acd2372447338"

S = "${WORKDIR}/sarge-${PV}"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
