SRC_URI = "git://bitbucket.org/intelligentagent/debrew.git;protocol=https"
SRCREV = "c0e32ea199718530440e51dfc4ec4e5e3515ccef"

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
    install -d ${D}/www/pages/debrew
    install -d ${D}/www/pages/debrew/templates
    install -d ${D}/www/pages/static
    install -d ${D}/www/pages/static/images
    install -d ${D}/www/pages/static/jquery-ui-1.11.0.custom
    install -d ${D}/www/pages/static/jquery-ui-1.11.0.custom/images
    install -d ${D}/etc/lighttpd.d/
    install -m 0755 ${S}/web/debrew/*.py ${D}/www/pages/debrew
    install -m 0644 ${S}/web/debrew/templates/*.html ${D}/www/pages/debrew/templates
    install -m 0644 ${S}/web/static/*.js ${D}/www/pages/static
    install -m 0644 ${S}/web/static/images/*.png ${D}/www/pages/static/images
    install -m 0644 ${S}/web/static/jquery-ui-1.11.0.custom/*.js  ${D}/www/pages/static/jquery-ui-1.11.0.custom
    install -m 0644 ${S}/web/static/jquery-ui-1.11.0.custom/*.css ${D}/www/pages/static/jquery-ui-1.11.0.custom
    install -m 0644 ${S}/web/static/jquery-ui-1.11.0.custom/images/*.png  ${D}/www/pages/static/jquery-ui-1.11.0.custom/images
    install -m 0644 ${S}/web/debrew.conf ${D}/etc/lighttpd.d
}

FILES_${PN} += " \
      /www/pages/debrew/*.py \
      /www/pages/debrew/templates/*.html \
      /www/pages/static/*.js \
      /www/pages/static/images/*.png \
      /www/pages/static/jquery-ui-1.11.0.custom/*.js \
      /www/pages/static/jquery-ui-1.11.0.custom/*.css \
      /www/pages/static/jquery-ui-1.11.0.custom/images/*.png \
      /etc/lighttpd.d/debrew.conf \
"
