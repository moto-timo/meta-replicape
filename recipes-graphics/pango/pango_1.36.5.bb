require pango.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"

inherit g-ir

GNOME_COMPRESS_TYPE="xz"

SRC_URI += "file://no-tests.patch \
            file://multilib-fix-clean.patch \
"

SRC_URI[archive.md5sum] = "2500930093c3ed38acb40e4255bce2f1"
SRC_URI[archive.sha256sum] = "be0e94b2e5c7459f0b6db21efab6253556c8f443837200b8736d697071276ac8"

do_configure_append() {
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = ${STAGING_DIR_NATIVE}/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/../build/Makefile	
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = ${STAGING_DIR_TARGET}/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/../build/Makefile	
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = ${STAGING_DIR_NATIVE}/usr/bin/armv7at2hf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/../build/Makefile 
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = ${STAGING_DIR_NATIVE}/usr/bin/armv7at2hf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/../build/pango/Makefile	
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = ${STAGING_DIR_TARGET}/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/../build/pango/Makefile	
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = ${STAGING_DIR_NATIVE}/usr/bin/armv7at2hf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/../build/pango/Makefile 
}

