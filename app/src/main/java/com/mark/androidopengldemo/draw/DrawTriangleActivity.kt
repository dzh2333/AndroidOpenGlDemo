package com.mark.androidopengldemo.draw

import android.graphics.Color
import android.opengl.GLSurfaceView
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mark.androidopengldemo.R
import com.mark.androidopengldemo.render.TriangleRender

class DrawTriangleActivity : AppCompatActivity(){

    private var glView : GLSurfaceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_triangle)
        glView = findViewById(R.id.draw_triangle_gl_view)

        glView!!.setEGLContextClientVersion(3)
        glView!!.setRenderer(object : TriangleRender(){})
    }
}