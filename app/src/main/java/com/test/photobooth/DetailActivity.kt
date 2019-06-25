package com.test.photobooth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var photoName: String
    private lateinit var photoPath: String

    companion object {
        const val PHOTO_NAME = "PhotoName"
        const val PHOTO_PATH = "PhotoPath"

        fun launch(context: Context, name: String, path: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(PHOTO_NAME, name)
            intent.putExtra(PHOTO_PATH, path)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        //display up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        photoName = intent.getStringExtra(PHOTO_NAME)
        photoPath = intent.getStringExtra(PHOTO_PATH)

        title = photoName

        Glide.with(this).load(photoPath).into(iv_photo)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
