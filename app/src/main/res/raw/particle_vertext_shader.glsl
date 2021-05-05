uniform mat4 u_Matirx;
uniform float u_Time;


attribute vec3 a_Position;
attribute vec3 a_Color;
attribute vec3 a_DirectionVector;
attribute float a_PorticleStartTime;

varying vec3 v_Color;
varying float v_ElapsedTime;

void main(){
    v_Color = a_Color;
    v_ElapsedTime = u_Time - a_PorticleStartTime;
    vec3 currentPosition = a_Position + (a_DirectionVector * v_ElapsedTime);
    gl_Position = u_Matirx * vec4(currentPosition, 1.0);
    gl_PointSize = 10.0;
}