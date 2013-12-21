require cogl.inc

PR = "r3"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/cogl/1.16/cogl-1.16.0.tar.xz \
	   file://macro-versions.patch"

SRC_URI[md5sum] = "611a61bed04354cbfffa3dc27feb6d4f"
SRC_URI[sha256sum] = "75c2c4636a050fda7ee8722ce3d9c618b08799ed92bbb72b4fdff3e73b096094"

EXTRA_OECONF += "INTROSPECTION_MAKEFILE=/usrs/iagent/usr/share/gobject-introspection-1.0/Makefile.introspection"

#Fix up some weirdness in the docs
do_configure_prepend() {
        sed -i s:doc/reference/Makefile::g ${S}/configure.ac
        sed -i s:doc::g ${S}/Makefile.am
}


#do_install_append () {
#  install -d ${D}${sharedir}/gir-1.0
#  install -d ${D}${libdir}/girepository-1.0
#  install -m 0644 ${S}/../build/cogl/*.gir ${D}${sharedir}/gir-1.0/
#  install -m 0644 ${S}/../build/cogl-pango/*.gir ${D}${sharedir}/gir-1.0/
#  install -m 0644 ${S}/../build/cogl/*.typelib ${D}${libdir}/girepository-1.0/
#  install -m 0644 ${S}/../build/cogl-pango/*.typelib ${D}${libdir}/girepository-1.0/
#}

FILES_${PN} += " \
  /usr/share/gir-1.0 \
  /usr/share/gir-1.0/Cogl-1.0.gir \
  /usr/share/gir-1.0/CoglPango-1.0.gir \
  /usr/lib/girepository-1.0 \
  /usr/lib/girepository-1.0/CoglPango-1.0.typelib \
  /usr/lib/girepository-1.0/Cogl-1.0.typelib \
"

#INTROSPECTION_COMPILER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler
#INTROSPECTION_GENERATE = /usr/bin/g-ir-generate
#INTROSPECTION_GIRDIR = /usr/share/gir-1.0
#INTROSPECTION_LIBS = -lgirepository-1.0 -lgobject-2.0 -lglib-2.0  
#INTROSPECTION_MAKEFILE = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/share/gobject-introspection-1.0/Makefile.introspection
#INTROSPECTION_SCANNER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner
#INTROSPECTION_TYPELIBDIR = /usr/lib/girepository-1.0

