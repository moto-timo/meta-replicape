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

