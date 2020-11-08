package com.example.myapplication.model

import java.io.Serializable
import java.util.*

data class User(
        val id: Int=0,
        val account: String="",
        val password: String="",
        val nickname: String="",
        val sex: Int=1,
        val remark: String="",
        var createDate: Date
): Serializable {
    companion object {
        val EMPTY = User(0, "", "", "", 1,"",Date());
    }
}
