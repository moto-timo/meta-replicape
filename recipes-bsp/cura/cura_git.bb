SUMMARY = "Slic3r takes 3D models (STL, OBJ, AMF) and converts them into G-code instructions for 3D printers."

DESCRIPTION = "Cura is developed in Python with a C++ engine. \
The part you are looking at right now is the Python GUI. The  \
C++ engine is responsible for generating the actual toolpath. \
For development of the engine check out https://github.com/Ultimaker/CuraEngine"

HOMEPAGE = "https://github.com/daid/Cura"

LICENSE = "AGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRC_URI = "git://github.com/daid/Cura.git;protocol=https;branch=SteamEngine \
file://cura.sh \
file://preferences.ini \
file://CuraConfig.ini \
"

RDEPENDS_${PN} += " wxpython"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git/Cura"

SRCREV = "a6745ea63bc8dc2b2eb007922ef94a18681a794d"

do_compile(){
}

do_install () {
    install -d ${D}/usr/src/cura/Cura/
    install -d ${D}/usr/src/cura/Cura/gui
    install -d ${D}/usr/src/cura/Cura/gui/tools
    install -d ${D}/usr/src/cura/Cura/gui/util
    install -d ${D}/usr/src/cura/Cura/avr_isp
    install -d ${D}/usr/src/cura/Cura/util
    install -d ${D}/usr/src/cura/Cura/util/meshLoaders
    install -d ${D}/usr/src/cura/Cura/util/printerConnection
    install -d ${D}/usr/src/cura/Cura/util/pymclevel
    install -m 0744 ${S}/*.py ${D}/usr/src/cura/Cura/
    install -m 0744 ${S}/gui/*.py ${D}/usr/src/cura/Cura/gui/
    install -m 0744 ${S}/gui/tools/*.py ${D}/usr/src/cura/Cura/gui/tools/
    install -m 0744 ${S}/gui/util/*.py ${D}/usr/src/cura/Cura/gui/util/
    install -m 0744 ${S}/avr_isp/*.py ${D}/usr/src/cura/Cura/avr_isp/
    install -m 0744 ${S}/util/*.py ${D}/usr/src/cura/Cura/util/
    install -m 0744 ${S}/util/meshLoaders/*.py ${D}/usr/src/cura/Cura/util/meshLoaders/
    install -m 0744 ${S}/util/printerConnection/*.py ${D}/usr/src/cura/Cura/util/printerConnection/
    install -m 0744 ${S}/util/pymclevel/*.py ${D}/usr/src/cura/Cura/util/pymclevel/

    #scripts
    install -d ${D}/etc/cura
    install -d ${D}/home/root/.cura/dev
    install -m 644 ${WORKDIR}/CuraConfig.ini ${D}/etc/cura/
    install -m 644 ${WORKDIR}/preferences.ini ${D}/home/root/.cura/dev/
    install -m 744 ${WORKDIR}/cura.sh ${D}/usr/src/cura/
}
    
FILES_${PN} += " \
	    /usr/src/cura/Cura/*.py \ 
	    /usr/src/cura/Cura/gui/*.py \
   	    /usr/src/cura/Cura/gui/tools/*.py \
   	    /usr/src/cura/Cura/gui/util/*.py \
        /usr/src/cura/Cura/util/*.py \
        /usr/src/cura/Cura/util/meshLoaders/*.py \
        /usr/src/cura/Cura/util/printerConnection/*.py \
        /usr/src/cura/Cura/util/pymclevel/*.py \
        /usr/src/cura/Cura/avr_isp/*.py \
        /usr/src/cura/cura.sh \
        /etc/cura/*.ini \
        /home/root/.cura/dev/preferences.ini \
"
