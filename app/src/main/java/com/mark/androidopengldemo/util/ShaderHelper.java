package com.mark.androidopengldemo.util;

import android.util.Log;

import static android.opengl.GLES20.GL_COMPILE_STATUS;
import static android.opengl.GLES20.GL_FRAGMENT_SHADER;
import static android.opengl.GLES20.GL_LINK_STATUS;
import static android.opengl.GLES20.GL_VALIDATE_STATUS;
import static android.opengl.GLES20.GL_VERTEX_SHADER;
import static android.opengl.GLES20.glAttachShader;
import static android.opengl.GLES20.glCompileShader;
import static android.opengl.GLES20.glCreateProgram;
import static android.opengl.GLES20.glCreateShader;
import static android.opengl.GLES20.glDeleteShader;
import static android.opengl.GLES20.glGetProgramInfoLog;
import static android.opengl.GLES20.glGetProgramiv;
import static android.opengl.GLES20.glGetShaderInfoLog;
import static android.opengl.GLES20.glGetShaderiv;
import static android.opengl.GLES20.glLinkProgram;
import static android.opengl.GLES20.glShaderSource;
import static android.opengl.GLES20.glValidateProgram;

public class ShaderHelper {
    private static final String TAG = ShaderHelper.class.getSimpleName();
    public static int compileVertexShader(String shaderVCode){
        return compileShader(GL_VERTEX_SHADER, shaderVCode);
    }

    public static int compileFragmentShader(String shaderVCode){
        return compileShader(GL_FRAGMENT_SHADER, shaderVCode);
    }

    private static int compileShader(int type, String shaderCode){
        final int shaderObjected = glCreateShader(type);
        if (shaderObjected == 0){
            Log.e(TAG, "compileShader: Could not create new shader");
            return 0;
        }
        //上传和编译着色器源代码
        glShaderSource(shaderObjected, shaderCode);
        glCompileShader(shaderObjected);
        //取出编译状态
        final int[] compiltStatus = new int[1];
        glGetShaderiv(shaderObjected, GL_COMPILE_STATUS, compiltStatus, 0);
        //取出这色漆信息日志
//        glGetShaderInfoLog(shaderObjected);
        //验证编译状态并返回着色器对象ID
        if (compiltStatus[0] == 0){
            glDeleteShader(shaderObjected);
        }

        return shaderObjected;
    }

    /**
     * 链接程序
     * @param vertexShaderId
     * @param fragmentShaderId
     * @return
     */
    public static int linkProgram(int vertexShaderId, int fragmentShaderId){
        final int programObjectId = glCreateProgram();
        if (programObjectId == 0){
            return 0;
        }
        glAttachShader(programObjectId, vertexShaderId);
        glAttachShader(programObjectId, fragmentShaderId);
        //链接程序
        glLinkProgram(programObjectId);
        final int[] linkStatus = new int[1];
        glGetProgramiv(programObjectId, GL_LINK_STATUS, linkStatus, 0);
        //验证
        if (linkStatus[0] == 0){
            glDeleteShader(programObjectId);
            return 0;
        }
        return  programObjectId;
    }

    public static boolean validDateProgram(int programObjectId){
        glValidateProgram(programObjectId);
        final int[] validDataStatus = new int[1];
        glGetProgramiv(programObjectId, GL_VALIDATE_STATUS, validDataStatus, 0);
        return validDataStatus[0] != 0;
    }

    public static int buildProgram(String vertexShaderSource, String fragmentShaderSource){
        int vertexShader = compileVertexShader(vertexShaderSource);
        int fragmentShader = compileFragmentShader(fragmentShaderSource);

        int program = linkProgram(vertexShader, fragmentShader);

        return program;
    }
}
