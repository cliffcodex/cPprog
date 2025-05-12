
#include <jni.h>

extern "C"
JNIEXPORT jdouble JNICALL
Java_com_west_calculator_Calculator_calculate(
        JNIEnv *env,
        jobject /* this */,
        jdouble a,
        jdouble b,
        jint operatorCode) {
    switch (operatorCode) {
        case 0: return a + b;
        case 1: return a - b;
        case 2: return a * b;
        case 3: return b != 0 ? a / b : 0;
        default: return 0;
    }
}
