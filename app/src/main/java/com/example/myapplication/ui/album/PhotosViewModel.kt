package com.example.myapplication.ui.album

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.Error.Companion.NETWORK_ERROR
import com.example.myapplication.data.Resource
import com.example.myapplication.db.Interactors
import com.example.myapplication.model.Photo
import com.example.myapplication.utils.Event
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PhotosViewModel(application: Application, interactors: Interactors) :
    AlbumListViewModel(application, interactors) {

    val listPhotosViewStateMutableLiveData = MutableLiveData<PhotosViewState>()

    /**
     * UI actions as event, user action is single one time event, Shouldn't be multiple time consumption
     */
    private val openPhotoDetailsPrivate = MutableLiveData<Event<Photo>>()
    val _openPhotoDetails: LiveData<Event<Photo>> get() = openPhotoDetailsPrivate

    /* getPhotosFromDB */
    fun getPhotosFromDB() {
        listPhotosViewStateMutableLiveData.postValue(PhotosViewState(null,true,null))
       /* GlobalScope.launch {
            listPhotosViewStateMutableLiveData.postValue(PhotosViewState(interactors.getAllPhotosFromDB.invoke(),false,0))
        }*/
    }

    /* Call insertAllPhotos when getPhotosFromWS suceeded */
    fun getPhotosFromWS() {
        var serviceResponse: Resource<List<Photo>>
        listPhotosViewStateMutableLiveData.postValue(PhotosViewState(null,true,null))

        GlobalScope.launch {
            try {
               // serviceResponse = interactors.getAllPhotosFromWS()
                //listPhotosViewStateMutableLiveData.postValue(PhotosViewState(serviceResponse.data,false,0))
                //serviceResponse.data?.let { interactors.insertAllPhotos(it) }
            } catch (e: Exception) {
                listPhotosViewStateMutableLiveData.postValue(PhotosViewState(null,false,NETWORK_ERROR))
            }
        }
    }

    /* openPhotoDetails */
    fun openPhotoDetails(photoEntity: Photo) {
        openPhotoDetailsPrivate.value = Event(photoEntity)
    }


}