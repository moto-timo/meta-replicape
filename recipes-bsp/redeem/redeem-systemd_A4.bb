include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

COMPATIBLE_MACHINE = "(beaglebone)"

inherit systemd

RPROVIDES_${PN} += "${PN}"
RREPLACES_${PN} += "${PN}"
RCONFLICTS_${PN} += "${PN}"
SYSTEMD_SERVICE_${PN} = "redeem.service"

do_compile () {
  :
}

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -d ${D}${systemd_unitdir}/system/redeem.d
    install -m 0644 ${S}/systemd/redeem.service ${D}${systemd_unitdir}/system
    sed -i 's:/etc/init.d/:${systemd_unitdir}/system/redeem.d/:g' ${D}${systemd_unitdir}/system/redeem.service
    install -m 0755 ${S}/systemd/redeem.sh ${D}${systemd_unitdir}/system/redeem.d/
}

FILES_${PN} += " \
	    ${systemd_unitdir}/system/redeem.service \
	    ${systemd_unitdir}/system/redeem.d/redeem.sh \
"

