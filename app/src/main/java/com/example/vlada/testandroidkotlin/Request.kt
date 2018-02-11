package com.example.vlada.testandroidkotlin

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by Vlada on 10.02.2018.
 */
class GetRepos {

    fun run(url: String) : Project.List{

        var repositories: Project.List = Project.List()

        Thread(Runnable {

            val client = OkHttpClient()

            val request = Request.Builder().url(url)
                    .build()

            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()

            val repos = Gson().fromJson(responseText,
                    Project.List::class.java)

            repositories = repos

            //android.util.Log.d("Repos", repos.joinToString { it.name })

        }).start()

        return repositories
    }
}

