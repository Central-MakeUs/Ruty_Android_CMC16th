package com.cmc.ruty_android.common.base

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.cmc.ruty_android.R

open class BaseActivity<T : ViewBinding>(
    private val inflater: (LayoutInflater) -> T // 생성자, 함수포인터 개념, 변수가 함수를 가르키는
) : AppCompatActivity() { // 상속해줄 수 있다.
    private var _binding: T? = null
    val binding
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflater(layoutInflater) // xml을 긁어와서 inflater가 변환해서 코드화 시켜준다. 간편화
        setContentView(binding.root) // constrain 전부를 가져오는게 root

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            setEdgePadding() // sdk 35부터는, 엣지가 다 사라지고, 전체화면 기능 기준! 바닐라 이상이면 패딩 준다.
            // 34부터는 기본 패딩, 35부는 기본 패딩이 없기에 패딩 준다.
        }
        initView() // 뷰초기화 까지 !
    }

    private fun setEdgePadding() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    open fun initView() { // 상속 받게

    }

    override fun onDestroy() { // 액티비티 소멸자,
        super.onDestroy()
        _binding = null; // 메모리 누수 방지
    }
}

/*
뷰바인딩, 받아오는 것을 최소화하는
*/