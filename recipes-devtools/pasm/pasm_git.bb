SUMMARY = "PASM - PRU Assembler"
DESCRIPTION = "pasm - assembler for programmable realtime unit sub system"
SECTION = "devel"

LICENSE = "TI"
LIC_FILES_CHKSUM = "file://LICENCE.txt;md5=a4120726312222872e582a3f2851144f"

SRC_URI = "git://github.com/beagleboard/am335x_pru_package.git;protocol=https"
SRCREV = "dbd22a045e48032fffaae72f88d27e8f84c1239b"

S = "${WORKDIR}/git/pru_sw/utils"

CFLAGS += "-Wall -D_UNIX_"
SOURCES = "pasm.c pasmpp.c pasmexp.c pasmop.c pasmdot.c pasmstruct.c \
	   pasmmacro.c"

do_compile () {
    cd pasm_source
    ${CC} ${CFLAGS} ${SOURCES} -o ../pasm
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/pasm ${D}${bindir}
}

BBCLASSEXTEND = "native"
