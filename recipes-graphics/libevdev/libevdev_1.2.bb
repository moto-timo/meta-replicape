DESCRIPTION = "Libevdev"
HOMEPAGE = "http://www.freedesktop.org/software/libevdev/"
LICENSE = "GPLv2"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig

SRC_URI = "http://www.freedesktop.org/software/libevdev/libevdev-${PV}.tar.xz"

SRC_URI[md5sum] = "220b17e015876cc045bddd891ab4fdc3"
SRC_URI[sha256sum] = "4195618067c01d915f67ad3034e89aaa597f5d548dbdd31fa12c569d4bf5a440"

LIC_FILES_CHKSUM = "file://COPYING;md5=75aae0d38feea6fda97ca381cb9132eb"
