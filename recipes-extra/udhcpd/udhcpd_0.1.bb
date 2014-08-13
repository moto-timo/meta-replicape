DESCRIPTION = "udhcpd to run after usb gadgets"

inherit systemd

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

COMPATIBLE_MACHINE = "(beaglebone)"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://udhcpd.service \
           file://udhcpd.conf \
           file://udhcpd.rules \
          "

do_install() {
	install -d ${D}${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/*.service ${D}${base_libdir}/systemd/system

	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*.conf ${D}${sysconfdir}
}

FILES_${PN} = " \
    ${sysconfdir}/udev/rules.d/udhcpd.rules \
    ${base_libdir}/systemd/system/udhcpd.service \
    ${sysconfdir}/udhcpd.conf \
"
RDEPENDS_${PN} = "usb-gadget"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "udhcpd.service"
