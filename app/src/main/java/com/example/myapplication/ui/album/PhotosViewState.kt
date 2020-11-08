package com.example.myapplication.ui.album

import com.example.myapplication.model.Photo


data class PhotosViewState(
    var photos:List<Photo>?,
    val loading:Boolean,
    var errorCode: Int?
)