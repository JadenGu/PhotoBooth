package com.test.photobooth

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
data class Photo(@PrimaryKey val name: String, val path: String, val createdTime: String)