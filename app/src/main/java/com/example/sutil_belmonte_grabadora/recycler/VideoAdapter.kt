package com.example.sutil_belmonte_grabadora.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sutil_belmonte_grabadora.R
import com.example.sutil_belmonte_grabadora.data.Video
import com.example.sutil_belmonte_grabadora.data.VideoAPP

class VideoAdapter: RecyclerView.Adapter<VideoViewHolder>(){

    val app = VideoAPP

    private var list: List<Video> = emptyList()

    fun addItems(items: List<Video>){
        this.list = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VideoViewHolder(layoutInflater.inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int){
        val std = list[position]
        holder.bindView(std)
    }

    override fun getItemCount(): Int = list.size
}