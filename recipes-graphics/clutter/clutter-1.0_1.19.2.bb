require clutter-1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[archive.md5sum] = "6514496c9d5e244bebddb770ecda0061"
SRC_URI[archive.sha256sum] = "192506c26f51208d46ba1ee6a28105c30bf1b2a7dff29da184882a2e9f3e0f6b"

inherit g-ir

RDEPENDS_evdev += " libevdev "

PACKAGECONFIG += " egl evdev "

EXTRA_OECONF := "${@oe_filter_out('--disable-introspection', '${EXTRA_OECONF}', d)}"
EXTRA_OECONF += "--enable-introspection	\
	    	"

# This setting causes "unknown option -f" on g-ir-scanner
do_compile_prepend(){
    sed -i s:-fvisibility=hidden::g ${S}/../build/clutter/Makefile
}

SRC_URI += " \
        file://0001-Used-floating-point-instead-of-fixed-point-numbers.patch \
        file://0002-Update-after-libinput-API-changes.patch"
