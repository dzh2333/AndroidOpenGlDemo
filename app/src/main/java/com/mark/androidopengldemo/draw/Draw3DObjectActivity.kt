package com.mark.androidopengldemo.draw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mark.androidopengldemo.glview.OpenGLView

public class Draw3DObjectActivity : AppCompatActivity() {

    private var mOpenGLView: OpenGLView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mOpenGLView = OpenGLView(this);
        setContentView(mOpenGLView);
    }
}