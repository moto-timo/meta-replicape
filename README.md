meta-replicape
==============

Layer for [&Aring;ngstr&ouml;m](http://angstrom-distrubiton.org)/[OpenEmbedded](http://openembedded.org) to support the Replicape. Inspired by [http://replicape.com] (http://replicape.com) and [http://hipstercircuits.com] (http://hipstercircuits.com)

In the spirit of [OE](http://openembedded.org), whenever possible, recipes will fetch from original sources or SCM rather than the [tarball](http://distros.replicape.com/Replicape_rev_A4-13_11_11.tgz).

Includes (will eventually be submitted to meta-oe):
  * tty0tty -- a Linux null-modem emulator
    * kernel module
    * user application
    * systemd service
  * spimodule -- Python bindings for spi

Pull requests pending (meta-beagleboard):
  * pasm -- a [PRU](http://processors.wiki.ti.com/index.php/Programmable_Realtime_Unit_Subsystem) Assembler
  * libprussdrv -- user space driver library for PRUSS


Todo: 
2. USB Ethernet does not come up
8. Disable TTY login

Done: 
1. Change hostname to thing (from emmc.sh?) (ok)
3. Add thing feeds (ok) 
4. Enable Redeem
5. Enable Toggle (?) 
6. Enable tty0tty
7. Link /usr/lib/libprussdrv.so.1 (install dev-pkg)


Remember: 
Compiling toggle: add the "-B 0x100000" argument to the build/tmp-angstrom_v2013_06-eglibc/sysroots/beaglebone/usr/bin/crossscripts/qemuwrapper
Compile Cogl first. Requires 2.0. 

If you get this error when compiling Mash: 
fatal error: glib-object.h: No such file or directory
Added this to the mash_git recipe. CFLAGS_prepend = "-I/usr/include/glib-2.0 "


