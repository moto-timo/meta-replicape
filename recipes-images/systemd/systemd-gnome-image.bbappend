# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    pasm \
    pypruss \
    redeem-firmware \
    redeem-libs \
    replicape-devicetree \
    replicape-eeprom \
    tty0tty-systemd \
"
# currently broken:
#   slic3r -- paths issue
#     perl-module-boost-geometry-utils -- "Not a Hash" error
#   redeem-systemd -- tries to build more than intended
#   libprussdrv -- no .ipk package

export IMAGE_BASENAME = "systemd-gnome-thing-slic3r-image"

