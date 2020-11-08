package com.example.myapplication.model

import java.util.*

open class BaseModel<T>{
    var id:Int=0
    var createTime:Date =  Date()
    var updateTime:Date = Date()
}