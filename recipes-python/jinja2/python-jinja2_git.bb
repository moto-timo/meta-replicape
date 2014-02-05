SUMMARY = "Jinja2 is a modern and designer friendly templating language for Python, modelled after Django’s templates."
SECTION = "devel/python"

HOMEPAGE = "http://jinja.pocoo.org/docs/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=20c831f91dd3bd486020f672ba2be386"

SRC_URI = "git://github.com/mitsuhiko/jinja2.git;protocol=https"
SRCREV = "27ffd01f95cad7740497a32b22e4ef9d29762162"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
