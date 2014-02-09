require cogl.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

# the introspection-next tag
SRCREV = "7f745cc8b496c1c1fc397641050e52b95a3d6200"
PV = "2.0+git${SRCPV}"
PR = "r4"

DEFAULT_PREFERENCE = "1"

DEPENDS_${PN} += "virtual/libgles1 virtual/libgles2 virtual/egl"

SRC_URI = "git://git.gnome.org/cogl;protocol=git;branch=lionel/introspection-next"
S = "${WORKDIR}/git"

GIR_EXTRA_LIBS_PATH = "../cogl/.libs"

inherit g-ir

do_configure_prepend() {
	sed -i -e 's:EXTRA_DIST +=:EXTRA_DIST =:g' ${S}/doc/reference/cogl-gst/Makefile.am
	sed -i -e 's:EXTRA_DIST +=:EXTRA_DIST =:g' ${S}/doc/reference/cogl-2.0-experimental/Makefile.am
	sed -i -e 's:EXTRA_DIST +=:EXTRA_DIST =:g' ${S}/doc/reference/cogl/Makefile.am
    touch ${S}/gtk-doc.make
}

do_compile_prepend(){
    sed -i "s:#ifndef EGL_KHR_create_context:#ifndef EGL_KHR_create_context\n#define EGL_SYNC_FENCE_KHR 0x30F9:" ${S}/cogl/winsys/cogl-winsys-egl.c
}

AUTOTOOLS_AUXDIR = "${S}/build"

# Add this to extraargs -L/home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/work/armv7ahf-vfp-neon-angstrom-linux-gnueabi/cogl/2.0+gitAUTOINC+7f745cc8b496c1c1fc397641050e52b95a3d6200-r4/build/cogl/.libs/
# /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner

FILES_${PN} += " \
  /usr/share/gir-1.0 \
  /usr/share/gir-1.0/CoglPango-2.0.gir \
  /usr/share/gir-1.0/Cogl-2.0.gir \
  /usr/share/gir-1.0/Cogl-1.0.gir \
  /usr/share/gir-1.0/CoglPango-1.0.gir \
  /usr/lib/girepository-1.0 \
  /usr/lib/girepository-1.0/Cogl-2.0.typelib \
  /usr/lib/girepository-1.0/CoglPango-2.0.typelib \
  /usr/lib/girepository-1.0/CoglPango-1.0.typelib \
  /usr/lib/girepository-1.0/Cogl-1.0.typelib \
"


# EGL_SYNC_FENCE_KHR                      0x30F9
