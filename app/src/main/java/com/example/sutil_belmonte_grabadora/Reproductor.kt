package com.example.sutil_belmonte_grabadora

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Point
import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.lang.IllegalStateException

class Reproductor : AppCompatActivity(), SurfaceHolder.Callback {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var progressBar: ProgressBar
    private lateinit var surfaceView: SurfaceView
    private var playbackPosition = 0
    private lateinit var rtspUrl : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductor)

        rtspUrl = intent.getStringExtra("url").toString()

        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        surfaceView = findViewById<SurfaceView>(R.id.surfaceView)

        val holder = surfaceView.holder
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        val surface = holder.surface

        setupMediaPlayer(surface)
        preparateMediaPlayer()
    }

    override fun surfaceChanged(holder: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {

    }

    override fun onPause() {
        super.onPause()

        playbackPosition = mediaPlayer.currentPosition
    }

    override fun onStop() {
        mediaPlayer.stop()
        //Libera los recursos asociado al mediaPlayer
        mediaPlayer.release()

        super.onStop()
    }

    private fun createAudioAtributtes(): AudioAttributes {
        val builder = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MOVIE)
            .build()
        return builder

    }

    private fun setupMediaPlayer(surface: Surface) {

        progressBar.visibility = View.VISIBLE
        mediaPlayer = MediaPlayer()
        mediaPlayer.setSurface(surface)
        val audioAttributes = createAudioAtributtes()
        mediaPlayer.setAudioAttributes(audioAttributes)
        //var uri = Uri.parse(rtspUrl)
        try {
            //mediaPlayer.setDataSource(this, uri)
            mediaPlayer.setDataSource(rtspUrl)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    private fun setSurfaceDimensions(player: MediaPlayer, width: Int, heigth: Int) {
        if (width > 0 && heigth > 0) {
            val aspectRatio = heigth.toFloat() / width.toFloat()
            val screenDimensions = Point()
            windowManager.defaultDisplay.getSize(screenDimensions)
            val surfaceWidth = screenDimensions.x
            val surfaceHeigt = (surfaceWidth * aspectRatio).toInt()
            val params = FrameLayout.LayoutParams(surfaceWidth, surfaceHeigt)
            surfaceView.layoutParams = params
            val holder = surfaceView.holder
            player.setDisplay(holder)
        }
    }

    private fun preparateMediaPlayer() {
        try {
            mediaPlayer.prepareAsync()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }
        mediaPlayer.setOnPreparedListener {
            progressBar.visibility = View.INVISIBLE
            mediaPlayer.seekTo(playbackPosition)
            mediaPlayer.start()
        }
        mediaPlayer.setOnVideoSizeChangedListener { player, width, heigth ->
            setSurfaceDimensions(player, width, heigth)
        }
    }
}