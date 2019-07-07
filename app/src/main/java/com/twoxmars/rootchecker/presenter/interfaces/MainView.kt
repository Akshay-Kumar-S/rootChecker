package com.twoxmars.rootchecker.presenter.interfaces

interface MainView {
    fun notifyDataSetChange()
    fun updateRootStatusUi(isRooted: Boolean)
}