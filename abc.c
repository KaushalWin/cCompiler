#include "jni.h"
#include <stdio.h>
#include "TestJNINative.h"
void main(int env, void obj) {
   
    printf("C Function Called");
    jclass cls = (*env)->GetObjectClass(env, obj);
  jmethodID mid = (*env)->GetMethodID(env, cls, "callJava", "()V");
  if (mid == 0)
    return;
  (*env)->CallVoidMethod(env, obj, mid);
}


void google(int abc, float f) {
   
    printf("C Function Called");
    jclass cls = (*env)->GetObjectClass(env, obj);
  jmethodID mid = (*env)->GetMethodID(env, cls, "callJava", "()V");
  if (mid == 0)
    return;
  (*env)->CallVoidMethod(env, obj, mid);
}