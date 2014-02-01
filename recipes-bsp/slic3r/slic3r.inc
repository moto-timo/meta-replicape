SUMMARY = "Slic3r takes 3D models (STL, OBJ, AMF) and converts them into G-code instructions for 3D printers."

DESCRIPTION = " \
Slic3r takes 3D models (STL, OBJ, AMF) and converts them into G-code \ 
instructions for 3D printers. It's compatible with any modern printer \ 
based on the RepRap toolchain, including all those based on the Marlin, \ 
Sprinter and Repetier firmware. It also works with Mach3 and LinuxCNC controllers."

HOMEPAGE = "http://slic3r.org/"
SECTION = "devel"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://xs/src/admesh/connect.c;beginline=2;endline=16;md5=4941821d7b405e487db96d189c527d77"

SRC_URI = "git://github.com/alexrj/Slic3r.git;protocol=https"
SRCREV = "42519174cd2b4e9c55e38bc0d4a46ff3345679a9"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"
