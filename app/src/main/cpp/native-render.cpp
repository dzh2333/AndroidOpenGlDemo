#include <jni.h>
#include <string>


#include <EGL/egl.h>
#include <GLES3/gl3.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_mark_androidopengldemo_render_TriangleRender_onDrawFrame(JNIEnv *env, jobject const) {
    glClear(GL_COLOR_BUFFER_BIT);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_mark_androidopengldemo_render_TriangleRender_surfaceChanged(JNIEnv *env, jobject thiz,
                                                                     jint width, jint height) {
    glViewport(0, 0, width, height);
}extern "C"
JNIEXPORT void JNICALL
Java_com_mark_androidopengldemo_render_TriangleRender_surfaceCreated(JNIEnv *env, jobject thiz,
                                                                     jint color) {
    //分离RGBA的百分比
    GLfloat redF = ((color >> 16) & 0xFF) * 1.0f / 255;
    GLfloat greenF = ((color >> 8) & 0xFF) * 1.0f / 255;
    GLfloat blueF = (color & 0xFF) * 1.0f / 255;
    GLfloat alphaF = ((color >> 24) & 0xFF) * 1.0f / 255;
    glClearColor(redF, greenF, blueF, alphaF);
}