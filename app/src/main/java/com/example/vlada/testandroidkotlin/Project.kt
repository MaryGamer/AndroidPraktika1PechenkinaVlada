package com.example.vlada.testandroidkotlin

/**
 * Created by Vlada on 10.02.2018.
 */

data class Project(val name: String) {

    class List : ArrayList<Project>()
}