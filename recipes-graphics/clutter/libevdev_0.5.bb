DESCRIPTION = "Libevdev"
HOMEPAGE = "http://www.freedesktop.org/software/libevdev/"
LICENSE = "GPLv2"

# This is built towards wayland, no X11 support
#DEPENDS = "virtual/libgles2 libdrm pango glib-2.0 json-glib cogl atk"

#PACKAGES =+ "${PN}-examples"
#FILES_${PN}-examples = "${bindir}/test-* ${pkgdatadir}/redhand.png"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

SRC_URI = "http://www.freedesktop.org/software/libevdev/libevdev-0.5.tar.xz"

SRC_URI[md5sum] = "851ac31ff9b85591cbdc92724840a179"
SRC_URI[sha256sum] = "8a17b6912842b97df852f52e389ba69138c82605d4584204be9531b72d0d8bbb"

LIC_FILES_CHKSUM = "file://COPYING;md5=75aae0d38feea6fda97ca381cb9132eb"


#BASE_CONF = "--enable-wayland-backend=no \
#			 --enable-x11-backend=no \
#			 --enable-egl-backend=yes \
#			 --disable-tests \
#			 --disable-examples \
#			 --with-flavour=eglnative \
#			 --enable-tslib-input=yes \
#			 --enable-evdev-input=yes"

#FILES_${PN} += " \
#  /usr/lib/libevdev.so \
#  /usr/lib/share/gir-1.0/Cally-1.0.gir \
#  /usr/share/gir-1.0/Clutter-1.0.gir \
#  /usr/lib/girepository-1.0 \
#  /usr/lib/girepository-1.0/Clutter-1.0.typelib \
#  /usr/lib/girepository-1.0/Cally-1.0.typelib \
#"


