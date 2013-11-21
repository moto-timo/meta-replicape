include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "/firmware"

DEPENDS = "pasm-native"

FILENAME = "firmware_${PV}"

FILES_${PN} += " \
            /opt \
            /opt/Replicape \
            /opt/Replicape/firmware \
            /opt/Replicape/firmware/${FILENAME}.bin \
            /opt/Replicape/firmware/${FILENAME}.p \
"

do_compile () {
    pasm -b ${FILENAME}.p
}

do_install () {
    install -d ${D}/opt/Replicape/firmware
    install -m 0644 ${S}/${FILENAME}.p ${D}/opt/Replicape/firmware
    install -m 0644 ${S}/${FILENAME}.bin ${D}/opt/Replicape/firmware
}
