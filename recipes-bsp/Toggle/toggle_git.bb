SUMMARY = "3D-printer front end for embedded devices."

DESCRIPTION = "Toggle is a 3D-printer front end for use with embedded devices."

HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Toggle"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/toggle.git;protocol=https \
            file://toggle.service \
            file://toggle.sh \
            file://treefrog.ply"

SRCREV = "64e14a9a029f8dd2dd4251880e554b144ee453be"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

DEPENDS_${PN} = " \
    clutter \
    mx \
    mash \
"
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "toggle.service"

inherit pkgconfig

#CFLAGS_prepend = "-I /usr/include/clutter-1.0 -I /usr/include/glib-2.0 "

do_compile(){
    export PKG_CONFIG_LIBDIR=${STAGING_DIR_TARGET}/usr/lib/pkgconfig
    export PKG_CONFIG_SYSROOT_DIR=${STAGING_DIR_TARGET}
    oe_runmake
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

    install -d ${D}/usr/share/models
    install -m 0644 ${WORKDIR}/treefrog.ply ${D}/usr/share/models

    install -d ${D}/usr/share/X11/xkb
}

FILES_${PN} += " \
	    ${bindir} \
	    ${bindir}/toggle \
        /etc \
	    /etc/toggle/ui.json \
	    /etc/toggle/style/style.css \
        /etc/init.d \
        /etc/init.d/toggle.sh \
        ${systemd_unitdir}/system \
        ${systemd_unitdir}/system/toggle.service \
        /usr \
        /usr/share \
        /usr/share/models \
        /usr/share/models/treefrog.ply \
        /usr/share/X11/xkb \
"
