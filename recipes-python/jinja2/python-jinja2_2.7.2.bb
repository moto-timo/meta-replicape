SUMMARY = "A small but fast and easy to use stand-alone template engine \
written in pure python."
DESCRIPTION = "Jinja2 is a template engine written in pure Python. It provides \
a Django inspired non-XML syntax but supports inline expressions and an \
optional sandboxed environment."
HOMEPAGE = "http://jinja.pocoo.org/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=20c831f91dd3bd486020f672ba2be386"

SRC_URI = "https://pypi.python.org/packages/source/J/Jinja2/Jinja2-2.7.2.tar.gz"
SRC_URI[md5sum] = "df1581455564e97010e38bc792012aa5"
SRC_URI[sha256sum] = "310a35fbccac3af13ebf927297f871ac656b9da1d248b1fe6765affa71b53235"

S = "${WORKDIR}/Jinja2-${PV}"

inherit setuptools

