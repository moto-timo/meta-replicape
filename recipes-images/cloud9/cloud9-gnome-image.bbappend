# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    libprussdrv \
    pasm \
    pypruss \
    python-pyopengl \
    python-spi \
    redeem-systemd \
    redeem-firmware \
    tty0tty-systemd \
"

# currently broken:
# slic3r
#   perl-module-boost-geometry-utils

export IMAGE_BASENAME = "cloud9-gnome-thing-slic3r-image"

