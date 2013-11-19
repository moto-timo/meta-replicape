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
LIC_FILES_CHKSUM = "file://software/Replicape.py;beginline=3;endline=10;md5=31006e521276d40f3a14b96c9b1bcf73"

RELDATE ?= "13_11_12"
SRC_URI = "http://distros.replicape.com/Replicape_rev_${PV}-${RELDATE}.tgz"
SRC_URI[md5sum] = "d4babc15cc580bb8111115d28285a221"
SRC_URI[sha256sum] = "439a6519dea92d8a93c8f98293e91ab8ece29c4ea2971841909083a33a913cb0"

S = "${WORKDIR}/Replicape/"
