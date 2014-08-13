SUMMARY = "Flask is a microframework for Python based on Werkzeug, Jinja 2 and good intentions."
SECTION = "devel/python"

HOMEPAGE = "http://flask.pocoo.org/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79aa8b7bc4f781210d6b5c06d6424cb0"

SRC_URI = "git://github.com/mitsuhiko/flask.git;protocol=https"
#SRCREV = "17a3056be4bceaf0c1f4c309b66c5d6e8d50def0"
SRCREV = "1d55b8983efdc840b83ae6ccc4e496165010c8d1"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
