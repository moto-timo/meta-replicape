DESCRIPTION = "Libevdev"
HOMEPAGE = "http://www.freedesktop.org/software/libevdev/"
LICENSE = "GPLv2"

S = "${WORKDIR}/${PN}-${PV}"

DEPENDS += " mtdev "

inherit autotools pkgconfig



SRC_URI = "http://www.freedesktop.org/software/libinput/libinput-${PV}.tar.xz"

SRC_URI[md5sum] = "9aeb2e44c0f5e13c8cf1ce6bcdf29e83"
SRC_URI[sha256sum] = "349c63d8819ddfc1a35fc8bcf352256b952ae22b1ff370fd819a16f67e801ea7"

LIC_FILES_CHKSUM = "file://COPYING;md5=673e626420c7f859fbe2be3a9c13632d"

