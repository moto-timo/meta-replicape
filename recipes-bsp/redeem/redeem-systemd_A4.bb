include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

COMPATIBLE_MACHINE = "(beaglebone)"

inherit systemd

RPROVIDES_${PN} += "${PN}"
RREPLACES_${PN} += "${PN}"
RCONFLICTS_${PN} += "${PN}"
SYSTEMD_SERVICE_${PN} = "replicape.service"

FILES_${PN} += " \
            /etc \
            /etc/init.d \
            /etc/init.d/replicape.sh \
"

do_compile () {
  :
}

do_install_append () {
    install -d ${D}/etc/init.d/
    install -m 0755 ${S}/systemd/replicape.sh ${D}/etc/init.d/
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/systemd/replicape.service ${D}${systemd_unitdir}/system
    #systemctl enable replicape.service 
}
