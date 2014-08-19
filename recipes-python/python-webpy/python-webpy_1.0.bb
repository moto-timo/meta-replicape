SUMMARY = "web.py is a web framework for python that is as simple as it is powerful."
SECTION = "devel/python"

HOMEPAGE = "http://webpy.org/"

LICENSE = "PD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=98bdd61465b0278f5e6b8e81a0c981f2"

SRC_URI = "git://github.com/webpy/webpy.git;protocol=https"
SRCREV = "73f1119649ffe54ba26ddaf6a612aaf1dab79b7f"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
