# Image with redeem, toggle, and hw tools installed

require recipes-graphics/images/core-image-weston.bb

ROOTFSTYPE_beaglebone = "ext4"

IMAGE_INSTALL += " \
	systemd-analyze \
	packagegroup-sdk-target \
	led-config \
	cronie-systemd ntpdate \
	nano \
	hicolor-icon-theme \
	tar \
	gdb gdbserver \
	connman-tests \
	rsync \
        libwayland-egl \
        cogl-1.0 \
        clutter-1.0 \
        libgles-omap3 \
        omap3-sgx-modules \
        wxpython \
        redeem \
        toggle \
"

export IMAGE_BASENAME = "Redeem-base"

