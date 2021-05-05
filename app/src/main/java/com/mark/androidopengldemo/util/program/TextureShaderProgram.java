package com.mark.androidopengldemo.util.program;

public class TextureShaderProgram extends ShaderProgram{

    private int uMatrixLocation;
    private int uTextureUnitLocation;
    private int aPositionLocation;
    private int aTextureCoordinatesLocation;

    protected TextureShaderProgram(int vertexShaderResId, int fragmentShaderResId) {
        super(vertexShaderResId, fragmentShaderResId);

    }


}
