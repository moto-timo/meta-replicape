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

LICENSE = "CC BY-SA 2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31006e521276d40f3a14b96c9b1bcf73"

SRC_URI = "git://bitbucket.org/intelligentagent/redeem.git;protocol=https"
SRCREV = "c0e1489b1ee4c9b5430a66857d45b3c94065baee"

COMPATIBLE_MACHINE = "(beaglebone)"

S = "${WORKDIR}/git/"
