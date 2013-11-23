include tty0tty.inc

SRC_URI += " \
        file://0002-Add-tty0tty.sh.patch \
        file://0003-Add-tty0tty.service.patch \
"
DEPEND += "tty0tty"

inherit systemd update-rc.d

RPROVIDES_${PN} += "${PN}"
RREPLACES_${PN} += "${PN}"
RCONFLICTS_${PN} += "${PN}"
SYSTEMD_SERVICE_${PN} = "tty0tty.service"

INITSCRIPT_NAME = "tty0tty.sh"
INITSCRIPT_PARAMS = "default tbd tbd"

do_install_append () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/tty0tty.sh ${D}${sysconfdir}/init.d/tty0tty.sh
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/tty0tty.service ${D}${systemd_unitdir}/system
    #systemctl enable tty0tty.service
}

FILES_${PN} = " \
            ${systemd_unitdir}/system/tty0tty.service \
            ${sysconfdir}/init.d/tty0tty.sh  \
"
