package com.twoxmars.rootchecker

import android.app.Application
import android.content.Context

class RootApplication : Application() {

    companion object {
        private var instance: RootApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}