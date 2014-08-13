DESCRIPTION = "Units to initialize usb gadgets"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

COMPATIBLE_MACHINE = "(beaglebone)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://multi-gadget-init.service \
           file://g-multi-load.sh \
"

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/*.sh ${D}${bindir}
}

FILES_${PN} = " \
    ${base_libdir}/systemd/system/multi-gadget-init.service \
    ${bindir}/g-multi-load.sh \
"
RDEPENDS_${PN} = "devmem2 bash bc"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "multi-gadget-init.service"
