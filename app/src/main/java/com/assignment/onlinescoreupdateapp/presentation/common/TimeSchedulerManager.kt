package com.assignment.onlinescoreupdateapp.presentation.common

import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate


object TimeSchedulerManager {

    private lateinit var timer: Timer

    fun startTimer(action: () -> Unit) {
        timer = Timer()
        timer.scheduleAtFixedRate(30000L, 30000L) {
            action()
        }
    }

    fun stopTimer() {
        timer.cancel()
    }

}