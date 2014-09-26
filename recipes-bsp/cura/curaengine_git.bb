SUMMARY = "Slic3r takes 3D models (STL, OBJ, AMF) and converts them into G-code instructions for 3D printers."

DESCRIPTION = " \
Slic3r takes 3D models (STL, OBJ, AMF) and converts them into G-code \ 
instructions for 3D printers. It's compatible with any modern printer \ 
based on the RepRap toolchain, including all those based on the Marlin, \ 
Sprinter and Repetier firmware. It also works with Mach3 and LinuxCNC controllers."

HOMEPAGE = "http://slic3r.org/"

LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "git://github.com/Ultimaker/CuraEngine.git;protocol=https"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"

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
