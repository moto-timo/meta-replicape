SUMMARY = "SockJS python server implementation on top of Tornado framework"
HOMEPAGE = "http://github.com/mrjoes/sockjs-tornado/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;begin=7;endline=27;md5=c1fb5839a8d91948847c3e4b07945a94"

SRC_URI = "https://pypi.python.org/packages/source/s/sockjs-tornado/sockjs-tornado-1.0.0.zip"
SRC_URI[md5sum] = "ff03279696f3466b54fb184a8c358221"
SRC_URI[sha256sum] = "ee138b0a405a42cd899dd1ee42d51f25706c208c0a226260a8928e8ba2f2445d"
S = "${WORKDIR}/sockjs-tornado-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-tornado"


