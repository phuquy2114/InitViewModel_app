package com.nui.loginapplication

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.uits.initprojectviewmodel.ui.login.LoginActivity

class RegisterViewModel : ViewModel() {

    fun register(
        context: Context,
        fullName: String ?,
        email: String?,
        password: String ?,
        callback: () -> Unit
    ) {
        if (TextUtils.isEmpty(RegisterActivity.fullName)) {
            Toast.makeText(context, "Please write your full name", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(RegisterActivity.email)) {
            Toast.makeText(context, "Please write your email", Toast.LENGTH_SHORT).show()
        } else if (TextUtils.isEmpty(RegisterActivity.password)) {
            Toast.makeText(context, "Please write your password", Toast.LENGTH_SHORT).show()
        } else {
            callback();
        }

    }
}