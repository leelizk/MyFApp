package com.example.myapplication.demoui.details

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.db.Interactors
import com.example.myapplication.model.Photo
import com.example.myapplication.ui.album.AlbumListViewModel


class DetailsViewModel(application: Application, interactors: Interactors) :
    AlbumListViewModel(application, interactors) {
    var photoEntity: MutableLiveData<Photo> = MutableLiveData()
}