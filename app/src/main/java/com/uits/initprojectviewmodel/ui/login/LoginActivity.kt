package com.uits.initprojectviewmodel.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.nui.loginapplication.RegisterActivity
import com.uits.initprojectviewmodel.HomeActivity
import com.uits.initprojectviewmodel.R

class LoginActivity : AppCompatActivity() {
    private lateinit var signUpTextView: TextView
    private lateinit var emailTextInput: TextInputEditText
    private lateinit var passwordTextInput: TextInputEditText
    private lateinit var loginButton: AppCompatButton

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailTextInput = findViewById(R.id.email_text_input)
        passwordTextInput = findViewById(R.id.password_text_input_edit_text)
        signUpTextView = findViewById(R.id.sign_up_text_view)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            loginViewModel.login(
                this,
                emailTextInput.text.toString(),
                passwordTextInput.text.toString(),callback = {
                    val user = RegisterActivity.getUser()
                    Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show()
                    val intent: Intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("full_name", user.fullName)
                    intent.putExtra("email", user.email)
                    intent.putExtra("password", user.password)
                    startActivity(intent)
                }
            )
        }

        signUpTextView.setOnClickListener {
            val intent: Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
