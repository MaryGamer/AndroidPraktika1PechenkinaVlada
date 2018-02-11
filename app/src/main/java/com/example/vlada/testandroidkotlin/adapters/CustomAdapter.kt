package com.example.vlada.testandroidkotlin.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.vlada.testandroidkotlin.R
import com.example.vlada.testandroidkotlin.Project

/**
 * Created by Vlada on 10.02.2018.
 */
class CustomAdapter(val projectList: ArrayList<Project>)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?,
                                    viewType: Int): CustomAdapter.ViewHolder {

        val view: View = LayoutInflater.from(parent?.context).
                inflate(R.layout.list_item, parent, false)

        val cardView = view.findViewById<CardView>(R.id.cardView)
        cardView.radius = 5.0F;

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {

        holder.bindItems(projectList[position])
    }

    override fun getItemCount(): Int {
        return projectList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(project: Project) {

            val textViewProjectName = itemView.findViewById<TextView>(R.id.projectName)
            textViewProjectName.text = project.name
        }
    }
}