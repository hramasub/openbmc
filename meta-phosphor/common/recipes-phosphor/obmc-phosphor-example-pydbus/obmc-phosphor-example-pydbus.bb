SUMMARY = "Phosphor OpenBMC BSP Example Application"
DESCRIPTION = "Phosphor OpenBMC QEMU BSP example implementation."
PR = "r1"

DBUS_SERVICES = " \
        org.openbmc.examples.PythonService0 \
        org.openbmc.examples.PythonService1 \
        "

inherit obmc-phosphor-pydbus-service

client = "pyclient-sample"
SRC_URI += "file://${client}.py"

do_install_append() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/${client}.py ${D}${bindir}/${client}
}
