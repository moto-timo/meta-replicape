# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    libprussdrv \
    pasm \
    pypruss \
    python-smbus \
    replicape-devicetree \
    tty0tty-systemd \
"
# currently broken:
# slic3r
# replicape

export IMAGE_BASENAME = "systemd-gnome-thing-slic3r-image"

