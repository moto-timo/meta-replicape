SUMMARY = "Various helpers to pass trusted data to untrusted environments"
SECTION = "devel/python"

HOMEPAGE = "http://packages.python.org/itsdangerous/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b61841e2bf5f07884148e2a6f1bcab0c"

SRC_URI = "git://github.com/mitsuhiko/itsdangerous.git;protocol=https"
SRCREV = "2af6ef11079e94b06931c8df87f943bc89a1d4be"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
