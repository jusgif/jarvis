package com.blurr.voice.api

import android.content.Context
import android.util.Log

/**
 * Legacy compatibility shim. Wake-word detection has been removed in favor of
 * user-initiated push-to-talk, so this class deliberately does not open a microphone.
 */
class PorcupineWakeWordDetector(
    private val context: Context,
    private val onWakeWordDetected: () -> Unit,
    private val onApiFailure: () -> Unit
) {
    fun start() {
        Log.i("WakeWordDetector", "Wake-word detection is disabled; use push-to-talk.")
        onApiFailure()
    }

    fun stop() = Unit
}