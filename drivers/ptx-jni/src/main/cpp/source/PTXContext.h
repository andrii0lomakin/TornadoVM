/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include <cuda.h>
/* Header for class uk_ac_manchester_tornado_drivers_ptx_PTXContext */

#ifndef _Included_uk_ac_manchester_tornado_drivers_ptx_PTXContext
#define _Included_uk_ac_manchester_tornado_drivers_ptx_PTXContext
#ifdef __cplusplus
extern "C" {
#endif

extern CUcontext **g_contexts;
extern int g_contexts_length;

/*
 * Class:     uk_ac_manchester_tornado_drivers_ptx_PTXContext
 * Method:    cuCtxCreate
 * Signature: (I)I
 */
JNIEXPORT void JNICALL Java_uk_ac_manchester_tornado_drivers_ptx_PTXContext_cuCtxCreate
  (JNIEnv *, jclass, jint);

/*
 * Class:     uk_ac_manchester_tornado_drivers_ptx_PTXContext
 * Method:    cuCtxDestroy
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_uk_ac_manchester_tornado_drivers_ptx_PTXContext_cuCtxDestroy
  (JNIEnv *, jclass, jint);


/*
 * Class:     uk_ac_manchester_tornado_drivers_ptx_PTXContext
 * Method:    cuMemAlloc
 * Signature: (IJ)J
 */
JNIEXPORT jlong JNICALL Java_uk_ac_manchester_tornado_drivers_ptx_PTXContext_cuMemAlloc
  (JNIEnv *, jclass, jint, jlong);

#ifdef __cplusplus
}
#endif
#endif
