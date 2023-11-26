package pl.aprilapps.easyphotopicker

import android.content.ActivityNotFoundException
import android.content.Intent

object LineageosAperturePatcher {
    private fun customize(intent: Intent) {
        intent.setPackage("org.lineageos.aperture")
        intent.setClassName("org.lineageos.aperture", "org.lineageos.aperture.CaptureActivity")
    }

    @Suppress("UNUSED_PARAMETER")
    private fun keepOriginal(intent: Intent) {
    }

    fun startCamera(
        caller: Any,
        customStart: (Any, (Intent) -> Unit) -> Unit
    ) {
        try {
            customStart(caller, this::customize)
        } catch (exception: ActivityNotFoundException) {
            customStart(caller, this::keepOriginal)
        }
    }
}