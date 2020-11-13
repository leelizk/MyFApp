package com.example.myapplication.ui.album

import com.example.myapplication.model.Photo


interface RecyclerItemListener {
    fun onItemSelected(photoEntity: Photo)
}
