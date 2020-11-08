package com.example.myapplication.ui.album

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.db.Interactors
import com.example.myapplication.utils.ConnectivityHelper


open class AlbumListViewModel(application: Application, protected val interactors: Interactors) :
    AndroidViewModel(application) {

    open fun isNetworkAvailable(context: Context): Boolean {
        val connectivityHelper = ConnectivityHelper()
        if (connectivityHelper.isConnectedToNetwork(context)) run {
            return true
        } else {
            return false
        }
    }

}
