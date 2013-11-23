SUMMARY = "Replicape hardware support all-in-one"
LICENSE = "CC-BY-SA-2.0"

inherit packagegroup

RDEPNDS_${PN} = " \
    replicape-eeprom \
"
