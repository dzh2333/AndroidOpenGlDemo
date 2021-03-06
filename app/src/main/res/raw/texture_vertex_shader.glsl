attribute vec3 aPosition;
attribute vec2 aTexCoord;
varying vec2 vTextureCoord;

void main(){
    gl_Position = vec4(aPosition, 1);
    vTextureCoord = aTexCoord;
}