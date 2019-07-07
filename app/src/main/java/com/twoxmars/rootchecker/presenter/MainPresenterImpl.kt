package com.twoxmars.rootchecker.presenter

import android.util.Log
import com.twoxmars.rootchecker.presenter.interfaces.MainPresenter
import com.twoxmars.rootchecker.presenter.interfaces.MainView
import com.twoxmars.rootchecker.model.RootCheckInfo
import com.twoxmars.rootchecker.agent.RootCheckManager

class MainPresenterImpl(main_view: MainView, root_info: ArrayList<RootCheckInfo>) : MainPresenter {
    private val TAG = "MainPresenterImpl"
    private val mainView: MainView = main_view
    private var rootInfo: ArrayList<RootCheckInfo> = root_info

    fun startRootChecking() {
        RootCheckManager(this).startChecking()
    }

    override fun rootCheckResult(rootCheckInfo: RootCheckInfo) {
        Log.d(TAG,"rootCheckResult")
        rootInfo.add(rootCheckInfo)
        mainView.notifyDataSetChange()
    }
}