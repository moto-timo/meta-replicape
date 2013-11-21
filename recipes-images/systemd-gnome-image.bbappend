# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    libprussdrv \
    pasm \
    pypruss \
    python-smbus \
    redeem-firmware \
    redeem-libs \
    replicape-devicetree \
    replicape-eeprom \
    tty0tty-systemd \
"
# currently broken:
#   slic3r
#     perl-module-boost-geometry-utils
#   redeem-systemd

export IMAGE_BASENAME = "systemd-gnome-thing-slic3r-image"

