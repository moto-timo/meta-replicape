include slic3r.inc

SRC_URI[md5sum] = "6b09dc8960eeb0b6a5de41d4e644bfa8"
SRC_URI[sha256sum] = "750c9ee01dd5468dae403af1daac25862e8a5644bb412f2f6022d76e7d7f639e"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"
#EXTRA_OECONF += "PERL=${STAGING_DIR_TARGET}/usr/bin/perl-native/perl"
#EXTRA_OECONF += "--with-sysroot=yes"

inherit cpan_build


cpan_build_do_configure_prepend (){
    export SLIC3R_NO_AUTO=true
}

cpan_build_do_configure () {
	if [ "${@is_target(d)}" = "yes" ]; then
		# build for target
		. ${STAGING_LIBDIR}/perl/config.sh
	fi

	perl -I${STAGING_DIR}/i686-linux/usr/lib/perl5 Build.PL --installdirs vendor \
				--destdir ${D} \
				--install_path arch="${libdir}/perl" \
				--install_path script=${bindir} \
				--install_path bin=${bindir} \
				--install_path bindoc=${mandir}/man1 \
				--install_path libdoc=${mandir}/man3
}


BBCLASSEXTEND = "native"
