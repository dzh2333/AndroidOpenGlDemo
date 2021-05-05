package com.mark.androidopengldemo.util.program;

import com.mark.androidopengldemo.MainApplication;
import com.mark.androidopengldemo.util.ShaderHelper;
import com.mark.androidopengldemo.util.TextResReader;

/**
 * 辅助类
 */
public class ShaderProgram {

    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";

    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    protected  int program;
    protected ShaderProgram(int vertexShaderResId, int fragmentShaderResId){
        program = ShaderHelper.buildProgram(
                TextResReader.readTextFileFromResource(MainApplication.getApplication(),
                        vertexShaderResId),
                TextResReader.readTextFileFromResource(MainApplication.getApplication(),
                        fragmentShaderResId));
    }

    public void useProgram(){

    }
}
