package com.test.photobooth

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoListAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<PhotoListAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var photos = emptyList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.bindData(photo)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_photo: ImageView = itemView.findViewById(R.id.iv_content)
        val tv_title: TextView = itemView.findViewById(R.id.tv_title)
        val tv_date: TextView = itemView.findViewById(R.id.tv_date)

        fun bindData(photo: Photo) {
            Glide.with(context).load(photo.path).into(iv_photo)
            tv_title.text = photo.name
            tv_date.text = photo.createdTime
            itemView.setOnClickListener {
                DetailActivity.launch(context, photo.name, photo.path)
            }
        }
    }


    internal fun setPhotos(photos: List<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }

}