include replicape.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .="/eeprom"

DEPENDS = "nodejs"

do_compile () {
    node ./eeprom.js -w replicape_${PV}.json
}

do_install () {
    install -d ${D}/sys/bus/i2c/drivers/at24/1-0054
    cp ${S}/Replicape.eeprom ${S}/eeprom
    install -m 0644 ${S}/eeprom ${D}/sys/bus/i2c/drivers/at24/1-0054/
}



FILES_${PN} = " \
              /usr \
              /usr/src/ \
              /usr/src/replicape \
              /usr/src/replicape/replicape_${PV}.json \
              /usr/src/replicape/Replicape.eeprom \
              /usr/src/replicape/device_tree \
"

