SUMMARY = "3D-printer front end for embedded devices."

DESCRIPTION = "Toggle is a 3D-printer front end for use with embedded devices."

HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Toggle"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/toggle.git;protocol=https"
SRCREV = "a9ef3d39984dd5520e25fe3099f21c228e055902"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git/toggle-lib"

NAMESPACE = "Toggle"
NSVERSION = "0.1"
GIR_FILE = "${NAMESPACE}-${NSVERSION}.gir"
TYPELIB_FILE = "${NAMESPACE}-${NSVERSION}.typelib"

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

CFLAGS_append = " `pkg-config --cflags gobject-2.0 glib-2.0 clutter-1.0 mash-0.2 pango cairo mx-2.0` -g "
LDFLAGS_append = " `pkg-config --libs gobject-2.0 glib-2.0 clutter-1.0 mash-0.2 pango cairo mx-2.0` "

inherit pkgconfig

do_compile(){
    export PKG_CONFIG_LIBDIR=${STAGING_DIR_TARGET}/usr/lib/pkgconfig
    export PKG_CONFIG_SYSROOT_DIR=${STAGING_DIR_TARGET}
    export LIBTOOL=${STAGING_DIR_TARGET}/usr/bin/crossscripts/arm-angstrom-linux-gnueabi-libtool
    export GIR_SCANNER_ARGS=" --libtool=${STAGING_DIR_TARGET}/usr/bin/crossscripts/arm-angstrom-linux-gnueabi-libtool "
    oe_runmake
}

do_install () {
    install -d ${D}/usr/lib/girepository-1.0
    install -d ${D}/usr/share/gir-1.0
    install -d ${D}/usr/lib
    install -m 0644 ${S}/${TYPELIB_FILE} ${D}/usr/lib/girepository-1.0
    install -m 0644 ${S}/${GIR_FILE} ${D}/usr/share/gir-1.0
    install -m 0644 ${S}/.libs/*.so* ${D}/usr/lib
}

FILES_${PN} += " \
        /usr/lib/girepository-1.0 \
        /usr/lib/girepository-1.0/Toggle-0.1.typelib \
"
FILES_${PN}-dev += " \
        /usr/share \
        /usr/share/gir-1.0 \
        /usr/share/gir-1.0/Toggle-0.1.gir \
"

