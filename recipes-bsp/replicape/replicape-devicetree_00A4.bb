SUMMARY = "Replicape is a 3D printer cape for BeagleBone"
DESCRIPTION = "Software written in Python for maintainability and hackability. \
\
Software features: \
- Accelleration with corner speed prediction. \
- Printer settings loaded from file (Version 0.4.2) \
- Controllable via ethernet, USB, printer display. \
"
HOMEPAGE = "http://wiki.replicape.com/index.php?title=Software"
SECTION = "devel"

LICENSE = "CC BY-SA 2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/replicape.git;protocol=https"
SRCREV = "d4ace928883656a1917968b97dca09609a9da4f8"

S = "${WORKDIR}/git"

FILES_${PN} = " \
    /lib/firmware/BB-BONE-REPLICAP-*.* \
    /lib/firmware/am335x-bone.dtb \
    /lib/firmware/am335x-boneblack.dtb \
"

do_compile () {
    dtc -O dtb -o BB-BONE-REPLICAP-00A1.dtbo -b 0 -@ ${S}/Device_tree/BB-BONE-REPLICAP-00A1.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A2.dtbo -b 0 -@ ${S}/Device_tree/BB-BONE-REPLICAP-00A2.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A3.dtbo -b 0 -@ ${S}/Device_tree/BB-BONE-REPLICAP-00A3.dts
    dtc -O dtb -o BB-BONE-REPLICAP-${PV}.dtbo -b 0 -@ ${S}/Device_tree/BB-BONE-REPLICAP-${PV}.dts
}

do_install () {
    install -d ${D}/lib/firmware
    install -m 0644 ${S}/Device_tree/BB-BONE-REPLICAP-*.* ${D}/lib/firmware
    install -m 0644 ${S}/BB-BONE-REPLICAP-*.* ${D}/lib/firmware
    install -m 0644 ${S}/Device_tree/am335x-*.dtb ${D}/lib/firmware
}
