package com.twoxmars.rootchecker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.twoxmars.rootchecker.*
import com.twoxmars.rootchecker.adapter.MainAdapter
import com.twoxmars.rootchecker.model.RootCheckInfo
import com.twoxmars.rootchecker.presenter.MainPresenterImpl
import com.twoxmars.rootchecker.presenter.interfaces.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainView {
    private val TAG = "MainActivity"
    private lateinit var mainAdapter: MainAdapter
    private lateinit var rootInfo: ArrayList<RootCheckInfo>
    private lateinit var presenter: MainPresenterImpl
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        rootInfo = ArrayList()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        mainAdapter = MainAdapter(rootInfo)
        recyclerView.adapter = mainAdapter
        presenter = MainPresenterImpl(this, rootInfo)
    }

    fun checkRoot(v: View) {
        presenter.startRootChecking()
    }

    override fun notifyDataSetChange() {
        Log.d(TAG, "notifyDataSetChange")
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
