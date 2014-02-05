SUMMARY = "Identity management for Flask."
HOMEPAGE = "http://packages.python.org/Flask-Principal/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;begin=8;endline=8;md5=7c642ad7069691b9047e0d6f76b6e686"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask-Principal/Flask-Principal-0.3.5.tar.gz"
SRC_URI[md5sum] = "8251576d89720119d23a4407c4ce8dc8"
SRC_URI[sha256sum] = "d6eef6762b21cb716bcd8096249d40e5f10af5871863893194d04f827f2b2c95"

S = "${WORKDIR}/Flask-Principal-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-flask"


