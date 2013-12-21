SUMMARY = "Framework for layout and rendering of internationalized text"
DESCRIPTION = "Pango is a library for laying out and rendering of text, \
with an emphasis on internationalization. Pango can be used anywhere \
that text layout is needed, though most of the work on Pango so far has \
been done in the context of the GTK+ widget toolkit. Pango forms the \
core of text and font handling for GTK+-2.x."
HOMEPAGE = "http://www.pango.org/"
BUGTRACKER = "http://bugzilla.gnome.org"
SECTION = "libs"
LICENSE = "LGPLv2.0+"

X11DEPENDS = "virtual/libx11 libxft"
DEPENDS = "glib-2.0 fontconfig freetype zlib virtual/libiconv cairo elfutils harfbuzz libpng"

PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}"
PACKAGECONFIG[x11] = "--with-x,--without-x,${X11DEPENDS}"

BBCLASSEXTEND = "native"
DEPENDS_class-native = "glib-2.0-native cairo-native harfbuzz-native"

PACKAGES_DYNAMIC += "^pango-module-.*"

RRECOMMENDS_${PN} = "${@base_contains('DISTRO_FEATURES', 'x11', 'pango-module-basic-x', '', d)} pango-module-basic-fc" 

inherit gnomebase gtk-doc qemu
# Create a pango-modules package
ALLOW_EMPTY_${BPN}-modules = "1"
PACKAGES += "${BPN}-modules"
RRECOMMENDS_${BPN}-modules =  "${@" ".join([p for p in d.getVar('PACKAGES', True).split() if p.find("pango-module") != -1])}"


EXTRA_AUTORECONF = ""

# seems to go wrong with default cflags
FULL_OPTIMIZATION_arm = "-O2"

EXTRA_OECONF = "--disable-glibtest \
		--enable-introspection \
		--enable-explicit-deps=no \
	        --disable-debug \
	        --with-mlprefix=${MLPREFIX}"

LEAD_SONAME = "libpango-1.0*"
LIBV = "1.8.0"

postinst_prologue() {
if ! [ -e $D${sysconfdir}/pango ] ; then
	mkdir -p $D${sysconfdir}/pango
fi

if [ "x$D" != "x" ]; then
	${@qemu_run_binary(d, '$D','${bindir}/${MLPREFIX}pango-querymodules')} \
		$D${libdir}/pango/${LIBV}/modules/*.so \
		> $D${sysconfdir}/pango/${MLPREFIX}pango.modules 2>/dev/null

	[ $? -ne 0 ] && exit 1

	sed -i -e "s:$D::" $D${sysconfdir}/pango/${MLPREFIX}pango.modules

	exit 0
fi
}

do_configure_append() {
	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/../build/Makefile	
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/../build/Makefile	
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/../build/Makefile 

	sed -i -e 's:INTROSPECTION_COMPILER = /usr/bin/g-ir-compiler:INTROSPECTION_COMPILER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-compiler:g' ${S}/../build/pango/Makefile	
	sed -i -e 's:INTROSPECTION_MAKEFILE = /usr/share/gobject-introspection-1.0/Makefile.introspection:INTROSPECTION_MAKEFILE = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/share/gobject-introspection-1.0/Makefile.introspection:' ${S}/../build/pango/Makefile	
	sed -i -e 's:INTROSPECTION_SCANNER = /usr/bin/g-ir-scanner:INTROSPECTION_SCANNER = /home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/g-ir-scanner:' ${S}/../build/pango/Makefile 
}


do_install_append () {
	if [ "${MLPREFIX}" != "" ]; then
		mv ${D}/${bindir}/pango-querymodules ${D}/${bindir}/${MLPREFIX}pango-querymodules 
	fi
}


python populate_packages_prepend () {
    prologue = d.getVar("postinst_prologue", True)

    modules_root = d.expand('${libdir}/pango/${LIBV}/modules')

    do_split_packages(d, modules_root, '^pango-(.*)\.so$', 'pango-module-%s', 'Pango module %s', prologue + '${bindir}/${MLPREFIX}pango-querymodules > /etc/pango/${MLPREFIX}pango.modules')
}

FILES_${PN} = "${sysconfdir}/pango/* ${bindir}/* ${libdir}/libpango*${SOLIBS}"
FILES_${PN}-dbg += "${libdir}/pango/${LIBV}/modules/.debug"
FILES_${PN}-dev += "${libdir}/pango/${LIBV}/modules/*.la \
  /usr/share/gir-1.0 \
  /usr/share/gir-1.0/PangoCairo-1.0.gir \
  /usr/share/gir-1.0/Pango-1.0.gir \
  /usr/share/gir-1.0/PangoXft-1.0.gir \
  /usr/share/gir-1.0/PangoFT2-1.0.gir \
  /usr/lib/girepository-1.0 \
  /usr/lib/girepository-1.0/PangoCairo-1.0.typelib \
  /usr/lib/girepository-1.0/PangoXft-1.0.typelib \
  /usr/lib/girepository-1.0/Pango-1.0.typelib \
  /usr/lib/girepository-1.0/PangoFT2-1.0.typelib \
"


