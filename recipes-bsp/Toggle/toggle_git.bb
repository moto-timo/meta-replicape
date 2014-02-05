SUMMARY = "3D-printer front end for embedded devices."

DESCRIPTION = "Toggle is a 3D-printer front end for use with embedded devices."

HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Toggle"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/toggle.git;protocol=https \
            file://toggle.service \
            file://toggle.sh"

SRCREV = "89ca101cd95440de4f78bdd7331205d86671c7c6"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = " \
    clutter \
    mx \
    mash \
"
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "toggle.service"

do_compile(){
    make
}


do_install () {
    install -d ${D}${bindir}
    install -d ${D}/etc/toggle
    install -d ${D}/etc/toggle/style
    install -m 0744 ${S}/toggle ${D}${bindir}
    install -m 0644 ${S}/ui.json ${D}/etc/toggle
    install -m 0644 ${S}/style/* ${D}/etc/toggle/style

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/toggle.service ${D}${systemd_unitdir}/system
    install -d ${D}/etc/init.d
    install -m 0755 ${WORKDIR}/toggle.sh ${D}/etc/init.d
}

FILES_${PN} += " \
	    ${bindir} \
	    ${bindir}/toggle \
        /etc \
	    /etc/toggle/ui.json \
	    /etc/toggle/style/style.css \
        /etc/init.d \
        /etc/init.d/toggle.sh  \
        ${systemd_unitdir}/system \
        ${systemd_unitdir}/system/toggle.service \
"
