DESCRIPTION = "a modern 3D graphics API with associated utility APIs"
HOMEPAGE = "http://wiki.clutter-project.org/wiki/Cogl"
LICENSE = "LGPLv2.1+"

STDDEPENDS = "pango glib-2.0 gdk-pixbuf"
BASE_CONF = "${@get_clutter_fpu_setting(bb, d)}"

DEPENDS = "${STDDEPENDS} virtual/libgles2"
EXTRA_OECONF = "${BASE_CONF} \ 
				--enable-gles2=yes \
				--enable-gl=no \ 
				--enable-glx=no \
				--enable-wgl=no \
				--enable-wayland-egl-platform=no \ 
				--enable-xlib-egl-platform=no \
				--enable-kms-egl-platform=no \
				--enable-null-egl-platform=yes \
                --with-gles2-libname=libGLESv2.so"

FILESPATH = "${FILE_DIRNAME}/cogl"

inherit autotools pkgconfig gtk-doc gettext

#check for TARGET_FPU=soft and inform configure of the result so it can disable some floating points
require clutter-fpu.inc

#Fix up some weirdness in the docs
do_configure_prepend() {
        sed -i s:doc/reference/Makefile::g ${S}/configure.ac
        sed -i s:doc::g ${S}/Makefile.am
}