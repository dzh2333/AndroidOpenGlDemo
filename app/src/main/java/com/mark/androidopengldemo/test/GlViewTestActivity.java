package com.mark.androidopengldemo.test;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mark.androidopengldemo.R;
import com.mark.androidopengldemo.render.MyGLView;
import com.mark.androidopengldemo.render.MyRender;
import com.mark.androidopengldemo.util.TextResReader;

public class GlViewTestActivity extends AppCompatActivity {

    private MyGLView glSurfaceView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gl_test);
        glSurfaceView = findViewById(R.id.gl_test_view);

        glSurfaceView.setEGLContextClientVersion(3);
        glSurfaceView.setRenderer(new MyRender(this));

        readShader();
    }

    @Override
    protected void onPause() {
        super.onPause();
        glSurfaceView.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    private void readShader(){

    }
}
