include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

COMPATIBLE_MACHINE = "(beaglebone)"

inherit systemd

RPROVIDES_${PN} += "${PN}"
RREPLACES_${PN} += "${PN}"
RCONFLICTS_${PN} += "${PN}"
SYSTEMD_SERVICE_${PN} = "replicape.service"

do_compile () {
  :
}

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -d ${D}${systemd_unitdir}/system/replicape.d
    install -m 0644 ${S}/systemd/replicape.service ${D}${systemd_unitdir}/system
    sed -i 's:/etc/init.d/:${systemd_unitdir}/system/replicape.d/:g' ${D}${systemd_unitdir}/system/replicape.service
    install -m 0755 ${S}/systemd/replicape.sh ${D}${systemd_unitdir}/system/replicape.d/
    #systemctl enable replicape.service 
}

FILES_${PN} += " \
	    ${systemd_unitdir}/system/replicape.service \
	    ${systemd_unitdir}/system/replicape.d/replicape.sh \
"

