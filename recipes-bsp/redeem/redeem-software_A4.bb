include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "software"

do_compile () {
    :
}

do_install () {
    :
}
do_install_append () {
    install -d ${D}/opt
    install -d ${D}/opt/Replicape
    install -d ${D}/opt/Replicape/software
    install -d ${D}/opt/Replicape/software/config
    install -m 0644 ${S}/*.py ${D}/opt/Replicape/software
    install -m 0644 ${S}/*.c ${D}/opt/Replicape/software
    install -m 0644 ${S}/*.pyx ${D}/opt/Replicape/software
    install -m 0755 ${S}/*.so ${D}/opt/Replicape/software
    install -m 0644 ${S}/config/*.cfg ${D}/opt/Replicape/software/config
    ln -s /opt/Replicape/software/config/Thing.cfg /opt/Replicape/software/config/default.cfg
}

FILES_${PN} += " \
	    /opt \
	    /opt/Replicape \
	    /opt/Replicape/software \
            /opt/Replicape/software/*.py \
            /opt/Replicape/software/*.pyx \
            /opt/Replicape/software/*.c \
	    /opt/Replicape/software/config \
            /opt/Replicape/software/config/*.cfg \
"
