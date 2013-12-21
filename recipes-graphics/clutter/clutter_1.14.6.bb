require recipes-graphics/clutter/clutter.inc
require recipes-graphics/clutter/clutter-package.inc

PR = "r2"

# We're API/ABI compatible and this may make things easier for layers
PROVIDES += "clutter"

# This is built towards wayland, no X11 support
DEPENDS = "virtual/libgles2 libdrm pango glib-2.0 json-glib cogl atk"

PACKAGES =+ "${PN}-examples"
#FILES_${PN}-examples = "${bindir}/test-* ${pkgdatadir}/redhand.png"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/clutter/1.14/clutter-${PV}.tar.xz \
	       file://0000-remove-backend-stuff.patch"
SRC_URI[md5sum] = "588beff1db97f67f0a30989a28516d4e"
SRC_URI[sha256sum] = "bbfac240e22f41a4f21dd0de6b697abcde198c911a612179ec52ecf11ded07fa"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"
# because we've namespaced PN to clutter-1.8
S = "${WORKDIR}/clutter-${PV}"

do_configure_append() {
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/clutter/Makefile	
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/clutter/Makefile	
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/clutter/Makefile 
}

BASE_CONF = "--enable-wayland-backend=yes \
			 --enable-x11-backend=no \
			 --disable-tests \
			 --disable-examples \
"

FILES_${PN} += " \
  /usr/share/gir-1.0 \
  /usr/share/gir-1.0/Cally-1.0.gir \
  /usr/share/gir-1.0/Clutter-1.0.gir \
  /usr/lib/girepository-1.0 \
  /usr/lib/girepository-1.0/Clutter-1.0.typelib \
  /usr/lib/girepository-1.0/Cally-1.0.typelib \
"


