package com.test.photobooth

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class PhotoRepository(private val photoDao: PhotoDao) {

    //get all photos from photo dao
    val photos: LiveData<List<Photo>> = photoDao.getPhotos()

    // insert a photo into database
    @WorkerThread
    suspend fun insert(photo: Photo) {
        photoDao.insert(photo)
    }

}