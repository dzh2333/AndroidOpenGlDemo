precision mediump float;
varying vec2 vTextureCoord;
uniform sampler2D sTexture;

void main(){
    gl_FlagColor = texture2D(sTexture,vTextureCoord);
}