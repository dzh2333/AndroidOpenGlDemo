package com.mark.androidopengldemo.draw;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mark.androidopengldemo.R;
import com.mark.androidopengldemo.render.RectangleRender;

public class DrawRectActivity extends AppCompatActivity {

    private GLSurfaceView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rect);

        view = findViewById(R.id.diy_rect);
        view.setEGLContextClientVersion(3);
        view.setRenderer(new RectangleRender());
    }
}
