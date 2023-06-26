package com.ritikcoder.project29ofandroiddev_videoplayer1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView

class MainActivity2 : AppCompatActivity() {

    private var videoPlayer: VideoView?= null
    private var videoController: MediaController?= null
    private var exitVaridation: Boolean= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        videoPlayer= findViewById(R.id.videoView)

        configVideoPlayer()

    }

    private fun configVideoPlayer() {
        val textView: TextView= findViewById(R.id.textView)
        if(videoController== null){
            videoController= MediaController(this)
            videoController!!.setAnchorView(this.videoPlayer)
        }
        videoPlayer!!.setMediaController(videoController)
        videoPlayer!!.setVideoURI(Uri.parse("android.resource://"+ packageName+ "/"+ R.raw.test))

        videoPlayer!!.requestFocus()
        videoPlayer!!.pause()
        videoPlayer!!.setOnErrorListener { _, _, _ ->
            Toast.makeText(applicationContext, "Getting Error", Toast.LENGTH_SHORT).show()
            false

        }
        videoPlayer!!.setOnClickListener {
            textView.alpha= 0f
            exitVaridation= false
        }
        videoPlayer!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video completed", Toast.LENGTH_SHORT).show()
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(exitVaridation){
            finish()
        }else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
            exitVaridation= true
        }
    }

}