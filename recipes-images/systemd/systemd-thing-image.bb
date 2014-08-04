require recipes-images/angstrom/systemd-image.bb

IMAGE_INSTALL += " \
    pasm \
    redeem \
    toggle \
    cura \
    octoprint \
    replicape-device-tree \
    tty0tty \   
    python-numpy \
    ntp \
    devmem2 \
    pkgconfig \
    gadget-init \
    xkeyboard-config \
    gdk-pixbuf-loader-jpeg \
    gdk-pixbuf-loader-ico \
    gdk-pixbuf-loader-png \
    gnome-icon-theme \
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
    libgles-omap3 \    
    dtc \
    ca-certificates \
"

export IMAGE_BASENAME = "systemd-thing-image"



