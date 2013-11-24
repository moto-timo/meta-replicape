include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "software"

FILES_${PN} += " \
            /opt \
            /opt/Replicape \
            /opt/Replicape/software \
            /opt/Replicape/software/config \
"
do_compile () {
    python setup.py build
}

do_install_append () {
    install -d ${D}/opt
    install -d ${D}/opt/Replicape
    install -d ${D}/opt/Replicape/software
    install -d ${D}/opt/Replicape/software/config
    install -m 0644 ${S}/*.py ${D}/opt/Replicape/software
    install -m 0644 ${S}/*.c ${D}/opt/Replicape/software
    install -m 0755 ${S}/braid.so ${D}/opt/Replicape/software
    install -m 0755 ${S}/braid.pyx ${D}/opt/Replicape/software
    install -m 0644 ${S}/config/*.cfg ${D}/opt/Replicape/software/config
}
