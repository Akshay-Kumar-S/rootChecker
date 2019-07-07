package com.twoxmars.rootchecker.agent

import android.util.Log
import com.twoxmars.rootchecker.model.RootCheckInfo
import com.twoxmars.rootchecker.presenter.MainPresenterImpl

class RootCheckManager(private val mainPresenterImpl: MainPresenterImpl) {
    private val TAG = "RootCheckManager"
    private val rootPaths = object : ArrayList<String>() {
        init {
            add("/system/xbin/su")
            add("/system/bin/su")
            add("/system/app/Superuser.apk")
            add("/sbin/su")
            add("/data/local/bin/su")
            add("/data/local/xbin/su")
            add("/system/bin/failsafe/su")
            add("/data/local/su")
            add("/system/sd/xbin/su")
        }
    }

    fun startChecking() {
        val rootAgent = RootAgent.instance
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("Method 1", "checking test-keys present in buildTags", rootAgent.checkRootMethod1())
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("Method 2", "execute /system/xbin/which", rootAgent.checkRootMethod2())
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 3",
                "checking package eu.chainfire.supersu is installed or not",
                rootAgent.checkRootMethod3()
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 4",
                ("Checking path ") + (rootPaths[0] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[0])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 5",
                ("Checking path ") + (rootPaths[1] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[1])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 6",
                ("Checking path ") + (rootPaths[2] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[2])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 7",
                ("Checking path ") + (rootPaths[3] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[3])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 8",
                ("Checking path ") + (rootPaths[4] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[4])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 9",
                ("Checking path ") + (rootPaths[5] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[5])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 10",
                ("Checking path ") + (rootPaths[6] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[6])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 11",
                ("Checking path ") + (rootPaths[7] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[7])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "Method 12",
                ("Checking path ") + (rootPaths[8] + (" present or not")),
                rootAgent.isRootPathExist(rootPaths[7])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("Method 13", "can execute su", rootAgent.canExecuteSu())
        )
    }
}