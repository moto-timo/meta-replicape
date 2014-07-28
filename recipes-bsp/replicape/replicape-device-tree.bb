include replicape.inc


LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .="/Device_tree"

do_compile () {
    dtc -O dtb -o BB-BONE-REPLICAP-00A1.dtbo -b 0 -@ -I 3.12/BB-BONE-REPLICAP-00A1.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A2.dtbo -b 0 -@ -I 3.12/BB-BONE-REPLICAP-00A2.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A3.dtbo -b 0 -@ -I 3.12/BB-BONE-REPLICAP-00A3.dts
    dtc -O dtb -o BB-BONE-REPLICAP-00A4.dtbo -b 0 -@ -I 3.12/BB-BONE-REPLICAP-00A4.dts
    dtc -O dtb -o BB-BONE-REPLICAP-0A4A.dtbo -b 0 -@ -I 3.12/BB-BONE-REPLICAP-0A4A.dts
    dtc -O dtb -o BB-BONE-REACH-00A0.dtbo -b 0 -@ -I 3.12/BB-BONE-REACH-00A0.dts
}

do_install () {
    install -d ${D}/lib/firmware/
    install -m 0644 ${S}/*.dtbo ${D}/lib/firmware/
    install -m 0644 ${S}/3.12/*.dts ${D}/lib/firmware/
}

FILES_${PN} = " \
    /lib/firmware/BB-BONE-REPLICAP-00A1.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A2.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A3.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A4.dts \
    /lib/firmware/BB-BONE-REPLICAP-0A4A.dts \
    /lib/firmware/BB-BONE-REACH-00A0.dts \
    /lib/firmware/BB-BONE-REPLICAP-00A1.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-00A2.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-00A3.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-00A4.dtbo \
    /lib/firmware/BB-BONE-REPLICAP-0A4A.dtbo \
    /lib/firmware/BB-BONE-REACH-00A0.dtbo \
"

