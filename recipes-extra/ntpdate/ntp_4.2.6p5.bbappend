FILESEXTRAPATHS_prepend := "${THISDIR}/ntp:"

SRC_URI += "file://ntpdate.service.override \
            file://ntp.conf.override"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} += "ntpdate.service"

do_install_append(){
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/ntpdate.service.override ${D}${systemd_unitdir}/system/ntpdate.service
    install -m 0644 ${WORKDIR}/ntp.conf.override ${D}/etc/ntp.conf
}

FILES_${PN} +=" \
    ${systemd_unitdir}/system \
    ${systemd_unitdir}/system/ntpdate.service \
"
