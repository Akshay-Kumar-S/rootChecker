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
        Log.d(TAG,"startChecking: "+rootAgent.checkRootMethod1())
        Log.d(TAG,"startChecking: "+rootAgent.checkRootMethod2())
        Log.d(TAG,"startChecking: "+rootAgent.checkRootMethod3())
        Log.d(TAG,"startChecking: "+rootAgent.canExecuteSu())
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("method1", "content1", rootAgent.checkRootMethod1())
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("method2", "content1", rootAgent.checkRootMethod2())
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("method3", "content1", rootAgent.checkRootMethod3())
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 1", rootPaths[0], rootAgent.isRootPathExist(rootPaths[0])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 2", rootPaths[1], rootAgent.isRootPathExist(rootPaths[1])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 3", rootPaths[2], rootAgent.isRootPathExist(rootPaths[2])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 4", rootPaths[3], rootAgent.isRootPathExist(rootPaths[3])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 5", rootPaths[4], rootAgent.isRootPathExist(rootPaths[4])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 6", rootPaths[5], rootAgent.isRootPathExist(rootPaths[5])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 7", rootPaths[6], rootAgent.isRootPathExist(rootPaths[6])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 8", rootPaths[7], rootAgent.isRootPathExist(rootPaths[7])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo(
                "path check 9", rootPaths[8], rootAgent.isRootPathExist(rootPaths[8])
            )
        )
        mainPresenterImpl.rootCheckResult(
            RootCheckInfo("is device rooted", "can execute su", rootAgent.canExecuteSu())
        )
    }
}