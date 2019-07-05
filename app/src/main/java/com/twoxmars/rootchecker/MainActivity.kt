package com.twoxmars.rootchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() , MainView {
    lateinit var mainAdapter : MainAdapter
    lateinit var rootInfo : ArrayList<RootCheckInfo>
    lateinit var presenter: MainPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun init() {
        rootInfo.add(RootCheckInfo("method1","content1", false))
        rootInfo.add(RootCheckInfo("method2","content2", true))
        rootInfo.add(RootCheckInfo("method3","content3", false))
        rootInfo.add(RootCheckInfo("method4","content4", true))
        rootInfo.add(RootCheckInfo("method5","content5", false))
        rootInfo.add(RootCheckInfo("method6","content6", true))
        rootInfo.add(RootCheckInfo("method7","content7", false))
        rootInfo.add(RootCheckInfo("method8","content8", true))

        mainAdapter = MainAdapter(rootInfo);
        presenter =  MainPresenterImpl(this)
    }

    fun checkRoot(v : View) {

    }

    override fun notifyDataSetChange() {

    }

}
