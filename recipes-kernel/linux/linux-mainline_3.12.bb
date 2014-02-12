require linux.inc

DESCRIPTION = "Linux kernel"
KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "(beaglebone)"

# The main PR is now using MACHINE_KERNEL_PR, for omap3 see conf/machine/include/omap3.inc
MACHINE_KERNEL_PR_append = "b"

FILESPATH =. "${FILE_DIRNAME}/linux-mainline-3.12:${FILE_DIRNAME}/linux-mainline-3.12/${MACHINE}:"

KERNEL_EXTRA_ARGS = "LOADADDR=0x80008000"

S = "${WORKDIR}/git"

PV = "3.12"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-3.12.y"
#SRCREV_pn-${PN} = "6beb1be0ea111cea50d410cdafabaa2065295e45"
SRCREV_pn-${PN} = "4a5804b8c293b23786b0743fc9c64b64f5099048"

do_configure_prepend() {
	if [ -e ${WORKDIR}/am335x-pm-firmware.bin ] ; then
		cp ${WORKDIR}/am335x-pm-firmware.bin ${S}/firmware
	fi
}

#file://general-fixes/0001-add-PM-firmware.patch

SRC_URI += " \
	file://omap-next-dt/0001-ARM-dts-AM33XX-Add-PMU-support.patch \
	file://omap-next-dt/0002-ARM-dts-AM33xx-Correct-gpio-interrupt-cells-property.patch \
	file://omap-next-dt/0003-ARM-dts-AM33XX-Add-EDMA-support.patch \
	file://omap-next-dt/0004-ARM-dts-AM33XX-Add-SPI-DMA-support.patch \
	file://omap-next-dt/0005-ARM-dts-AM33XX-Add-MMC-support-and-documentation.patch \
	file://omap-next-dt/0006-ARM-dts-am335x-bone-add-CD-for-mmc1.patch \
	file://omap-next-dt/0007-ARM-dts-am335x-boneblack-add-eMMC-DT-entry.patch \
	file://omap-next-dt/0008-ARM-dts-am335x-bone-common-switch-mmc1-to-4-bit-mode.patch \
	file://omap-next-dt/0009-ARM-dts-am335x-bone-common-add-cpu0-and-mmc1-trigger.patch \
	file://omap-next-dt/0010-ARM-dts-AM33XX-use-pinmux-node-defined-in-included-f.patch \
	file://omap-next-dt/0011-ARM-dts-AM33XX-don-t-redefine-OCP-bus-and-device-nod.patch \
	file://omap-next-dt/0012-ARM-dts-AM33XX-add-ethernet-alias-s-for-am33xx.patch \
	file://omap-next-dt/0013-ARM-dts-am335x-boneblack-move-fixed-regulator-to-boa.patch \
	file://omap-next-dt/0014-ARM-dts-am335x-bone-common-correct-mux-mode-for-cmd-.patch \
	file://dma-devel/0001-da8xx-config-Enable-MMC-and-FS-options.patch \
	file://dma-devel/0002-sound-soc-soc-dmaengine-pcm-Add-support-for-new-DMAE.patch \
	file://general-fixes/0002-ARM-CUSTOM-Build-a-uImage-with-dtb-already-appended.patch \
	file://general-fixes/0003-defconfig-add-for-mainline-on-the-beaglebone.patch \
	file://dtc-fixes/0001-Fix-util_is_printable_string.patch \
	file://dtc-fixes/0002-fdtdump-properly-handle-multi-string-properties.patch \
	file://dtc-overlays/0001-dtc-Dynamic-symbols-fixup-support.patch \
	file://dtc-overlays/0002-dtc-Dynamic-symbols-fixup-support-shipped.patch \
	file://of-fixes/0001-of-i2c-Export-single-device-registration-method.patch \
	file://of-fixes/0002-OF-Clear-detach-flag-on-attach.patch \
	file://of-fixes/0003-OF-Introduce-device-tree-node-flag-helpers.patch \
	file://of-fixes/0004-OF-export-of_property_notify.patch \
	file://of-fixes/0005-OF-Export-all-DT-proc-update-functions.patch \
	file://of-fixes/0006-OF-Introduce-utility-helper-functions.patch \
	file://of-fixes/0007-OF-Introduce-Device-Tree-resolve-support.patch \
	file://of-fixes/0008-OF-Introduce-DT-overlay-support.patch \
	file://pdev-fixes/0001-pdev-Fix-platform-device-resource-linking.patch \
	file://pdev-fixes/0002-of-Link-platform-device-resources-properly.patch \
	file://pdev-fixes/0003-omap-Properly-handle-resources-for-omap_devices.patch \
	file://pdev-fixes/0004-omap-Avoid-crashes-in-the-case-of-hwmod-misconfigura.patch \
	file://mmc-fixes/0001-omap-hsmmc-Correct-usage-of-of_find_node_by_name.patch \
	file://mmc-fixes/0002-omap_hsmmc-Add-reset-gpio.patch \
	file://dts-fixes/0001-dts-beaglebone-Add-I2C-definitions-for-EEPROMs-capes.patch \
	file://dts-fixes/0002-arm-beaglebone-dts-Add-capemanager-to-the-DTS.patch \
	file://dts-fixes/0003-OF-Compile-Device-Tree-sources-with-resolve-option.patch \
	file://dts-fixes/0004-am335x-bone-enable-HDMI-on-black.patch \
	file://i2c-fixes/0001-i2c-EEPROM-In-kernel-memory-accessor-interface.patch \
	file://i2c-fixes/0002-grove-i2c-Add-rudimentary-grove-i2c-motor-control-dr.patch \
	file://pinctrl-fixes/0001-pinctrl-pinctrl-single-must-be-initialized-early.patch \
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
	file://reset/0001-reset-Add-driver-for-gpio-controlled-reset-pins.patch \
	file://capes/0001-capemgr-firmware-makefiles-for-DT-objects.patch \
	file://lcdc-fixes/0001-gpu-drm-tilcdc-get-preferred_bpp-value-from-DT.patch \
	file://lcdc-fixes/0002-drm-tilcdc-fixing-i2c-slave-initialization-race.patch \
	file://lcdc-fixes/0003-drm-tilcdc-Fix-scheduling-while-atomic-from-irq-hand.patch \
	file://lcdc-fixes/0004-tilcdc-Slave-panel-settings-read-from-DT-now.patch \
	file://net/0001-am33xx-cpsw-default-to-ethernet-hwaddr-from-efuse-if.patch \
	file://deassert-hard-reset/0001-ARM-omap-add-DT-support-for-deasserting-hardware-res.patch \
	file://cape-import/0001-capes-import-from-3.8.patch \
	file://sgx/0000-all-sgx-patches.patch \
	file://sgx/0001-sgx-add-reset.patch \
	file://pru/0000-add-pruss-to-device-tree.patch \
	file://pru/0001-add-pruss-to-kconfig.patch \
	file://pru/0002-make-uio-pruss-dt-comaptible.patch \
	file://defconfig \
  	file://am335x-pm-firmware.bin \
	file://logo_linux_clut224.ppm \
    file://uio-pruss.cfg \
"
