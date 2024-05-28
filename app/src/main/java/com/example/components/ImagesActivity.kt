package com.example.components

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        val videoLocal: VideoView = findViewById(R.id.videoViewLocal)
        val mcLocal = MediaController(this)
        mcLocal.setAnchorView(videoLocal)
        videoLocal.setVideoPath("android.resource://" + packageName + "/" + R.raw.video)
        videoLocal.setMediaController(mcLocal)
        videoLocal.start()

        val videoView: VideoView = findViewById(R.id.videoViewWeb)
        val mcWeb = MediaController(this)

        mcWeb.setAnchorView(videoView)
        videoView.setVideoPath("https://jotajotavm.com/img/video.mp4")
        videoView.setMediaController(mcWeb)
        videoView.start()
    }
}