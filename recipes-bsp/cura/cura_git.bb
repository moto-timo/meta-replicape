include cura.inc

#SRCREV = "1ebe4315c39b1be9d56e85a95b528d9594d5b9fb"
SRCREV = "4c1043f69a5f418cf1c9d3034bdf5d670d732a00"

do_compile(){
    sed -i "s:--static::g" Makefile
    sed -i "s:-flto::g" Makefile
    make 
}

do_install_append () {
    install -d ${D}${bindir}
    install -m 0744 ${S}/build/CuraEngine ${D}${bindir}
}
    
FILES_${PN} += " \
	    ${bindir}/CuraEngine \
"
