SUMMARY = "OctoPrint provides a responsive web interface for controlling a 3D printer (RepRap, Ultimaker, ...)."
HOMEPAGE = "http://octoprint.org"

SECTION = "devel/python"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

# Latest master
SRCREV = "6171c76199f5def65260d3015347e74074e6c850"
#SRCREV = "48dc27e1060393b0b4e98f25358711d73bf2b7f5" # New master
#SRCREV = "b282a18f6bb09bfba86ada1a4e002cac58455ce9" # Old master
#SRCREV = "4d434d36bee94d3d5029358ef59c00e22fbfc37e" # Latest devel, not responding


SRC_URI = "git://github.com/foosel/OctoPrint.git;protocol=https;branch=master\ 
           file://config.yaml \
           file://octoprint.service \
"
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

BBCLASSEXTEND = "native"

do_install_append(){
    install -d ${D}${bindir}
    install -d ${D}/etc/octoprint
    install -d ${D}/lib/systemd/system
    install -m 0644 ${S}/../octoprint.service ${D}${systemd_unitdir}/system
    install -m 0774 ${S}/run ${D}${bindir}/octoprint.start
    install -m 0644 ${S}/../config.yaml ${D}/etc/octoprint/config.yaml
}

FILES_${PN} += " \
    /usr \
    /usr/bin \
    /usr/bin/octoprint.start \
    /lib \
    /lib/systemd \ 
    /lib/systemd/system \
    /lib/systemd/system/octoprint.service \
    /etc \
    /etc/octoprint \
    /etc/octoprint/config.yaml \
"

RDEPENDS_${PN} = "python-tornado \
                  python-pyyaml \
                  python-numpy \
                  python-pyserial \
                  python-werkzeug \
                  python-html \
                  python-sockjs-tornado \
                  python-tornado \
                  python-json \
                  python-backports-ssl-match-hostname \
                  python-flask \
                  python-flask-login \
                  python-flask-principal \
                  python-netserver \
                  python-itsdangerous \
                  python-markupsafe \
                  python-blinker \
                  python-netaddr \
                  python-jinja2 \
                  python-watchdog \
                  python-pathtools \
                  python-sarge \
                  python-sphinxcontrib-httpdomain \
                  python-sphinx-rtd-theme \
"

