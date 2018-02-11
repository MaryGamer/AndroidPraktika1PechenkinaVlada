package com.example.vlada.testandroidkotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.vlada.testandroidkotlin.adapters.CustomAdapter
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        Thread(Runnable {

            val client = OkHttpClient()

            val request = Request.Builder().url("https://api.github.com/users/square/repos")
                    .build()

            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()

            val repos = Gson().fromJson(responseText,
                    Project.List::class.java)

            runOnUiThread {
                val adapter = CustomAdapter(repos)
                recyclerView.adapter = adapter
            }

            //android.util.Log.d("Repos", repos.joinToString { it.name })
        }).start()

    }

}

