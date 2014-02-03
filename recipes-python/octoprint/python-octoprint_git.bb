SUMMARY = "OctoPrint provides a responsive web interface for controlling a 3D printer (RepRap, Ultimaker, ...)."
SECTION = "devel/python"

HOMEPAGE = "http://octoprint.org"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "git://github.com/foosel/OctoPrint.git;protocol=https"
SRCREV = "b282a18f6bb09bfba86ada1a4e002cac58455ce9"

S = "${WORKDIR}/git"

inherit setuptools

# TODO: does pip work as part of build process?
#do_configure(){
#    pip install -r {$S}/requirements.txt
#}

RDEPENDS+${PN} = " python-tornado \
                   python-pyyaml \
                   python-numpy \
                   python-pyserial \
"
#                 python-flask 
#                 pytyhon-werkzeug 
#                 python-sockjs-tornado 
#                 python-Flask-Login 
#                 python-Flask-Principal 
#                 python-netaddr 

BBCLASSEXTEND = "native"
