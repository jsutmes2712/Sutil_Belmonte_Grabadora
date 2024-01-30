package com.example.sutil_belmonte_grabadora.recycler

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sutil_belmonte_grabadora.PaginaPrincipal
import com.example.sutil_belmonte_grabadora.PaginaReproducir
import com.example.sutil_belmonte_grabadora.R
import com.example.sutil_belmonte_grabadora.Reproductor
import com.example.sutil_belmonte_grabadora.data.Video

class VideoViewHolder(var view: View) : RecyclerView.ViewHolder(view)  {

    private var name = view.findViewById<TextView>(R.id.labelName)
    private var url = view.findViewById<TextView>(R.id.labelUrl)
    private var btnVer = view.findViewById<Button>(R.id.btnVer)

    fun bindView(video : Video){
        name.text = video.nombre
        url.text = video.url

        btnVer.setOnClickListener {
            var intent = Intent(this.name.context, Reproductor::class.java)
            intent.putExtra("url", url.text.toString())
            ContextCompat.startActivity(this.name.context, intent, Bundle())
        }
    }

}