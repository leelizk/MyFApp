package com.example.myapplication.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.db.Interactors
import com.example.myapplication.ui.album.AlbumListViewModel

object ViewModelFactory : ViewModelProvider.Factory {

    lateinit var application: Application
    private lateinit var dependencies: Interactors

    fun inject(application: Application, dependencies: Interactors) {
        ViewModelFactory.application = application
        ViewModelFactory.dependencies = dependencies
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (AlbumListViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(Application::class.java, Interactors
            ::class.java)
                .newInstance(
                    application,
                    dependencies
                )
        } else {
            throw IllegalStateException("ViewModel must extend AlbumListViewModel")
        }
    }

}