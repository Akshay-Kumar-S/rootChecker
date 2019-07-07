package com.twoxmars.rootchecker.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.twoxmars.rootchecker.R
import com.twoxmars.rootchecker.adapter.MainAdapter
import com.twoxmars.rootchecker.model.RootCheckInfo
import com.twoxmars.rootchecker.presenter.MainPresenterImpl
import com.twoxmars.rootchecker.presenter.interfaces.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainView {
    private val TAG = "MainActivity"
    private var tvRootStatus : TextView? = null
    private var tvDeviceName : TextView? = null
    private var tvDeviceVersion : TextView? = null
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
        tvRootStatus = findViewById<TextView>(R.id.root_status)
        tvDeviceName = findViewById<TextView>(R.id.device_name)
        tvDeviceVersion = findViewById<TextView>(R.id.device_version)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = MainAdapter(rootInfo)
        presenter = MainPresenterImpl(this, rootInfo)

        tvRootStatus?.text = "Verify Root Status"
        tvDeviceName?.text = ("Device: "+(presenter.getDeviceName()+" "+presenter.getDeviceModel()).capitalize())
        tvDeviceVersion?.text = ("Android Version: "+(presenter.getDeviceVersion()))
    }

    fun checkRoot(v: View) {
        rootInfo.clear()
        notifyDataSetChange()
        presenter.getRootStatus()
        presenter.startRootChecking()
    }

    override fun notifyDataSetChange() {
        Log.d(TAG, "notifyDataSetChange")
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun updateRootStatusUi(isRooted: Boolean) {
        Log.d(TAG, "updateRootStatusUi")
        tvRootStatus?.setTextColor(resources.getColor(R.color.colorAccent))
        if (isRooted) {
            tvRootStatus?.text = "Device is rooted"
        } else {
            tvRootStatus?.text = "Device is not detected as rooted or not properly rooted"
        }
    }
}
