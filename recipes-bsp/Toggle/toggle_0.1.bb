SUMMARY = "3D-printer front end for embedded devices."

DESCRIPTION = "Toggle is a 3D-printer front end for use with embedded devices. It's a perfect fit for the BeagleBone Black/Replicape/Manga Screen combo."

HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Toggle"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/toggle.git;protocol=https"
SRCREV = "d34f369fe47bb3224570739eb0b71f5ca29822a3"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = " \
	python-pyserial \
"

do_install_append () {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/toggle
    install -m 0644 ${S}/*.py ${D}${bindir}/toggle
}

FILES_${PN} += " \
	    ${bindir}/toggle \
	    ${bindir}/toggle/Toggle.py \
"
