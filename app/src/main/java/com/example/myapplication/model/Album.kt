package com.example.myapplication.model

import java.io.Serializable

data class Album(
        val id: Int=0,
        val title: String="",
        val category: String="",
        val createDate: String="",
        val ownerId:Int,
): Serializable {
    companion object {
        val EMPTY = Album(0, "", "", "",0)
    }
}
