SUMMARY = "Werkzeug is a WSGI utility library for Python. It's widely used and BSD licensed."
SECTION = "devel/python"

HOMEPAGE = "http://http://werkzeug.pocoo.org/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1fec8258d8c03c331fe462de1e57128e"

SRC_URI = "git://github.com/mitsuhiko/werkzeug.git;protocol=https"
SRCREV = "8d4d4b3297805bce52c9b820530d7c80d369e20a"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
