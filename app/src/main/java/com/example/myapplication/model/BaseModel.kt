package com.example.myapplication.model

import java.io.Serializable
import java.util.*

abstract class BaseModel(): Serializable {
    open var id:Int=0
    open var createTime:Date =  Date()
    open var updateTime:Date = Date()
}