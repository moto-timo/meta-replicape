
LICENSE = "LGPLv2.1+"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/clutter-project/mash;protocol=git;branch=master"
SRCREV = "0fa700283a47253fa7ea005fa8c7279bf9958530"

LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=fbc093901857fcd118f065f900982c24"

inherit autotools pkgconfig gtk-doc gettext g-ir

CFLAGS_prepend = "-I${STAGING_DIR_NATIVE}/usr/include/glib-2.0 "
GIR_EXTRA_SCANNER_ARGS += " --libtool "
#GIR_EXTRA_LIBS_PATH = "./.libs"

#FILES_${PN} += " \
#  /usr/share \
#  /usr/share/gir-1.0 \
#  /usr/share/gir-1.0/Mash-0.2.gir \
#  /usr/lib/girepository-1.0 \
#  /usr/lib/girepository-1.0/Mash-0.2.typelib \
#"
