include replicape.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .="/Device_tree"

do_compile () {
    dtc -O dtb -o BB-BONE-REPLICAP-00A1.dtbo -b 0 -@ BB-BONE-REPLICAP-00A1.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A2.dtbo -b 0 -@ BB-BONE-REPLICAP-00A2.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A3.dtbo -b 0 -@ BB-BONE-REPLICAP-00A3.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A4.dtbo -b 0 -@ BB-BONE-REPLICAP-00A4.dts
}

do_install () {
    install -d ${D}/lib/firmware/
    install -m 0644 ${S}/*.dtbo ${D}/lib/firmware/
    install -m 0644 ${S}/*.dts ${D}/lib/firmware/
}

FILES_${PN} = " \
    /lib/firmware/BB-BONE-REPLICAP-00A1.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A2.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A3.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A4.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A1.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-00A2.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-00A3.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-00A4.dtbo \
"

