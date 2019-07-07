package com.twoxmars.rootchecker.agent

import android.content.pm.PackageManager
import com.twoxmars.rootchecker.RootApplication
import java.io.*

class RootAgent {

    companion object {
        val instance = RootAgent()
    }

    fun checkRootMethod1(): Boolean {
        val buildTags = android.os.Build.TAGS
        return buildTags != null && buildTags.contains("test-keys")
    }

    fun checkRootMethod2(): Boolean {
        var process: Process? = null
        try {
            process = Runtime.getRuntime().exec(arrayOf("/system/xbin/which", "su"))
            val `in` = BufferedReader(InputStreamReader(process!!.inputStream))
            return `in`.readLine() != null
        } catch (t: Throwable) {
            return false
        } finally {
            process?.destroy()
        }
    }

    fun checkRootMethod3(): Boolean {
        try {
            val pm = RootApplication.applicationContext().packageManager
            pm.getPackageInfo("eu.chainfire.supersu", PackageManager.GET_ACTIVITIES)
            return true
        } catch (ex: Exception) {
            return false
        }
    }

    fun isRootPathExist(path: String): Boolean {
        try {
            return File(path).exists()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun canExecuteSu(): Boolean {
        val process: Process
        try {
            process = Runtime.getRuntime().exec("su")
        } catch (e: IOException) {
            return false
        }

        try {
            val outputStream = DataOutputStream(process.outputStream)
            outputStream.writeBytes("exit\n")
            outputStream.flush()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val result: Int
        try {
            result = process.waitFor()
        } catch (e1: InterruptedException) {
            return false
        }
        return result == 0
    }
}