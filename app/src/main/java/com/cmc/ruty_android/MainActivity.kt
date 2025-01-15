package com.cmc.ruty_android

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cmc.ruty_android.common.base.BaseActivity
import com.cmc.ruty_android.common.logger.AppLogger
import com.cmc.ruty_android.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {
    override fun initView() {
        super.initView()
        Toast.makeText(this, "1차완성", Toast.LENGTH_SHORT).show() // 모든 안드로이드 구성요소는 컨텍스트로 이뤄짐
        // 액티비티, 서비스, 프래그먼트, 애플리케이션 클래스, 다 컨텍스트가 있다. 4대요소
        // activity에서 가져온 context, 애플리케이션 정보 -> 애플리케이션 컨텍스트, 여긴 액티비티 컨텍스트,
        // 컨텍스트 다르게 넣으면 런타임시 오류가 난다.
        // 어떤 성격 성격으로 가져올지 미리 확인
        // AppLogger.debug(CLASSNAME, "onCreate", "start") // 로그 클래스 사용
    }
}

/*
*
*
*
*     private fun test(num1 : Int, num2 : Int) {
        AppLogger.debug(CLASSNAME, "onCreate", "start") // 로그 클래스 사용
        AppLogger.info(CLASSNAME, "onCreate", "start") // 로그 클래스 사용

        try {

        } catch (e : Exception) {

        }
        AppLogger.debug(CLASSNAME, "onCreate", "start") // 로그 클래스 사용
    }

    companion object {
        private const val CLASSNAME = "MainActivity"
    }
* */