package com.example.ruty_android_cmc_16th

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ruty_android_cmc_16th.databinding.ActivityLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    // 구글 로그인 결과를 받을 때 식별하기 위한 request code
    private val RC_SIGN_IN = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 구글 로그인 옵션 설정 (이메일 요청)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        // 구글 로그인 클라이언트 생성
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // 혹시 이미 구글에 로그인되어 있다면 다음 화면으로 이동
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account != null) {
            moveToNextScreen(account)
        }

        // 구글 로그인 버튼 클릭
        binding.btnGoogleLogin.setOnClickListener {
            signInWithGoogle()
        }

        // 애플 로그인 버튼 클릭 (별도 구현 필요)
        binding.btnAppleLogin.setOnClickListener {
            // TODO: Apple 로그인 로직
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
                if (account != null) {
                    // 로그인 성공 시
                    moveToNextScreen(account)
                }
            } catch (e: ApiException) {
                // 예외 처리
                Log.e("LoginActivity", "Google sign in failed", e)
            }
        }
    }

    // 로그인 성공 시 처리
    private fun moveToNextScreen(account: GoogleSignInAccount) {
        val displayName = account.displayName
        val email = account.email
        Log.d("LoginActivity", "로그인 성공! displayName: $displayName, email: $email")

        // TODO: 회원가입 로직 or 다음 화면으로 이동
        // startActivity(Intent(this, MainActivity::class.java))
        // finish()
    }
}
