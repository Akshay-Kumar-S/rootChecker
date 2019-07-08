package com.twoxmars.rootchecker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.twoxmars.rootchecker.R
import com.twoxmars.rootchecker.model.RootCheckInfo

class MainAdapter(private val rootCheckInfo: ArrayList<RootCheckInfo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val TAG = "MainAdapter"
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG,"onCreateViewHolder ")
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_row, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG,"onBindViewHolder "+rootCheckInfo[position])
        holder.bindItems(rootCheckInfo[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        Log.d(TAG,"getItemCount "+rootCheckInfo.size)
        return rootCheckInfo.size
    }

    //the class is holding the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(info: RootCheckInfo) {
            val title = itemView.findViewById(R.id.tv_method_title) as TextView
            val content = itemView.findViewById(R.id.tv_method_content) as TextView
            val result = itemView.findViewById(R.id.success_failed) as ImageView
            title.text = info.title
            content.text = info.content
            if (info.result)
                result.setImageResource(R.drawable.ic_check_24dp)
            else
                result.setImageResource(R.drawable.ic_close_24dp)
        }
    }
}