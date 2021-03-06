SUMMARY = "Phosphor OpenBMC IPMI daemon"
DESCRIPTION = "Phosphor OpenBMC IPMI router and plugin libraries"
HOMEPAGE = "http://github.com/openbmc/phosphor-host-ipmid"
PR = "r1"

inherit obmc-phosphor-license
inherit obmc-phosphor-sdbus-service

SRC_URI += "git://github.com/openbmc/phosphor-host-ipmid"

SRCREV = "98900a99254cd177c8308b63c341f793d2ac119d"

S = "${WORKDIR}/git"

do_install() {
        install -m 0755 -d ${D}${sbindir}
        install -m 0755 ${S}/ipmid ${D}${sbindir}/

        install -m 0755 -d ${D}${libdir}/host-ipmid
        install -m 0755 ${S}/*.so ${D}${libdir}/host-ipmid/

        install -m 0755 -d ${D}${includedir}/host-ipmid
        install -m 0644 ${S}/ipmid-api.h ${D}${includedir}/host-ipmid/
}
