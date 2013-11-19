include replicape.inc

inherit systemd

RPROVIDES_${PN} += "${PN}-systemd"
RREPLACES_${PN} += "${PN}-systemd"
RCONFLICTS_${PN} += "${PN}-systemd"
SYSTEMD_SERVICE_${PN} = "replicape.service"

do_install_append () {
    install -d ${D}/etc/init.d/
    install -m 0755 ${S}/systemd/replicape.sh ${D}/etc/init.d/
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/systemd/replicape.service ${D}${systemd_unitdir}/system
    #systemctl enable replicape.service 
}
