SUMMARY = "Embedded front end for Debrew"

DESCRIPTION = "Debrew-app is a small screen front end for open source hand brew coffee machines"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://bitbucket.org/intelligentagent/debrew.git;protocol=https"
SRCREV = "2394a7cfd96284a444aa13eaaf058631a36b7276"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += " \
    clutter-1.0 \
    mx \
    mash \
"
DEPENDS_${PN} += " \
    clutter-1.0 \
    mx \
    mash \
"
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "debrew.service"

do_compile(){
}

do_install () {
    install -d ${D}/etc/debrew
    install -d ${D}/etc/debrew/style
    install -d ${D}/usr/src/debrew/software
    install -m 0744 ${S}/app/software/*.py ${D}/usr/src/debrew/software/
    install -m 0644 ${S}/app/ui.json ${D}/etc/debrew
    install -m 0644 ${S}/app/static/*.png ${D}/etc/debrew/style/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/app/debrew.service ${D}${systemd_unitdir}/system
}

FILES_${PN} = " \
	    /etc/debrew/ui.json \
	    /etc/debrew/ \
        /usr/src/debrew/software/*.py \
        ${systemd_unitdir}/system \
        ${systemd_unitdir}/system/debrew.service \
"
