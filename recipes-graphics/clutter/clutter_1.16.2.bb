require recipes-graphics/clutter/clutter.inc
require recipes-graphics/clutter/clutter-package.inc

PR = "r3"

# We're API/ABI compatible and this may make things easier for layers
PROVIDES += "clutter"

EXTRA_OECONF += " --enable-debug=yes "

# This is built towards wayland, no X11 support
DEPENDS = "virtual/libgles2 pango glib-2.0 json-glib cogl atk libevdev"

#PACKAGES =+ "${PN}-examples"
#FILES_${PN}-examples = "${bindir}/test-* ${pkgdatadir}/redhand.png"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/clutter/1.16/clutter-1.16.2.tar.xz \
file://0001-compile-against-cogl-2-0.patch"

SRC_URI[md5sum] = "976614a2f7e60af088a0a460fe9d267e"
SRC_URI[sha256sum] = "0cb7e88c80f43fc7fb869fc6d34c42e98aa1a0ef7aa02e6aeef1b099ad33df42"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"
# because we've namespaced PN to clutter-1.8
#S = "${WORKDIR}/clutter-${PV}"

inherit g-ir

BASE_CONF = "--enable-wayland-backend=no \
			 --enable-x11-backend=no \
			 --enable-egl-backend=yes \
			 --disable-tests \
			 --disable-examples \
			 --with-flavour=eglnative \
			 --enable-tslib-input=no \
			 --enable-evdev-input=yes"

FILES_${PN} += " \
  /usr/share/gir-1.0 \
  /usr/share/gir-1.0/Cally-1.0.gir \
  /usr/share/gir-1.0/Clutter-1.0.gir \
  /usr/lib/girepository-1.0 \
  /usr/lib/girepository-1.0/Clutter-1.0.typelib \
  /usr/lib/girepository-1.0/Cally-1.0.typelib \
"


