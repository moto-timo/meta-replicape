SUMMARY = "3D-printer front end for embedded devices."

DESCRIPTION = "Toggle is a 3D-printer front end for use with embedded devices."

HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Toggle"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/toggle.git;protocol=https"
SRCREV = "89ca101cd95440de4f78bdd7331205d86671c7c6"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

DEPENDS_${PN} = " \
    clutter \
    mx \
    mash \
"


do_compile(){
    make
}


do_install () {
    install -d ${D}${bindir}
    install -d ${D}/etc/toggle
    install -d ${D}/etc/toggle/style
    install -m 0644 ${S}/toggle ${D}${bindir}
    install -m 0644 ${S}/ui.json ${D}/etc/toggle/
    install -m 0644 ${S}/style/* ${D}/etc/toggle/style/
}

FILES_${PN} += " \
	    ${bindir}/toggle \
	    /etc/toggle/ui.json \
	    /etc/toggle/style/style.css \
"
