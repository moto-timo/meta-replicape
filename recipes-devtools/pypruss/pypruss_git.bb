SUMMARY = "PyPRUSS is a Python binding for controlling the PRUs on the \
BeagleBone."
DESCRIPTION = "For examples and inspiration: http://hipstercircuits.com/?cat=5 \
"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://setup.py;beginline=22;endline=25;md5=855973260dd42ad0ca5f67f6e8096381"

SRC_URI = "git://bitbucket.org/intelligentagent/pypruss.git;protocol=https \
           file://0001-Remove-libprussdrv.patch \
"
SRCREV = "ee6e8df92c242fbf91990466a119c9d949b12d8d"

S = "${WORKDIR}/git"

inherit distutils

RDEPENDS_${PN} += "libprussdrv"
RRECOMMENDS_${PN} += "pasm"

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGIN_LIBDIR

do_compile () {
    sed -i -e "s:data_files=[('/usr/local/lib', ['pypruss/lib/libprussdrv.so'])],::g" setup.py
    distutils_do_compile
}
