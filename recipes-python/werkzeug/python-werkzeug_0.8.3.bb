SUMMARY = "The Swiss Army knife of Python web development"
DESCRIPTION = " \
Werkzeug started as simple collection of various utilities for WSGI \
applications and has become one of the most advanced WSGI utility \
modules.  It includes a powerful debugger, full featured request and \
response objects, HTTP utilities to handle entity tags, cache control \
headers, HTTP dates, cookie handling, file uploads, a powerful URL \
routing system and a bunch of community contributed addon modules. \
"
HOMEPAGE = "http://werkzeug.pocoo.org/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ad2e600a437b1b03d25b02df8c23ad1c"

SRC_URI = "https://pypi.python.org/packages/source/W/Werkzeug/Werkzeug-0.8.3.tar.gz"
SRC_URI[md5sum] = "12aa03e302ce49da98703938f257347a"
SRC_URI[sha256sum] = "108c3d41fb701c4af4ef00e8ebbedc147632c82247beb798c8d8657a12810206"

S = "${WORKDIR}/Werkzeug-${PV}"

inherit setuptools


