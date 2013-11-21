SUMMARY = "libprussdrv - PRU driver library"
DESCRIPTION = "libprussdrv - driver library for programmable realtime unit sub system"
SECTION = "devel"

LICENSE = "TI"
LIC_FILES_CHKSUM = "file://prussdrv.c;beginline=6;endline=47;md5=b6e20afe744fe2321f58d3a4c7d06946"

SRC_URI = "git://github.com/beagleboard/am335x_pru_package.git;protocol=https"
SRCREV = "dbd22a045e48032fffaae72f88d27e8f84c1239b"

S = "${WORKDIR}/git/pru_sw/app_loader/interface"

COMPATIBLE_MACHINE = "(beaglebone)"

CFLAGS += "-I. -Wall -I../include   -c -fPIC -O3 -mtune=cortex-a8 -march=armv7-a -shared"
SOURCES = "prussdrv.c"

do_compile () {
    ${CC} ${CFLAGS} ${SOURCES} -o prussdrv.o
    ${CC} -shared -o libprussdrv.so prussdrv.o
}

do_install() {
    install -d ${D}${libdir}
    install -m 0755 ${S}/libprussdrv.so ${D}${libdir}
}

FILES_${PN} = " \
               ${libdir} \
               ${libdir}/libprussdrv.so \
"
