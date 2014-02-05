SUMMARY = "PowerVR SGX530 SDK 5-alpha"
LICENSE = "MIT | GPLv2"

S = "${WORKDIR}/git"

PROVIDES = "libegl virtual/libgles1 virtual/libgles2 virtual/egl"

RREPLACES_${PN} = "libegl libgles1 libgles2"
RREPLACES_${PN}-dev = "libegl-dev libgles1-dev libgles2-dev"
RREPLACES_${PN}-dbg = "libegl-dbg"

export BINLOCATION ?= "${S}/gfx_dbg_es8.x"

LIC_FILES_CHKSUM = "file://GFX_Linux_KM/GPL-COPYING;md5=60422928ba677faaa13d6ab5f5baaa1e \
                    file://GFX_Linux_KM/MIT-COPYING;md5=8c2810fa6bfdc5ae5c15a0c1ade34054"


SRC_URI = "git://bitbucket.org/intelligentagent/bb-sgx.git;branch=master;protocol=https"
SRCREV = "299abc737d3dd080f8c2bdbeafe0b69f0f984884"

# Force in GNU_HASH and paths to libs
TARGET_CC_ARCH += " ${TARGET_LINK_HASH_STYLE} -Wl,-rpath-link,${BINLOCATION} -L${BINLOCATION} \
-L${STAGING_DIR_TARGET}${libdir} -Wl,-rpath-link,${STAGING_DIR_TARGET}${libdir}"

inherit module

do_compile(){
	cp ${S}/Rules.make.dist ${S}/Rules.make
	sed -i -e 's:@@HOME@@:/home/iagent:' ${S}/Rules.make
	sed -i -e 's:@@CSTOOL_DIR@@:${STAGING_DIR_NATIVE}/usr/bin/armv7ahf-vfp-neon-angstrom-linux-gnueabi/:' ${S}/Rules.make
	sed -i -e 's:@@CSTOOL_PREFIX@@:arm-angstrom-linux-gnueabi-:' ${S}/Rules.make
	sed -i -e 's:@@KERNEL_INSTALL_DIR@@:${STAGING_KERNEL_DIR}:' ${S}/Rules.make
	sed -i -e 's:@@TARGETFS_INSTALL_DIR@@:${S}/remotefs:' ${S}/Rules.make
	sed -i -e 's:@@GRAPHICS_INSTALL_DIR@@:${S}:' ${S}/Rules.make

	make all
    
    dtc -O dtb -o BB-SGX-00A0.dtbo -b 0 -@ BB-SGX-00A0.dts
}

do_install(){
	mkdir -p ${S}/remotefs/opt
	mkdir -p ${S}/remotefs/etc/init.d
	make install

	install -d ${D}/etc
	install -d ${D}/etc/init.d
	install -d ${D}${libdir}
	install -d ${D}${bindir}
    install -d ${D}/lib
    install -d ${D}/lib/firmware

	install -m 0644 ${S}/remotefs/etc/powervr.ini											${D}/etc/
	install -m 0644 ${S}/remotefs/etc/init.d/rc.pvr 										${D}/etc/init.d/
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/*.so 						${D}${libdir}/
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/pvrsrvctl					${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/sgx_init_test				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_server					${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_server_es2				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/services_test				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/sgx_blit_test				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/sgx_clipblit_test			${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/sgx_flip_test				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/sgx_render_flip_test		${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/pvr2d_test					${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/gles1test1					${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/gles1_texture_stream		${D}${bindir}/
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/gles2test1					${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/glsltest1_vertshader.txt 	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/glsltest1_fragshaderA.txt 	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/glsltest1_fragshaderB.txt 	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/gles2_texture_stream		${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/eglinfo					${D}${bindir}/
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_gles1				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_gles2				${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_gles2_main.vert 	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_gles2_main.frag 	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_gles2_pp.vert   	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_gles2_pp.frag	 	${D}${bindir}/ 	
	install -m 0644 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/ews_test_swrender		 	${D}${bindir}/ 	

    install -m 0644 ${S}/BB-SGX-00A0.dts  ${D}/lib/firmware
    install -m 0644 ${S}/BB-SGX-00A0.dtbo ${D}/lib/firmware
}

FILES_${PN} +=" \
	/usr/share/ \
	/usr/share/gir-1.0 \
	/usr/share/gir-1.0/Atk-1.0.gir \
	${libdir}girepository-1.0 \
	${libdir}girepository-1.0/Atk-1.0.typelib \
	${bindir} \
	${libdir}/pvr_drv.so \
	/etc \
	/etc/powervr.ini \
	/etc/init.d \
	/etc/init.d/rc.pvr \
	${libdir}/libEGL.so \
	${libdir}/libEGL_eglimage.so \
	${libdir}/libews.so \
	${libdir}/libGLES_CM.so \
	${libdir}/libGLES_CM_eglimage.so \
	${libdir}/libGLESv2.so \
	${libdir}/libGLESv2_eglimage.so \
	${libdir}/libglslcompiler.so \
	${libdir}/libglslcompiler_eglimage.so \
	${libdir}/libIMGegl.so \
	${libdir}/libIMGegl_eglimage.so \
	${libdir}/libpvr2d.so \
	${libdir}/libpvrEWS_REMWSEGL.so \
	${libdir}/libpvrEWS_WSEGL.so \
	${libdir}/libpvrPVR2D_BLITWSEGL.so \
	${libdir}/libpvrPVR2D_DRIWSEGL.so \
	${libdir}/libpvrPVR2D_FLIPWSEGL.so \
	${libdir}/libpvrPVR2D_FRONTWSEGL.so \
	${libdir}/libpvrPVR2D_LINUXFBWSEGL.so \
	${libdir}/libPVRScopeServices.so \
	${libdir}/libsrv_init.so \
	${libdir}/libsrv_um.so \
	${libdir}/libsrv_um_dri.so \
	${libdir}/libusc.so \
	${bindir}/pvrsrvctl \ 
	${bindir}/sgx_init_test	\
	${bindir}/ews_server \		
	${bindir}/ews_server_es2 \
	${bindir}/services_test	\	
	${bindir}/sgx_blit_test	\		
	${bindir}/sgx_clipblit_test	\
	${bindir}/sgx_flip_test	\	
	${bindir}/sgx_render_flip_test	\
	${bindir}/pvr2d_test			\
	${bindir}/gles1test1			\
	${bindir}/gles1_texture_stream	\
	${bindir}/gles2test1			\	
	${bindir}/glsltest1_vertshader.txt \
	${bindir}/glsltest1_fragshaderA.txt \
	${bindir}/glsltest1_fragshaderB.txt \
	${bindir}/gles2_texture_stream \
	${bindir}/eglinfo \
	${bindir}/ews_test_gles1 \
	${bindir}/ews_test_gles2	\	
	${bindir}/ews_test_gles2_main.vert \
	${bindir}/ews_test_gles2_main.frag \
	${bindir}/ews_test_gles2_pp.vert \
	${bindir}/ews_test_gles2_pp.frag \
	${bindir}/ews_test_swrender \
    /lib \
    /lib/firmware \
    /lib/firmware/BB-SGX-00A0.dts \
    /lib/firmware/BB-SGX-00A0.dtbo \
"

