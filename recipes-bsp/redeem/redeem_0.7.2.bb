include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

S .= "/software"

DEPENDS = " python \
			redeem-libs \
			redeem-firmware \
"
RDEPENDS_${PN} = "python-core"

FILES_${PN} += " \
            ${D}/opt \
            ${D}/opt/Replicape \
            ${D}/opt/Replicape/software/*.py \
            ${D}/opt/Replicape/software/*.so \
            ${D}/opt/Replicape/software/config \
            ${D}/opt/Replicape/software/config/Thing.cfg \
"
inherit distutils

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_install_append() {
  rm -f ${D}${libdir}/python*/site-packages/site.py*
  install -d ${D}/opt/Replicape/software
  install -m 0644 ${S}/*.py ${D}/opt/Replicape/software/
  install -d ${D}/opt/Replicape/software/config/
  install -m 0644 ${S}/config/Thing.cfg ${D}/opt/Replicape/software/config/
}
