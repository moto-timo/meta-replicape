include replicape.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .="/test"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "test-replicape.service"

do_install () {
    install -d ${D}/usr
    install -d ${D}/usr/src
    install -d ${D}/usr/src/replicape
    install -d ${D}/usr/src/replicape/test
    install -m 0644 ${S}/Replicape_0A4A.eeprom ${D}/usr/src/replicape/test
    install -m 0755 ${S}/test.py ${D}/usr/src/replicape/test

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/test-replicape.service ${D}${systemd_unitdir}/system
}

FILES_${PN} = " \
              /usr/src/replicape/test/Replicape_0A4A.eeprom \
              /usr/src/replicape/test/test-replicape.service \
              /usr/src/replicape/test/test.py \
"

