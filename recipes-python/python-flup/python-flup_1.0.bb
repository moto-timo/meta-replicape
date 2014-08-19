SUMMARY = "Random assortment of WSGI servers"
SECTION = "devel/python"

HOMEPAGE = "https://pypi.python.org/pypi/flup/1.0"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://flup/client/fcgi_app.py;endline=29;md5=830591fc3ce6eddce5d79b9754387c49"

SRC_URI = "https://pypi.python.org/packages/source/f/flup/flup-${PV}.tar.gz"
SRC_URI[md5sum] = "530801fe835fd9a680457e443eb95578"
SRC_URI[sha256sum] = "dd943b9746997bb6e49820187998dd26a58b2d0f886a45c166209e6d7d35aa32"

S = "${WORKDIR}/flup-${PV}"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
