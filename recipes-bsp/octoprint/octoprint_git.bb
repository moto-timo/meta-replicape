SUMMARY = "OctoPrint provides a responsive web interface for controlling a 3D printer (RepRap, Ultimaker, ...)."
SECTION = "devel/python"

HOMEPAGE = "http://octoprint.org"

LICENSE = "AGPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "git://github.com/foosel/OctoPrint.git;protocol=https\ 
           file://config.yaml \
           file://octoprint.service \
           file://octoprint.sh"

SRCREV = "b282a18f6bb09bfba86ada1a4e002cac58455ce9"

S = "${WORKDIR}/git"

inherit setuptools
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "octoprint.service"

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR


RDEPENDS{PN} = " python-tornado \
                 python-pyyaml \
                 python-numpy \
                 python-pyserial \
                 pytyhon-werkzeug \
                 python-html \
                 python-sockjs-tornado \
                 python-tornado \
                 python-json \
                 python-backports-ssl-match-hostname \
                 python-flask \
                 python-flask-login \
                 python-netserver \
                 python-itsdangerous \
                 python-markupsafe \
                 python-blinker \
                 python-netaddr \
"

BBCLASSEXTEND = "native"

do_install_append(){
    install -d ${D}${bindir}
    install -d ${D}/etc/octoprint
    install -d ${D}/lib/systemd/system
    install -d ${D}/etc/init.d
    install -m 0644 ${S}/../octoprint.service ${D}${systemd_unitdir}/system
    install -m 0774 ${S}/run ${D}${bindir}/octoprint
    install -m 0644 ${S}/../config.yaml ${D}/etc/octoprint/config.yaml
    install -m 0774 ${WORKDIR}/octoprint.sh ${D}/etc/init.d/octoprint.sh
}

FILES_${PN} += " \
    /usr \
    /usr/bin \
    /usr/bin/octoprint \
    /lib \
    /etc \
    /lib/systemd \ 
    /lib/systemd/system \
    /lib/systemd/system/octoprint.service \
    /etc/octoprint \
    /etc/octoprint/config.yaml \
    /etc/init.d \    
    /etc/init.d/octoprint.sh \
"


