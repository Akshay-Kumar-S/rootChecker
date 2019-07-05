package com.twoxmars.rootchecker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val rootCheckInfo: ArrayList<RootCheckInfo>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_row, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bindItems(rootCheckInfo[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return rootCheckInfo.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(info: RootCheckInfo) {
            val title = itemView.findViewById(R.id.tv_method_title) as TextView
            val content = itemView.findViewById(R.id.tv_method_content) as TextView
            val result = itemView.findViewById(R.id.checkbox) as CheckBox


//            textViewName.text = user.name
//            textViewAddress.text = user.address
        }
    }
}