DESCRIPTION = "Streaming HTTP server for UVC webcam feeds"
HOMEPAGE = "http://mjpg-streamer.sourceforge.net/"
DEPENDS += " jpeg imagemagick "

LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"
LICENSE = "GPLv2"

#PV="svn"
PR = "r0"


SRC_URI = "svn://svn.code.sf.net/p/mjpg-streamer/code/;module=mjpg-streamer;protocol=https \
file://mjpg-streamer.service \
file://mjpg-streamer.path"

S = "${WORKDIR}/mjpg-streamer"
SRCREV = "HEAD"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "mjpg-streamer.service mjpg-streamer.path"


do_compile_prepend() {
    sed -i -e 's:CC = gcc::' ${S}/Makefile
    sed -i -e 's:CC = gcc::' ${S}/plugins/input_uvc/Makefile
    sed -i -e 's:CC = gcc::' ${S}/plugins/input_testpicture/Makefile
    sed -i -e 's:CC = gcc::' ${S}/plugins/output_file/Makefile
    sed -i -e 's:CC = gcc::' ${S}/plugins/output_http/Makefile
}

do_install () {
    install -d ${D}${bindir}/
    install -d ${D}${libdir}/
    install -m 0755 ${S}/mjpg_streamer ${D}${bindir}/
    install -m 0755 ${S}/input_uvc.so ${D}${libdir}/
    install -m 0755 ${S}/input_testpicture.so ${D}${libdir}/
    install -m 0755 ${S}/output_http.so ${D}${libdir}/
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/mjpg-streamer.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/mjpg-streamer.path ${D}${systemd_unitdir}/system
}

FILES_${PN} = " \
    ${bindir}/mjpg_streamer \
    ${libdir}/input_uvc.so \
    ${libdir}/input_testpicture.so \
    ${libdir}/output_http.so \
    ${systemd_unitdir}/system/mjpg-streamer.service \
    ${systemd_unitdir}/system/mjpg-streamer.path \
"


