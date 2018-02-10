package com.example.vlada.testandroidkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.vlada.testandroidkotlin.adapters.CustomAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val projects = ArrayList<Project>()

        projects.add(Project("Ttrtrtr"))
        projects.add(Project("GRGTFHF"))
        projects.add(Project("LKRFG"))

        val adapter = CustomAdapter(projects)
        recyclerView.adapter = adapter

    }
}
