#require cloud9-gnome-image.bb
LICENSE = "MIT"

# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    python-smbus \
    tt0tty-systemd \
    pasm \
"
# currently broken:
# slic3r
# replicape
# pypruss

export IMAGE_BASENAME = "cloud9-gnome-thing-slic3r-image"

