package com.nui.loginapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText
import com.uits.initprojectviewmodel.R
import com.uits.initprojectviewmodel.model.User
import com.uits.initprojectviewmodel.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var signInTextView: TextView
    private lateinit var fullNameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: AppCompatButton
//    private lateinit var email:String
//    private lateinit var password:String
//    private lateinit var fullName:String

    companion object {
        var fullName: String? = null
        var email: String? = null
        var password: String? = null

        fun getUser(): User = User(fullName, email, password)
    }

    private val registerViewModel: RegisterViewModel by lazy {
        ViewModelProviders.of(this).get(RegisterViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullNameEditText = findViewById(R.id.full_name_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        signInTextView = findViewById(R.id.sign_in_text_view)
        loginButton = findViewById(R.id.login_button)

        loginButton.setOnClickListener {
            registerViewModel.register(
                this,
                fullName,
                email,
                password,
                callback = {
                    val intent: Intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                })
        }
        signInTextView.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


}