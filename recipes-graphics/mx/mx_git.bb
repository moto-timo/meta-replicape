DESCRIPTION = "Clutter based widget library"
LICENSE = "LGPLv2.1"

S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=243b725d71bb5df4a1e5920b344b86ad \
                    file://mx/mx-widget.c;beginline=8;endline=20;md5=13bba3c973a72414a701e1e87b5ee879"

PR = "r1"

DEPENDS = "dbus-glib gdk-pixbuf startup-notification gtk-doc clutter-1.0"

inherit autotools gettext g-ir

SRC_URI = "git://github.com/clutter-project/mx;protocol=git;branch=master"
SRCREV = "63da1f2552c760916e7f7d66a20a51843f0523ef"

SRC_URI[md5sum] = "19b1e4918a5ae6d014fc0dab2bb3d0a1"
SRC_URI[sha256sum] = "1d2930d196717cacbee0ee101cf21d289b8200b5e938823d852b3b4a2f4a0e9d"

EXTRA_OECONF = "--enable-introspection \ 
                --disable-gtk-widgets \ 
                --with-dbus \
                --with-winsys=none \
                --disable-gtk-doc"

do_configure_prepend() {
    touch ${S}/gtk-doc.make
    sed -i -e 's:EXTRA_DIST +=:EXTRA_DIST =:' ${S}/docs/reference/libmx/Makefile.am
}

