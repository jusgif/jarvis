package com.blurr.voice.utilities

import android.content.Context
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher

/**
 * Compatibility wrapper retained for existing activity wiring.
 * Always-on wake-word listening is disabled; use the in-app push-to-talk controls.
 */
class WakeWordManager(
    private val context: Context,
    @Suppress("UNUSED_PARAMETER") private val permissionLauncher: ActivityResultLauncher<String>
) {
    fun handleWakeWordButtonClick(wakeWordButton: TextView) {
        Toast.makeText(context, "Use the microphone button to speak to Jarvis.", Toast.LENGTH_SHORT).show()
        updateButtonState(wakeWordButton)
    }

    fun updateButtonState(wakeWordButton: TextView) {
        wakeWordButton.text = "Push to Talk"
    }
}