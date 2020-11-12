package com.example.myapplication.model

class Album(
        val title: String="",
        val category: String="",
        val createDate: String="",
        val ownerId:Int,
): BaseModel() {
    companion object {
        val EMPTY = Album( "", "", "",0)
    }
}
