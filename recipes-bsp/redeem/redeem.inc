SUMMARY = "Reedeem is the Replicape Daemon that accepts G-codes and turns them \into coordinates on your 3D-printer. It's similar to Marlin and Teacup, only \
it's tailor made for Replicape and it's written in Python."

DESCRIPTION = " \
Software features: \
- Accelleration with corner speed prediction. \
- Printer settings loaded from file \
- Controllable via ethernet, USB, printer display. \
"
HOMEPAGE = "http://wiki.thing-printer.com/index.php?title=Redeem"
SECTION = "devel"

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;branch=Rev-A4;protocol=https"
SRCREV = "2574eda305d3fe530c17c180d89f88c135b8457b"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git"
