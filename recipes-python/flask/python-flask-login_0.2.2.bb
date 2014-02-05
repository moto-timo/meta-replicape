SUMMARY = "User session management for Flask."
HOMEPAGE = "https://github.com/maxcountryman/flask-login"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8aa87a1cd9fa41d969ad32cfdac2c596"

SRC_URI = "https://pypi.python.org/packages/source/F/Flask-Login/Flask-Login-0.2.2.tar.gz"
SRC_URI[md5sum] = "8885d13663d2e1ed0773569436252c59"
SRC_URI[sha256sum] = "f704ce4b4644af34baf9c453ab2b3a156b0a977956dfa28a015f8e3832b0cf27"

S = "${WORKDIR}/Flask-Login-${PV}"

inherit setuptools

RDEPENDS_${PN} = "python-flask"


