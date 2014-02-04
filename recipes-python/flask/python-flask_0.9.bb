SUMMARY = "A microframework based on Werkzeug, Jinja2 and good intentions."
HOMEPAGE = "http://flask.pocoo.org/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=64f0cdf34b088b29d74ab7e8f8ce9f1d"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask/Flask-0.9.tar.gz"
SRC_URI[md5sum] = "4a89ef2b3ab0f151f781182bd0cc8933"
SRC_URI[sha256sum] = "2fd5d4ffe81f762dd2a3e58472d690a0dbba3766776506003aee3ed7aaa8afef"

S = "${WORKDIR}/Flask-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-werkzeug"


