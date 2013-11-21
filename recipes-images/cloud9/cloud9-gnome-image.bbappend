# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    python-smbus \
    tty0tty-systemd \
    pasm \
"
# broken LIC_FILE_CHKSUM
IMAGE_IGNORE += "omap3-sgx-modules"

# currently broken:
# slic3r
# replicape
# pypruss

export IMAGE_BASENAME = "cloud9-gnome-thing-slic3r-image"

