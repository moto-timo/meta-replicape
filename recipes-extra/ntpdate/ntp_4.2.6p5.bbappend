SRC_URI += "file://ntpdate.service"

do_install_append(){
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/ntpdate.service ${D}${systemd_unitdir}/system
}

FILES_${PN} +=" \
    ${systemd_unitdir}/system \
    ${systemd_unitdir}/system/ntpdate.service \
"
