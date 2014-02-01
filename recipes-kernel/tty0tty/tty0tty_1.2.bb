# Released under the MIT license (see COPYING.MIT for the terms)

require tty0tty.inc

DESCRIPTION = "tty0tty - Linux null-modem emulator"
SUMMARY = "The Linux null-modem emulator (tty0tty) is a kernel-module virtual \
serial port driver for Linux. This creates virtual tty port pairs and uses \
any pair to connect one tty serial port based application to another. \
There is a version using pseudo-terminal (UNIX 98 style). \
"
SRC_URI += " \
    file://0004-use-fprint.patch \
    file://0002-Add-tty0tty.sh.patch \
    file://0003-Add-tty0tty.service.patch \
"


SYSTEMD_SERVICE_${PN} = "tty0tty.service"

# Only build the userspace app
do_compile () {
    cd pts
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/pts/tty0tty ${D}${bindir}/

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/tty0tty.service ${D}${systemd_unitdir}/system
    install -d ${D}/etc/init.d/
    install -m 0755 ${S}/tty0tty.sh ${D}/etc/init.d/tty0tty.sh
}

FILES_${PN} += " \
        /etc/ \
        /etc/init.d/ \
        /etc/init.d/tty0tty.sh  \
        ${systemd_unitdir}/system/tty0tty.service \
"
