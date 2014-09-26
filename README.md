meta-replicape
==============

Layer for [&Aring;ngstr&ouml;m](http://angstrom-distrubiton.org)/[OpenEmbedded](http://openembedded.org) to support the Replicape. Inspired by [http://www.thing-printer.com] (Replicape)

Kernel:
  * 3.14 with Capemgr (requires meta-ti commit 1d4407e7f67a1a1955a7debb336020de304adc00)


BSP-layer: 
  * Redeem 0.15.2 -- The Replicape Daemon
  * Toggle 0.2 -- GUI for 3D-printers suitable for embedded platforms. 
  * Octoprint stable -- The responsive web interface for your 3D printer
  * CuraEngine stable -- A fast G-code slicer 

Pull requests pending (meta-beagleboard):
  * pasm -- a [PRU](http://processors.wiki.ti.com/index.php/Programmable_Realtime_Unit_Subsystem) Assembler

Graphics: 
  * Clutter 1.9.6
  * Cogl-1.8.2
  * Mx-2.0
  * Mash-0.2
  * GdkPixbuf 


Introspection:
All the grahics packages have been compiled with introspection, 
enabling development in high level languages like Python and JS.
There is no window system. (--enable-egl-null)
Backend to clutter is evdev/libinput


Todo: 
 - sed capes
 - Finish Toggle

Add: 
 - libgirepository-1.0-dev
 - libclutter-1.0-dev

Todo: 
- Toggle: reposition the frog
- Add task-native-sdk? 

Staged: 
 - kernel device tree overlays fixed 

Wontfix:
- USB babble interrupt occured. (added a patch, not tested) 
  - CAUTION: musb: Babble Interrupt Occurred  - still happening on hotplug
- Failed at step EXEC spawning /usr/lib/connman/wired-setup: No such file or directory
- CPU-freq not set properly
- can't open '/var/lib/misc/udhcpd.leases': No such file or directory 
  - touch /var/lib/misc/udhcpd.leases
- iptables support missing error 2 (No such file or directory)
  - opkg upgrade iptables


Done: 
- Change hostname to thing (from emmc.sh?) (ok)
- Add thing feeds (ok) 
- Enable Redeem (ok)
- Enable Toggle (ok) 
- Enable tty0tty (ok)
- Link /usr/lib/libprussdrv.so.1 (in emmc.sh)
- install libprussdrv1 (ok, dependent on pruss)
- Disable TTY login (ok, emmc.sh)
- hardcoded link in libEGL.so (ok, added path in emmc.sh) 
- USB Ethernet does not come up (ok, upgraded to 3.12.9)
- Keyboard config shit (xkeyboard-config?)
- gdk-pixbuf does not load files. 
- pvr does not shut down right. (fixed! hacked the kernel module)
- images on toggle does not load
- emmc script does not complete right.
- g_multi does not load (ok, added usb_f_eem)
- Changed the script on pvr so there is no .sh any more. 
- Date not set properly 
- Modules were missing. Adding "kernel-modules" to image. Is this necessary?
v2014.06:
- Added Make
- Added wget
- Added binutils
- Added Python-dev
- Lighttpd
- web.py
- python-sqlite3
- sqlite3
- flup
- Switched from BB-SGX to libgles-omap3
- Added capemgr to Kernel 3.14
- USB gadget serial not available as /dev/ttyGS0
- Get Python/Clutter code to compile out of the box
 - PRU bug
 - added Flup
 - Added web.py
 - Thing-frontend


Remember (Will eventually be a part of recipes): 
- If you get this error when compiling Mash: 
fatal error: glib-object.h: No such file or directory
Added this to the mash_git recipe. CFLAGS_prepend = "-I/usr/include/glib-2.0 "


