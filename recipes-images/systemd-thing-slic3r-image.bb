require systemd-gnome-image.bb

IMAGE_INSTALL += " \
	slic3r \
        replicape \
        pypruss \
"

export IMAGE_BASENAME = "systemd-thing-slic3r-image"

