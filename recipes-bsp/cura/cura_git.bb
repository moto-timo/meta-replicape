include cura.inc

SRC_URI[md5sum] = "6b09dc8960eeb0b6a5de41d4e644bfa8"
SRC_URI[sha256sum] = "750c9ee01dd5468dae403af1daac25862e8a5644bb412f2f6022d76e7d7f639e"

do_compile(){
    sed -i "s:--static::g" Makefile
    make 
}

do_install_append () {
    install -d ${D}${bindir}
    install -m 0744 ${S}/CuraEngine ${D}${bindir}
}
    
FILES_${PN} += " \
	    ${bindir}/CuraEngine \
"
