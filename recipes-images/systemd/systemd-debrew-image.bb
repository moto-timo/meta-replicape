require recipes-images/angstrom/systemd-image.bb

IMAGE_INSTALL += " \
    pasm \
    redeem \
    cura \
    octoprint \
    debrew-app \
    debrew-frontend \
    tty0tty \   
    python-numpy \
    ntp \
    devmem2 \
    pkgconfig \
    usb-gadget \
    udhcpd \
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
    libevdev \
    libinput \
    packagegroup-gnome-fonts \
    kernel-modules \
    libgirepository \ 
    python-pygobject \ 
    pango-gir \ 
    json-glib-gir \
    mash-gir \
    cogl-1.0-gir \
    clutter-1.0-gir \
    atk-gir \
    gdk-pixbuf \
    gdk-pixbuf-gir \
    mx-gir \
    kernel-devicetree-overlays \
    bash \
    bc \
    python-pip \
    libtool \
"
#libgirepository-dev
#    systemd-dev 
#    mash-dev 
#    mx-dev 
#   clutter-1.0-dev 


export IMAGE_BASENAME = "systemd-debrew-image"



