
FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

SRC_URI += " \
    file://pvr.service \
"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "pvr.service"

do_install_append(){
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pvr.service ${D}${systemd_unitdir}/system

    # This gets deleted when inheriting systemd
	install -d ${D}${systemd_unitdir}/scripts/
	cp -pP ${WORKDIR}/rc.pvr ${D}${systemd_unitdir}/scripts/pvr-init
	chmod +x ${D}${systemd_unitdir}/scripts/pvr-init
}

FILES_${PN} += " \
        ${systemd_unitdir}/system \
        ${systemd_unitdir}/system/pvr.service \
        ${systemd_unitdir}/scripts/pvr-init \
"
