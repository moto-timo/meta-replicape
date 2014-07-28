require recipes-images/angstrom/systemd-image.bb

IMAGE_INSTALL += " \
    pasm \
    redeem \
    toggle \
    tty0tty \   
    cura \
    octoprint \
    kernel-module-bb-sgx \
    bb-sgx \
    bb-sgx-dev \
    replicape-device-tree \
    python-numpy \
    kernel-module-uio-pruss \
    ntp \
    devmem2 \
    pkgconfig \
    gadget-init \
    kernel-module-g-multi \
    xkeyboard-config \
    gdk-pixbuf-loader-jpeg \
    gdk-pixbuf-loader-ico \
    gdk-pixbuf-loader-png \
    gnome-icon-theme \
    kernel-modules \
    less \
    gcc \
    make \
    nano \
    coreutils \
    swig \
    python-dev \
    binutils \
    g++ \
    git \
    python-compile \
    wget \
    python-setuptools \
    lighttpd \
    sqlite3 \
    lighttpd-module-fastcgi \
    lighttpd-module-rewrite \
    lighttpd-module-alias \
    python-sqlite3 \
    connman-client \
    crda \
"

export IMAGE_BASENAME = "systemd-thing-image"



