package com.example.myapplication.ui.splash

import android.app.Application
import com.example.myapplication.db.Interactors
import com.example.myapplication.ui.album.AlbumListViewModel


class SplashViewModel(application: Application, interactors: Interactors) :
    AlbumListViewModel(application, interactors)
