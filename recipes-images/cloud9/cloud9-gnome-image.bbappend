IMAGE_INSTALL += " \
    redeem \
    toggle \
"
BBMASK = "ltp-ddt_0.0.4.bb"

# currently broken:
# slic3r
#   perl-module-boost-geometry-utils

export IMAGE_BASENAME = "cloud9-gnome-thing-slic3r-image"

