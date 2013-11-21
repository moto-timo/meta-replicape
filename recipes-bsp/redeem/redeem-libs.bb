include redeem.inc

LICENSE = "CC-BY-SA-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=d91509a59f42bb5341a8af8295f28211"

# NOTE: i2c-tools is included by python-smbus

S .= "/libs/spi"

FILES_${PN} += " \
"

inherit distutils

