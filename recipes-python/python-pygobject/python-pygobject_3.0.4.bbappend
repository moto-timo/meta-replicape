do_configure_prepend () {
    sed -i -e "s|SUBDIRS = examples gi tests|SUBDIRS = examples gi|" ${S}/Makefile.am
}

