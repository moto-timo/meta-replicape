
LICENSE = "LGPLv2.1+"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/clutter-project/mash;protocol=git;branch=master"
SRCREV = "0fa700283a47253fa7ea005fa8c7279bf9958530"

LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=fbc093901857fcd118f065f900982c24"

inherit autotools pkgconfig gtk-doc gettext

# The following is necessary to get the path of the g-ir stuff right
SCANNER_ENV = "PKG_CONFIG=${STAGING_DIR_NATIVE}${bindir_native}/pkg-config PKG_CONFIG_PATH=${PKG_CONFIG_PATH} PKG_CONFIG_LIBDIR=${PKG_CONFIG_LIBDIR}"
SCANNER_ARGS = "--library-path=${STAGING_DIR_HOST}${libdir}"

do_configure_prepend () {
    sed -i -e "s|INTROSPECTION_SCANNER_ENV=.*|INTROSPECTION_SCANNER_ENV=\"${SCANNER_ENV}\"|" \
    	   -e "s|INTROSPECTION_SCANNER_ARGS=.*|INTROSPECTION_SCANNER_ARGS=\"${SCANNER_ARGS}\"|" \
    	   -e "s|GOBJECT_INTROSPECTION_LIBDIR=\"|GOBJECT_INTROSPECTION_LIBDIR=\"${STAGING_DIR_HOST}/|" \
        ${S}/configure.ac
}

do_configure_append() {
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = ${STAGING_DIR_NATIVE}/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/Makefile
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = ${STAGING_DIR_TARGET}/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/Makefile
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = ${STAGING_DIR_NATIVE}/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/Makefile 
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = ${STAGING_DIR_NATIVE}/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/mash/Makefile
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = ${STAGING_DIR_TARGET}/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/mash/Makefile  
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = ${STAGING_DIR_NATIVE}/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/mash/Makefile 
}


FILES_${PN} += " \
  /usr/share \
  /usr/share/gir-1.0 \
  /usr/share/gir-1.0/Mash-0.2.gir \
  /usr/lib/girepository-1.0 \
  /usr/lib/girepository-1.0/Mash-0.2.typelib \
"
