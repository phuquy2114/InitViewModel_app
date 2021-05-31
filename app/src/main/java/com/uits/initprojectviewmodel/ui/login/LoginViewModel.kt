package com.uits.initprojectviewmodel.ui.login

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.nui.loginapplication.RegisterActivity
import com.uits.initprojectviewmodel.HomeActivity

class LoginViewModel : ViewModel() {


    fun login(context: Context, email: String, password: String, callback: () -> Unit) {
        val user = RegisterActivity.getUser()
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(context, "Please write your email", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please write your password", Toast.LENGTH_SHORT).show()
        } else if (user.fullName == null ||
            user.email == null ||
            user.password == null
        ) {
            Toast.makeText(context, "Please register before login", Toast.LENGTH_SHORT).show()
        } else {
            if (email != user.email) {
                Toast.makeText(context, "Wrong email", Toast.LENGTH_SHORT).show()
            } else if (password != user.password) {
                Toast.makeText(context, "Wrong password", Toast.LENGTH_SHORT).show()
            } else {
                callback()
            }
        }
    }

}