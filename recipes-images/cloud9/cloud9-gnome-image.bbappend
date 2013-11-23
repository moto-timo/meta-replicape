# python-smbus include i2c-tools
IMAGE_INSTALL += " \
    libprussdrv \
    pasm \
    python-smbus \
    pypruss \
    redeem-systemd \
    redeem-firmware \
    tty0tty-systemd \
"
# broken LIC_FILE_CHKSUM
IMAGE_IGNORE += "omap3-sgx-modules"

# currently broken:
# slic3r

export IMAGE_BASENAME = "cloud9-gnome-thing-slic3r-image"

