package com.twoxmars.rootchecker.presenter.interfaces

import com.twoxmars.rootchecker.model.RootCheckInfo

interface MainPresenter {
    fun rootCheckResult(rootCheckInfo: RootCheckInfo)
}