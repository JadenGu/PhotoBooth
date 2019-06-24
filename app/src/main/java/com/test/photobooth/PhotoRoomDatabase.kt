package com.test.photobooth

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Photo::class], version = 1)
abstract class PhotoRoomDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoRoomDatabase? = null

        fun getInstance(context: Context): PhotoRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(context.applicationContext, PhotoRoomDatabase::class.java, "Photo_database")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}