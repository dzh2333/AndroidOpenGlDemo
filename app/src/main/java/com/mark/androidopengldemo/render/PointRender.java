package com.mark.androidopengldemo.render;

import android.opengl.GLES30;
import android.opengl.GLSurfaceView;

import com.mark.androidopengldemo.util.ShaderHelper;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PointRender implements GLSurfaceView.Renderer {

    private static final int POSITION_COMPONENT_COUNT = 3;

    private float[] points = new float[]{
            0.0f,
            0.5f,
            0.0f
    };

    //绿色
    private float color[] = {
            0.0f, 1.0f, 0.0f, 1.0f
    };

    /**
     * 顶点着色器
     */
    private String vertextShader =
            "#version 300 es \n" +
                    "layout (location = 0) in vec4 vPosition;\n"
                    + "layout (location = 1) in vec4 aColor;\n"
                    + "out vec4 vColor;\n"
                    + "void main() { \n"
                    + "gl_Position  = vPosition;\n"
                    + "gl_PointSize = 80.0;\n"
                    + "vColor = aColor;\n"
                    + "}\n";

    private String fragmentShader =
            "#version 300 es \n" +
                    "precision mediump float;\n"
                    + "in vec4 vColor;\n"
                    + "out vec4 fragColor;\n"
                    + "void main() { \n"
                    + "fragColor = vColor; \n"
                    + "}\n";

    private FloatBuffer pointBuffer;
    private final FloatBuffer colorBuffer;

    private int mProgram;

    public PointRender(){
        pointBuffer = ByteBuffer.allocateDirect(points.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        pointBuffer.put(points);
        pointBuffer.position(0);

        colorBuffer = ByteBuffer.allocateDirect(color.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        //传入指定的数据
        colorBuffer.put(color);
        colorBuffer.position(0);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        //灰色背景
        GLES30.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);
        //编译
        final int vertexShaderId = ShaderHelper.compileVertexShader(vertextShader);
        final int fragmentShaderId = ShaderHelper.compileFragmentShader(fragmentShader);
        //鏈接程序片段
        mProgram = ShaderHelper.linkProgram(vertexShaderId, fragmentShaderId);
        //在OpenGLES环境中使用程序片段
        GLES30.glUseProgram(mProgram);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int width, int height) {
        GLES30.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl10) {
        GLES30.glClear(GLES30.GL_COLOR_BUFFER_BIT);

        //准备坐标数据
        GLES30.glVertexAttribPointer(0,
                POSITION_COMPONENT_COUNT,
                GLES30.GL_FLOAT,
                false,
                0,
                pointBuffer);
        //启动句柄
        GLES30.glEnableVertexAttribArray(0);
        GLES30.glEnableVertexAttribArray(1);
        GLES30.glVertexAttribPointer(1,
                4,//数量为4
                GLES30.GL_FLOAT,
                false,
                0,
                colorBuffer);

        //绘制顶点      参数:1、模式2、起点3、顶点数量
        GLES30.glDrawArrays(GLES30.GL_POINTS, 0, 1);

        //禁止顶点数组的句柄
        GLES30.glDisableVertexAttribArray(0);
        GLES30.glDisableVertexAttribArray(1);
    }
}
