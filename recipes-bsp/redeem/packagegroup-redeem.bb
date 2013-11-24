SUMMARY = "Redeem all-in-one"
LICENSE = "CC-BY-SA-2.0"

inherit packagegroup

RDEPENDS_${PN} = " \
    pasm \
    pypruss \
    redeem-firmware \
    redeem-libs \
    redeem-software \
    redeem-systemd \
    tty0tty \
    tty0tty-systemd \
"

