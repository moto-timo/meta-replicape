include tty0tty.inc

SRC_URI += " \
        file://0002-Add-tty0tty.sh.patch \
        file://0003-Add-tty0tty.service.patch \
"
DEPEND += "tty0tty"

inherit systemd

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "tty0tty.service"

do_install_append () {
    install -d ${D}/etc/init.d/
    install -m 0755 ${S}/tty0tty.sh ${D}/etc/init.d/
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/tty0tty.service ${D}${systemd_unitdir}/system
    #systemctl enable tty0tty.service
}
