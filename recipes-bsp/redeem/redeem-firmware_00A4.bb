include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "/firmware"

DEPENDS = "pasm-native"

FILENAME = "firmware_${PV}"

FILES_${PN} += " \
            ${bindir}/Replicape \
            ${bindir}/Replicape/firmware \
            ${bindir}/Replicape/firmware/${FILENAME}.bin \
            ${bindir}/Replicape/firmware/${FILENAME}.p \
"

do_compile () {
    pasm -b ${FILENAME}.p
}

do_install () {
    install -d ${D}${bindir}/Replicape/firmware
    install -m 0644 ${S}/${FILENAME}.p ${D}${bindir}/Replicape/firmware
    install -m 0644 ${S}/${FILENAME}.bin ${D}${bindir}/Replicape/firmware
}
