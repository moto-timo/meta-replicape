SUMMARY = "Flask user session management."
SECTION = "devel/python"

HOMEPAGE = "http://flask-login.readthedocs.org/en/latest/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8aa87a1cd9fa41d969ad32cfdac2c596"

SRC_URI = "git://github.com/maxcountryman/flask-login.git;protocol=https"
SRCREV = "83772b252b245dd1c9aa8900b600dd29d6f05227"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
