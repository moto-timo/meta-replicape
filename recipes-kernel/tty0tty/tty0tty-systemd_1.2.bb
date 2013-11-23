include tty0tty.inc

SRC_URI += " \
        file://0002-Add-tty0tty.sh.patch \
        file://0003-Add-tty0tty.service.patch \
"
DEPEND += "tty0tty"

inherit systemd

RPROVIDES_${PN} += "${PN}"
RREPLACES_${PN} += "${PN}"
RCONFLICTS_${PN} += "${PN}"
SYSTEMD_SERVICE_${PN} = "tty0tty.service"

do_install_append () {
    
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/tty0tty.service ${D}${systemd_unitdir}/system
    install -d ${D}${systemd_unitdir}/system/tty0tty.d
    sed -i 's:/etc/init.d/:${systemd_unitdir}/system/tty0tty.d/:g' ${D}${system_unitdir}/system/tty0tty.service
    install -m 0755 ${S}/tty0tty.sh ${D}${system_unitdir}/system/tty0tty.d/tty0tty.sh
    #systemctl enable tty0tty.service
}

FILES_${PN} = " \
            ${systemd_unitdir}/system/tty0tty.service \
            ${systemd_unitdir}/system/tty0tty.d/tty0tty.sh  \
"
