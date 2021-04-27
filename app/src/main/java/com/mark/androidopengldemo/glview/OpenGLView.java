package com.mark.androidopengldemo.glview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.mark.androidopengldemo.render.BallRender;

public class OpenGLView extends GLSurfaceView {

    private BallRender mRenderer;

    private float mDownX = 0.0f;
    private float mDownY = 0.0f;

    public OpenGLView(Context context) {
        super(context);
        mRenderer = new BallRender();
        this.setRenderer(mRenderer);
    }

    public OpenGLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRenderer = new BallRender();
        this.setRenderer(mRenderer);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
            case MotionEvent.ACTION_MOVE:
                float mX = event.getX();
                float mY = event.getY();
                mRenderer.mLightX += (mX-mDownX)/10;
                mRenderer.mLightY -= (mY-mDownY)/10;
                mDownX = mX;
                mDownY = mY;
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}