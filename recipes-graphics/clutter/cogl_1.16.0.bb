require cogl.inc

PR = "r3"

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/cogl/1.16/cogl-1.16.0.tar.xz \
	   file://macro-versions.patch"

SRC_URI[md5sum] = "611a61bed04354cbfffa3dc27feb6d4f"
SRC_URI[sha256sum] = "75c2c4636a050fda7ee8722ce3d9c618b08799ed92bbb72b4fdff3e73b096094"

#Fix up some weirdness in the docs
do_configure_prepend() {
	sed -i s:doc/reference/Makefile::g ${S}/configure.ac
	sed -i s:doc::g ${S}/Makefile.am
}

do_configure_append() {
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/../build/cogl/Makefile
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/../build/cogl/Makefile
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/../build/cogl/Makefile 
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/../build/cogl-pango/Makefile
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/../build/cogl-pango/Makefile
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/../build/cogl-pango/Makefile 
}

FILES_${PN} += " \
	/usr/share/gir-1.0 \
	/usr/share/gir-1.0/Cogl-1.0.gir \
	/usr/share/gir-1.0/CoglPango-1.0.gir \
	/usr/lib/girepository-1.0 \
	/usr/lib/girepository-1.0/CoglPango-1.0.typelib \
	/usr/lib/girepository-1.0/Cogl-1.0.typelib \
"


