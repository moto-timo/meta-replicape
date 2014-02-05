SUMMARY = "SockJS-tornado is a Python server side counterpart of SockJS-client browser library running on top of Tornado framework."
SECTION = "devel/python"

HOMEPAGE = "https://github.com/mrjoes/sockjs-tornado"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f68f551a860a1c94f9732b89fc8a331"

SRC_URI = "git://github.com/mrjoes/sockjs-tornado.git;protocol=https"
SRCREV = "b90116f0b4b24ef65beedbeacadc8a35a9a5fee8"

S = "${WORKDIR}/git"

inherit setuptools

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"
