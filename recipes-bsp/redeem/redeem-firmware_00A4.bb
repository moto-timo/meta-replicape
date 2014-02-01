include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "/firmware"

DEPENDS = "pasm-native"

FILENAME = "firmware_${PV}"

FILES_${PN} += " \
    /usr \
    /usr/src \
    /usr/src/redeem \
    /usr/src/redeem/firmware \
    /usr/src/redeem/firmware/${FILENAME}.bin \
    /usr/src/redeem/firmware/${FILENAME}.p \
"

do_compile () {
    pasm -b ${FILENAME}.p
}

do_install () {
    install -d ${D}/usr/src/redeem/firmware
    install -m 0644 ${S}/${FILENAME}.p ${D}/usr/src/redeem/firmware
    install -m 0644 ${S}/${FILENAME}.bin ${D}/usr/src/redeem/firmware
}
