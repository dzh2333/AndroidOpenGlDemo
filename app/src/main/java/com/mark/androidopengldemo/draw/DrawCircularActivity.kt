package com.mark.androidopengldemo.draw

import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mark.androidopengldemo.R
import com.mark.androidopengldemo.render.CirculeRender
import com.mark.androidopengldemo.render.LineRender

public class DrawCircularActivity : AppCompatActivity(){

    private var glView : GLSurfaceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cir)
        glView = findViewById(R.id.diy_cir_view)
        glView!!.setEGLContextClientVersion(3)
        glView!!.setRenderer(CirculeRender())
    }
}