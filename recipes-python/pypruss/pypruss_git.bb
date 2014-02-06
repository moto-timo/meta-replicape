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
do_compile_prepend () {
    sed -i 's: vars: #vars:g' setup.py
    sed -i -e "s:/usr/include/python2.7:${STAGING_DIR_TARGET}/usr/include/python2.7:g" setup.py
    sed -i -e "s:/usr/include:${STAGING_DIR_TARGET}/usr/include:g" setup.py
}


RDEPENDS_${PN} = "libprussdrv"
