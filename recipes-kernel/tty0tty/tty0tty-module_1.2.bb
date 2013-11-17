# Released under the MIT license (see COPYING.MIT for the terms)

require tty0tty.inc

DESCRIPTION = "tty0tty - Linux null-modem emulator"
SUMMARY = "The Linux null-modem emulator (tty0tty) is a kernel-module virtual \
serial port driver for Linux. This creates virtual tty port pairs and uses \
any pair to connect one tty serial port based application to another. \
There is a version using pseudo-terminal (UNIX 98 style). \
"

KERNELDIR = "${STAGING_KERNEL_DIR}"

inherit module

SRC_URI += " \
    file://0002-Makefile-KERNELDIR.patch \
"

# Only build the module
do_compile () {
    cd module
    module_do_compile
}

# Kernel module packages MUST begin with 'kernel-module-', otherwise
# multilib image generation can fail.
#
# The following line is only necessary if the recipe name does not begin
# with kernel-module-.
#
PKG_${PN} = "kernel-module-${PN}"

