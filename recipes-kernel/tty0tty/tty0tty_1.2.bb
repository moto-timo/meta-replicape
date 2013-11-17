# Released under the MIT license (see COPYING.MIT for the terms)

require tty0tty.inc

DESCRIPTION = "tty0tty - Linux null-modem emulator"
SUMMARY = "The Linux null-modem emulator (tty0tty) is a kernel-module virtual \
serial port driver for Linux. This creates virtual tty port pairs and uses \
any pair to connect one tty serial port based application to another. \
There is a version using pseudo-terminal (UNIX 98 style). \
"

DEPENDS = "tty0tty-module"

# Only build the userspace app
do_compile () {
    cd pts
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/pts/tty0tty ${D}${bindir}/
}

RDEPENDS_${PN} = "kernel-module-tty0tty"

