require clutter-1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI[archive.md5sum] = "c613360105ab6057eaeadd06b3c90be5"
SRC_URI[archive.sha256sum] = "aaa5e9c6e62568b3daf5cc2a8161c0e6a095864b942ff2aaa8200eea9736f14d"

inherit g-ir

RDEPENDS_evdev += " libevdev libinput "

PACKAGECONFIG += " egl evdev "

EXTRA_OECONF := "${@oe_filter_out('--disable-introspection', '${EXTRA_OECONF}', d)}"
EXTRA_OECONF += "--enable-introspection	\
	    	"

# This setting causes "unknown option -f" on g-ir-scanner
do_compile_prepend(){
    sed -i s:-fvisibility=hidden::g ${S}/../build/clutter/Makefile
}

