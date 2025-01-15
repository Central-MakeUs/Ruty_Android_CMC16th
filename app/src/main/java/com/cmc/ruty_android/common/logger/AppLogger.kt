package com.cmc.ruty_android.common.logger

import android.util.Log
import com.cmc.ruty_android.BuildConfig

/*
* 앱 로그를 담당하는 클래스
*
* */

object AppLogger {
    // 앱의 특정 동작을 출력하기 위한 로그
    fun verbose(className: String, method : String, message : String) {
        Log.v(className, "$method() -> $message")
    }

    // 디버그 전용
    fun debug(className: String, method : String, message : String) {
        if (!BuildConfig.DEBUG) {
            return
        }
        Log.d(className, "$method() -> $message")
    }

    // 메소드 파라미터 정보
    fun info(className: String, method : String, message : String) {
        Log.i(className, "$method() -> $message")
    }

    // 앱의 잠정적 위험 동작
    fun warning(className: String, method : String, message : String) { // 값이 없으면 자동으로 널
        Log.w(className, "$method() -> $message")
    }

    // 고쳐라 빨리....
    fun error(className: String, method : String, message : String, throwable: Throwable? = null) { // 값이 없으면 자동으로 널
        Log.e(className, "$method() -> $message")
        if (!BuildConfig.DEBUG) {
            throwable?.printStackTrace() // 취약점이 될 수 있다 릴리즈에서, 코드 분석에 사용 된다.
        }
    }

}

// 싱글턴 클래스이다, new없이 사용가능 static