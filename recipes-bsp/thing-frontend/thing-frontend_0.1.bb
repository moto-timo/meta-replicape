SRC_URI = "git://bitbucket.org/intelligentagent/thing-frontend.git;protocol=https"
SRCREV = "f28cf1a19e069511daad1c08c0e31a0a7f9474c5"

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c79ff39f19dfec6d293b95dea7b07891"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = " \
	python-webpy \
	python-flup \
    python-sqlite3 \
	lighttpd \
    lighttpd-module-rewrite \
    lighttpd-module-fastcgi \
    lighttpd-module-alias \
"

do_install(){
    install -d ${D}/www/pages/thing
    install -m 0755 ${S}/thing/*.py ${D}/www/pages/thing
    install -d ${D}/www/pages/thing/templates
    install -m 0644 ${S}/thing/templates/*.html ${D}/www/pages/thing/templates
    install -d ${D}/www/pages/static
    install -m 0644 ${S}/static/*.js ${D}/www/pages/static
    install -d ${D}/www/pages/static/images
    install -m 0644 ${S}/static/images/*.png ${D}/www/pages/static/images
    install -d ${D}/www/pages/static/jquery-ui-1.11.1
    install -m 0644 ${S}/static/jquery-ui-1.11.1/*.js  ${D}/www/pages/static/jquery-ui-1.11.1
    install -m 0644 ${S}/static/jquery-ui-1.11.1/*.css ${D}/www/pages/static/jquery-ui-1.11.1
    install -d ${D}/www/pages/static/jquery-ui-1.11.1/images
    install -m 0644 ${S}/static/jquery-ui-1.11.1/images/*.png  ${D}/www/pages/static/jquery-ui-1.11.1/images
    install -d ${D}/etc/lighttpd.d/
    install -m 0644 ${S}/thing.conf ${D}/etc/lighttpd.d
}

FILES_${PN} += " \
      /www/pages/thing/*.py \
      /www/pages/thing/templates/*.html \
      /www/pages/static/*.js \
      /www/pages/static/images/*.png \
      /www/pages/static/jquery-ui-1.11.1/*.js \
      /www/pages/static/jquery-ui-1.11.1/*.css \
      /www/pages/static/jquery-ui-1.11.1/images/*.png \
      /etc/lighttpd.d/thing.conf \
"
