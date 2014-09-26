SUMMARY = "3D-printer front end for embedded devices."

DESCRIPTION = "Toggle is a 3D-printer front end for use with embedded devices."

HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Toggle"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/toggle.git;protocol=https"
SRCREV = "a9ef3d39984dd5520e25fe3099f21c228e055902"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

RDEPENDS_${PN} += " \
    libtoggle \
    mx \
    mash \
"

inherit setuptools
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "toggle.service"

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

do_install_append(){
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/toggle.service ${D}${systemd_unitdir}/system
}

FILES_${PN} += " \
      ${systemd_unitdir}/system/toggle.service \
      /usr/share/models \
      /usr/share/models/ply \
      /usr/share/models/ply/*.ply \
      /etc/toggle/ui.json \
      /etc/toggle/platforms/thing.ply \
      /etc/toggle/style/style.css \
"

