Wifi: 

- Add connmanctl to image ( connman-client)
- Add crda to image (crda) 



[    7.578823] ------------[ cut here ]------------
[    7.584001] WARNING: CPU: 0 PID: 119 at net/wireless/reg.c:423 regulatory_init+0x90/0x134 [cfg80211]()
[    7.593881] db.txt is empty, you should update it...
[    7.598980] Modules linked in: cfg80211(+) snd_pcm snd_page_alloc snd_timer w1_gpio snd soundcore uio_pruss ipv6 autofs4
[    7.610754] CPU: 0 PID: 119 Comm: systemd-udevd Not tainted 3.12.9 #1
[    7.617605] [<c001398c>] (unwind_backtrace+0x0/0xe0) from [<c0010d80>] (show_stack+0x10/0x14)
[    7.626626] [<c0010d80>] (show_stack+0x10/0x14) from [<c04e4424>] (dump_stack+0x68/0x84)
[    7.635195] [<c04e4424>] (dump_stack+0x68/0x84) from [<c0037f80>] (warn_slowpath_common+0x60/0x84)
[    7.644667] [<c0037f80>] (warn_slowpath_common+0x60/0x84) from [<c0038024>] (warn_slowpath_fmt+0x2c/0x3c)
[    7.654848] [<c0038024>] (warn_slowpath_fmt+0x2c/0x3c) from [<bf14f160>] (regulatory_init+0x90/0x134 [cfg80211])
[    7.665712] [<bf14f160>] (regulatory_init+0x90/0x134 [cfg80211]) from [<bf14f054>] (cfg80211_init+0x54/0xd0 [cfg80211])
[    7.677157] [<bf14f054>] (cfg80211_init+0x54/0xd0 [cfg80211]) from [<c00088c8>] (do_one_initcall+0x94/0x138)
[    7.687584] [<c00088c8>] (do_one_initcall+0x94/0x138) from [<c00878d0>] (load_module+0x192c/0x1bf4)
[    7.697151] [<c00878d0>] (load_module+0x192c/0x1bf4) from [<c0087ce0>] (SyS_finit_module+0x5c/0x6c)
[    7.706714] [<c0087ce0>] (SyS_finit_module+0x5c/0x6c) from [<c000de20>] (ret_fast_syscall+0x0/0x30)
[    7.716266] ---[ end trace 5924858a0ce93438 ]---

