SUMMARY = "PowerVR SGX530 SDK 5-alpha"
LICENSE = "MIT | GPLv2"

S = "${WORKDIR}/git"

export BINLOCATION ?= "${S}/gfx_dbg_es8.x"

LIC_FILES_CHKSUM = "file://GFX_Linux_KM/GPL-COPYING;md5=60422928ba677faaa13d6ab5f5baaa1e \
                    file://GFX_Linux_KM/MIT-COPYING;md5=8c2810fa6bfdc5ae5c15a0c1ade34054"


SRC_URI = "git://bitbucket.org/intelligentagent/bb-sgx.git;branch=master;protocol=https"
SRCREV = "58dddb1e4da001e7cccf7d38e4e434b4c8355f97"

inherit module

do_compile(){
	cp ${S}/Rules.make.dist ${S}/Rules.make
	sed -i -e 's:@@HOME@@:/home/iagent:' ${S}/Rules.make
	sed -i -e 's:@@CSTOOL_DIR@@:/home/iagent/workspace/setup-scripts/build/tmp-angstrom_v2013_06-eglibc/sysroots/i686-linux/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/:' ${S}/Rules.make
	sed -i -e 's:@@CSTOOL_PREFIX@@:arm-angstrom-linux-gnueabi-:' ${S}/Rules.make
	sed -i -e 's:@@KERNEL_INSTALL_DIR@@:${STAGING_KERNEL_DIR}:' ${S}/Rules.make
	sed -i -e 's:@@TARGETFS_INSTALL_DIR@@:${S}/remotefs:' ${S}/Rules.make
	sed -i -e 's:@@GRAPHICS_INSTALL_DIR@@:${S}:' ${S}/Rules.make

	make all_km
}

do_install(){
	mkdir -p ${S}/remotefs/opt
	mkdir -p ${S}/remotefs/etc/init.d
	make install_km

    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
    install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/*.ko  ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr/
}


