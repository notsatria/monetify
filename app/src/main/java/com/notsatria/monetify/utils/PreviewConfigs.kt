package com.notsatria.monetify.utils

import androidx.compose.ui.tooling.preview.Preview

object PreviewConfigs {
    @Preview(
        showBackground = true,
        name = "Pixel 4",
        device = "spec:shape=Normal,width=411,height=891,unit=dp,dpi=420"
    )
    @Preview(
        showBackground = true,
        name = "Pixel C Tablet",
        device = "spec:shape=Normal,width=2560,height=1800,unit=dp,dpi=320"
    )
    @Preview(
        showBackground = true,
        name = "Small screen",
        widthDp = 320,
        heightDp = 640
    )
    @Preview(
        showBackground = true,
        name = "Pixel Fold",
        device = "spec:shape=Normal,width=842,height=2260,unit=dp,dpi=420"
    )
    annotation class DevicePreviews
}