package com.mark.androidopengldemo.draw

import android.opengl.GLSurfaceView
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.mark.androidopengldemo.R
import com.mark.androidopengldemo.render.LineRender
import com.mark.androidopengldemo.render.PointRender

public class DrawLineActivity : AppCompatActivity() {

    private var glView : GLSurfaceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_line);

        glView = findViewById(R.id.draw_triangle_gl_view)
        glView!!.setEGLContextClientVersion(3)
        glView!!.setRenderer(LineRender())

    }
}