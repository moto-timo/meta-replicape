require cogl-1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=1b1a508d91d25ca607c83f92f3e31c84"

SRC_URI[archive.md5sum] = "952155d526d35f297737266408e842b5"
SRC_URI[archive.sha256sum] = "9278e519d5480eb0379efd48db024e8fdbf93f01dff48a7e756b85b508a863aa"

PACKAGECONFIG += " egl-null gles2 cogl-pango "

GIR_EXTRA_LIBS_PATH = "../cogl/.libs"

EXTRA_OECONF += "  "

inherit g-ir

CFLAGS_append = " -DEGL_SYNC_FENCE_KHR=0x30F9 "

PACKAGES =+ " libcogl-path libcogl-path-dev"
FILES_libcogl-path = "${libdir}/libcogl-path${SOLIBS}"
FILES_libcogl-path-dev = "${includedir}/cogl/cogl-path \
                           ${libdir}/libcogl-path${SOLIBSDEV} \
                           ${libdir}/libcogl-path.la \
                           ${libdir}/pkgconfig/cogl-path-1.0.pc"

PROVIDES += " libcogl-pango libcogl-path "
PROVIDES += " libcogl-pango15 libcogl-path15 "
