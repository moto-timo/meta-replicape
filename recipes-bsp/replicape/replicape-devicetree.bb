SUMMARY = "Replicape is a 3D printer cape for BeagleBone"
DESCRIPTION = "Software written in Python for maintainability and hackability. \
\
Software features: \
- Accelleration with corner speed prediction. \
- Printer settings loaded from file (Version 0.4.2) \
- Controllable via ethernet, USB, printer display. \
"
HOMEPAGE = "http://wiki.replicape.com/index.php?title=Software"
SECTION = "devel"

LICENSE = "BSD"
#LIC_FILES_CHKSUM = "

SRC_URI = "http://distros.replicape.com/Replicape_rev_${PN}.tgz"
SRC_URI[md5sum] = "a97b383d9a5952c13742bb2924b74add"
SRC_URI[sha256sum] = "1ebeece9f2afda5c348d81e5888f5bc94752a399567d65a5f0b843cf843c9073"

S = "${WORKDIR}/Replicape/"

inherit setuptools


