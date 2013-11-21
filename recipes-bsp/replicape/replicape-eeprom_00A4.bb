include replicape.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .="/eeprom"

DEPENDS = "nodejs"

FILES_${PN} = " \
              /sys \
              /sys/bus \
              /sys/bus/i2c \
              /sys/bus/i2c/drivers \
              /sys/bus/i2c/drivers/at24 \
              /sys/bus/i2c/drivers/at24/1-0054 \
              /sys/bus/i2c/drivers/at24/1-0054/eeprom \
"

do_compile () {
    node ./eeprom.js -w replicape_${PV}.json
}

do_install () {
    install -d ${D}/sys/bus/i2c/drivers/at24/1-0054
    cp ${S}/Replicape.eeprom ${S}/eeprom
    install -m 0644 ${S}/eeprom ${D}/sys/bus/i2c/drivers/at24/1-0054/
}


