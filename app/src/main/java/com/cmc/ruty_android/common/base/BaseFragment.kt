package com.cmc.ruty_android.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

open class BaseFragment<T : ViewBinding>(
    private val inflater: (LayoutInflater) -> T,
    @LayoutRes private val layoutId : Int
) : Fragment(layoutId) {

    private var _binding : T?  = null
    protected  val binding
        get() = requireNotNull(_binding)

    private var toast : Toast? = null
    private var snackBar : Snackbar? = null

    override fun onCreateView( // xml 데이터 끌어오는 시점
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // _binding = inflater.inflate()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) // xml데이터 끌어오기 완료시점
    }

    open fun initView() {

    }

    protected fun showLoadingDialong () {

    }

    protected fun disableLoadingDialong () {

    }

    protected fun showToast (message : String, duration : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).apply { // frag가 view붙어서, 바로 못받아서 리키콰이어
            show() // apply 키워드 묻기
        }
    }

    protected fun showSnackBar (message : String, duration: Int = Snackbar.LENGTH_SHORT) {
        snackBar = Snackbar.make(
            binding.root,
            message,
            duration
        ).apply {
            show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    // 하나의 뷰, 프레그먼트, 액티비티에 붙는시점이 있다.
}