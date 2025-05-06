package com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.components

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyennhatminh614.motobikedriverlicenseapp.R
import com.nguyennhatminh614.motobikedriverlicenseapp.composescreen.utils.draw9Patch

@Composable
fun NinePatchImage(
    context: Context,
    @DrawableRes ninePatchRes: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .draw9Patch(
                context = context,
                ninePatchRes = ninePatchRes
            )
    )
}

@Preview
@Composable
private fun PreviewNinePatchImage() {
    NinePatchImage(
        context = LocalContext.current,
        ninePatchRes = R.drawable.image_splash_banner,
        modifier = Modifier.size(240.dp, 240.dp)
    )
}