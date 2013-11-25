# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    libprussdrv \
    pasm \
    pypruss \
    python-pyopengl \
    python-spi \
    redeem-firmware \
    redeem-systemd \
    tty0tty-systemd \
"
# currently broken:
#   slic3r -- paths issue
#     perl-module-boost-geometry-utils -- "Not a Hash" error

export IMAGE_BASENAME = "systemd-gnome-thing-slic3r-image"

