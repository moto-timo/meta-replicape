SUMMARY = "Identity management for Flask applications"
SECTION = "devel/python"

HOMEPAGE = "http://pythonhosted.org/Flask-Principal/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=946a71eddb833fc7ea0c0c175eb8440c"

SRC_URI = "git://github.com/mattupstate/flask-principal.git;protocol=https"
SRCREV = "81ee6b7d658e7cd3200c0efc5bbb706215526082"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
