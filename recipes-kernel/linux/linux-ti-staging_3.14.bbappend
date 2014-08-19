
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}/:"

SRC_URI += " \
    file://capemgr/0001-capemgr-Capemgr-makefiles-and-Kconfig-fragments.patch \
	file://capemgr/0002-capemgr-Beaglebone-capemanager.patch \
	file://capemgr/0003-capemgr-Remove-__devinit-__devexit.patch \
	file://capemgr/0004-bone-capemgr-Make-sure-cape-removal-works.patch \
	file://capemgr/0005-bone-capemgr-Fix-crash-when-trying-to-remove-non-exi.patch \
	file://capemgr/0006-bone-capemgr-Force-a-slot-to-load-unconditionally.patch \
	file://capemgr/0007-capemgr-Added-module-param-descriptions.patch \
	file://capemgr/0008-capemgr-Implement-disable-overrides-on-the-cmd-line.patch \
	file://capemgr/0009-capemgr-Implement-cape-priorities.patch \
	file://capemgr/0010-bone-capemgr-Introduce-simple-resource-tracking.patch \
	file://capemgr/0011-capemgr-Add-enable_partno-parameter.patch \
    file://i2c-fixes/0001-i2c-EEPROM-In-kernel-memory-accessor-interface.patch \
	file://of-fixes/0001-of-i2c-Export-single-device-registration-method.patch \
	file://of-fixes/0002-OF-Clear-detach-flag-on-attach.patch \
	file://of-fixes/0003-OF-Introduce-device-tree-node-flag-helpers.patch \
	file://of-fixes/0004-OF-export-of_property_notify.patch \
	file://of-fixes/0005-OF-Export-all-DT-proc-update-functions.patch \
	file://of-fixes/0006-OF-Introduce-utility-helper-functions.patch \
	file://of-fixes/0007-OF-Introduce-Device-Tree-resolve-support.patch \
	file://of-fixes/0008-OF-Introduce-DT-overlay-support.patch \
	file://dts-fixes/0001-dts-beaglebone-Add-I2C-definitions-for-EEPROMs-capes.patch \
	file://dts-fixes/0002-arm-beaglebone-dts-Add-capemanager-to-the-DTS.patch \
	file://dts-fixes/0003-OF-Compile-Device-Tree-sources-with-resolve-option.patch \
    file://pinctrl-fixes/0001-pinctrl-pinctrl-single-must-be-initialized-early.patch \
    file://dtc-overlays/0001-dtc-Dynamic-symbols-fixup-support.patch \
    file://dtc-overlays/0002-dtc-Dynamic-symbols-fixup-support-shipped.patch \
    file://dtc-fixes/0001-Fix-util_is_printable_string.patch \
    file://dtc-fixes/0002-fdtdump-properly-handle-multi-string-properties.patch \
    file://capes/0001-capemgr-firmware-makefiles-for-DT-objects.patch \
    file://pru/0001-These-are-the-patches-necessary-for-enabling-the-PRU.patch \
    file://pru/0002-ARM-omap-add-DT-support-for-deasserting-hardware-res.patch \
    file://pru/0003-check-for-presence-of-pdata.patch \
    file://configs/0001-enable-capemgr.cfg \
    file://configs/enable-led-gpio.cfg \
    file://configs/enable-w1-gpio.cfg \
"

KERNEL_CONFIG_FRAGMENTS_append_ti33x = " ${WORKDIR}/configs/0001-enable-capemgr.cfg ${WORKDIR}/configs/enable-led-gpio.cfg ${WORKDIR}/configs/enable-w1-gpio.cfg"

EXTRA_OEMAKE += " V=1 "
