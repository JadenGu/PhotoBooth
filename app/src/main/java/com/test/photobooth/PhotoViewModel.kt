package com.test.photobooth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application) : AndroidViewModel(application) {

    private val photoRepository: PhotoRepository

    val photos: LiveData<List<Photo>>

    init {
        val photoDao = PhotoRoomDatabase.getInstance(application).photoDao()
        photoRepository = PhotoRepository(photoDao)
        photos = photoRepository.photos
    }

    fun insert(photo: Photo) = viewModelScope.launch(Dispatchers.IO) {
        photoRepository.insert(photo)
    }
}