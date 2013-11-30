IMAGE_INSTALL += " \
    redeem \
    toggle \
"

# currently broken:
# slic3r
#   perl-module-boost-geometry-utils

# broken in angstrom-v2103.06-yocto-1.4
# python-spi
# pypruss

export IMAGE_BASENAME = "development-gnome-thing-slic3r-image"

