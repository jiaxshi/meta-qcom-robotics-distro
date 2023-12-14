SUMMARY = "Basic programs and scripts"
DESCRIPTION = "Package group to bring in all basic packages"

LICENSE = "BSD-3-Clause-Clear"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"

PACKAGES = ' \
    packagegroup-qcom-robotics \
    packagegroup-robotics-filesystem-utils \
    packagegroup-robotics-support-utils \
    '

RDEPENDS:packagegroup-qcom-robotics = "\
    packagegroup-robotics-filesystem-utils \
    packagegroup-robotics-support-utils \
    ${@bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', 'packagegroup-qti-ros2-humble', '', d)} \
    modemmanager \
    librealsense2 \
    qirf-sdk \
    "

RDEPENDS:packagegroup-robotics-support-utils = "\
    chrony \
    libinput \
    libinput-bin \
    libnl \
    libxml2 \
    "

RDEPENDS:packagegroup-robotics-filesystem-utils = "\
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    "
