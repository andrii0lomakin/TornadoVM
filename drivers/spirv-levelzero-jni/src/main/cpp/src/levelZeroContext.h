/*
 * MIT License
 *
 * Copyright (c) 2021, APT Group, Department of Computer Science,
 * The University of Manchester.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext */

#ifndef _Included_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
#define _Included_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeContextCreate
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeContextDescriptor;[J)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeContextCreate
        (JNIEnv *, jobject, jlong, jobject, jlongArray);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeCommandQueueCreate_native
 * Signature: (JJLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeCommandQueueDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeCommandQueueHandle;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeCommandQueueCreate_1native
        (JNIEnv *, jobject, jlong, jlong, jobject, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeCommandListCreate_native
 * Signature: (JJLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeCommandListDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeCommandListHandle;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeCommandListCreate_1native
        (JNIEnv *, jobject, jlong, jlong, jobject, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeCommandListCreateImmediate_native
 * Signature: (JJLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeCommandQueueDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeCommandListHandle;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeCommandListCreateImmediate_1native
        (JNIEnv *, jobject, jlong, jlong, jobject, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeMemAllocShared_native
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeDeviceMemAllocDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeHostMemAllocDescriptor;JJJLuk/ac/manchester/tornado/drivers/spirv/levelzero/LevelZeroBufferInteger;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeMemAllocShared_1native
        (JNIEnv *, jobject, jlong, jobject, jobject, jlong, jlong, jlong, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeMemAllocShared_nativeByte
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeDeviceMemAllocDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeHostMemAllocDescriptor;JJJLuk/ac/manchester/tornado/drivers/spirv/levelzero/LevelZeroByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeMemAllocShared_1nativeByte
        (JNIEnv *, jobject, jlong, jobject, jobject, jlong, jlong, jlong, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeMemAllocDevice_native
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeDeviceMemAllocDescriptor;JJJLuk/ac/manchester/tornado/drivers/spirv/levelzero/LevelZeroByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeMemAllocDevice_1native
        (JNIEnv *, jobject, jlong, jobject, jlong, jlong, jlong, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeMemAllocDevice_nativeLong
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeDeviceMemAllocDescriptor;JJJLuk/ac/manchester/tornado/drivers/spirv/levelzero/LevelZeroBufferLong;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeMemAllocDevice_1nativeLong
        (JNIEnv *, jobject, jlong, jobject, jlong, jlong, jlong, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeModuleCreate_nativeWithPath
 * Signature: (JJLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeModuleDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeModuleHandle;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeBuildLogHandle;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeModuleCreate_1nativeWithPath
        (JNIEnv *, jobject, jlong, jlong, jobject, jobject, jobject, jstring);


/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeMemFree_native
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeMemFree_1native
        (JNIEnv *, jobject, jlong, jlong);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeCommandListDestroy_native
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeCommandListDestroy_1native
        (JNIEnv *, jobject, jlong);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeCommandQueueDestroy_native
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeCommandQueueDestroy_1native
        (JNIEnv *, jobject, jlong);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeModuleBuildLogGetString_native
 * Signature: (Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeBuildLogHandle;[I[Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeModuleBuildLogGetString_1native
        (JNIEnv *, jobject, jobject, jintArray, jobjectArray);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeEventPoolCreate_native
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeEventPoolDescriptor;IJLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeEventPoolHandle;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeEventPoolCreate_1native
        (JNIEnv *, jobject, jlong, jobject, jint, jlong, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeEventCreate_native
 * Signature: (Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeEventPoolHandle;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeEventDescriptor;Luk/ac/manchester/tornado/drivers/spirv/levelzero/ZeEventHandle;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeEventCreate_1native
        (JNIEnv *, jobject, jobject, jobject, jobject);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeEventPoolDestroy_native
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeEventPoolDestroy_1native
        (JNIEnv *, jobject, jlong);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeEventDestroy_native
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeEventDestroy_1native
        (JNIEnv *, jobject, jlong);

/*
 * Class:     uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext
 * Method:    zeMemAllocHost_native
 * Signature: (JLuk/ac/manchester/tornado/drivers/spirv/levelzero/ZeHostMemAllocDescriptor;JJLuk/ac/manchester/tornado/drivers/spirv/levelzero/LevelZeroByteBuffer;)I
 */
JNIEXPORT jint JNICALL Java_uk_ac_manchester_tornado_drivers_spirv_levelzero_LevelZeroContext_zeMemAllocHost_1native
        (JNIEnv *, jobject, jlong, jobject, jlong, jlong, jobject);
#ifdef __cplusplus
}
#endif
#endif
