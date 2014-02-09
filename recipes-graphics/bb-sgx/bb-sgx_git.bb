SUMMARY = "PowerVR SGX530 SDK 5-alpha"
LICENSE = "MIT | GPLv2"

S = "${WORKDIR}/git"

PROVIDES = "virtual/libgles1 virtual/libgles2 virtual/egl"

RREPLACES_${PN} = "libegl libgles1 libgles2"
RREPLACES_${PN}-dev = "libegl-dev libgles1-dev libgles2-dev"
RREPLACES_${PN}-dbg = "libegl-dbg"

export BINLOCATION ?= "${S}/gfx_dbg_es8.x"

LIC_FILES_CHKSUM = "file://GFX_Linux_KM/GPL-COPYING;md5=60422928ba677faaa13d6ab5f5baaa1e \
                    file://GFX_Linux_KM/MIT-COPYING;md5=8c2810fa6bfdc5ae5c15a0c1ade34054"


SRC_URI = "git://bitbucket.org/intelligentagent/bb-sgx.git;branch=master;protocol=https \
           file://BB-SGX-00A0.dts \
           file://pvr.service \
           file://egl.pc \
           file://glesv2.pc"
SRCREV = "4d7ea5d406b30266b5e340681a7bc7f76726d02c"

# Force in GNU_HASH and paths to libs
#TARGET_CC_ARCH += " ${TARGET_LINK_HASH_STYLE} -Wl,-rpath-link,${BINLOCATION} -L${BINLOCATION} \
#-L${STAGING_DIR_TARGET}${libdir} -Wl,-rpath-link,${STAGING_DIR_TARGET}${libdir}"

inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "pvr.service"

IMGPV = "1.9.2188537"

# Force in GNU_HASH and paths to libs
TARGET_CC_ARCH += " ${TARGET_LINK_HASH_STYLE} -Wl,-rpath-link,${BINLOCATION} -L${BINLOCATION} \
-L${STAGING_DIR_TARGET}${libdir} -Wl,-rpath-link,${STAGING_DIR_TARGET}${libdir}"
PARALLEL_MAKE = ""

do_configure_prepend(){
	# Attempt to create proper library softlinks
	for sofile in $(find ${S} -name "lib*Open*.so") $(find ${S} -name "lib*srv*.so") $(find ${S} -name "lib*gl*.so") $(find ${S} -name "libpvr*.so") $(find ${S} -name "lib*GL*.so"); do
		if [ "$(readlink -n ${sofile})" = "" ] ; then
			mv $sofile ${sofile}.${IMGPV}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1}')
			ln -sf $(basename ${sofile}.${IMGPV}) ${sofile}$(echo ${IMGPV} | awk -F. '{print "." $1 "." $2}')
		fi
	done
}

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
	install -m 0755 ${S}/remotefs/etc/init.d/rc.pvr 										${D}/etc/init.d/
	install -m 0755 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/*.so.${IMGPV}			        ${D}${libdir}/
    cp -d ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/*.so$(echo ${IMGPV} | awk -F. '{print "." $1}')  ${D}${libdir}/
    cp -d ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/*.so$(echo ${IMGPV} | awk -F. '{print "." $1 "." $2}')  ${D}${libdir}/
    cp -d ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/*.so                   ${D}${libdir}/
	install -m 0755 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/pvrsrvctl					${D}${bindir}/ 	
	install -m 0755 ${S}/remotefs/opt/gfxlibraries/gfx_dbg_es8.x/eglinfo					${D}${bindir}/

    install -d ${D}/usr/include/EGL
    install -m 0644 ${S}/include/OGLES2/EGL/*.h ${D}/usr/include/EGL

    install -d ${D}/usr/include/GLES2
    install -m 0644 ${S}/include/OGLES2/GLES2/*.h ${D}/usr/include/GLES2

    install -m 0644 ${S}/BB-SGX-00A0.dts  ${D}/lib/firmware
    install -m 0644 ${S}/BB-SGX-00A0.dtbo ${D}/lib/firmware
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pvr.service ${D}${systemd_unitdir}/system

    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${WORKDIR}/egl.pc ${D}${libdir}/pkgconfig/
    install -m 0644 ${WORKDIR}/glesv2.pc ${D}${libdir}/pkgconfig/
    cd ${D}${libdir}; ln -s libGLESv2.so libglesv2.so
}

FILES_${PN} +=" \
	${bindir} \
	${bindir}/pvrsrvctl \ 
	${bindir}/eglinfo \
	${libdir}/lib*.so* \
    ${libdir}/pkgconfig \
    ${libdir}/pkgconfig/*.pc \
    /usr/ \
    /usr/include \
    /usr/include/EGL \
    /usr/include/EGL/*.h \
    /usr/include/GLES2 \
    /usr/include/GLES2/*.h \
	/etc \
	/etc/powervr.ini \
	/etc/init.d \
	/etc/init.d/rc.pvr \
    /lib \
    /lib/firmware \
    /lib/firmware/BB-SGX-00A0.dts \
    /lib/firmware/BB-SGX-00A0.dtbo \
    ${systemd_unitdir}/system \
    ${systemd_unitdir}/system/pvr.service \
"



#   /usr
#	/usr/share 
#	/usr/share/gir-1.0 
#	/usr/share/gir-1.0/Atk-1.0.gir 
#	${libdir}girepository-1.0 
#	${libdir}girepository-1.0/Atk-1.0.typelib 

