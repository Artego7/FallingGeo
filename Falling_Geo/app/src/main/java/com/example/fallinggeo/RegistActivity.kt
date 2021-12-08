package com.example.fallinggeo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.fallinggeo.ui.GameMenusActivity
import com.google.android.material.textfield.TextInputEditText

class RegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        val usernameInput= findViewById<TextInputEditText>(R.id.username_regist)
        val emailInput= findViewById<TextInputEditText>(R.id.email_regist)
        val passwordInput= findViewById<TextInputEditText>(R.id.password_regist)
        val passwordConfirmInput= findViewById<TextInputEditText>(R.id.password_confirm_regist)
        val buttonInput= findViewById<Button>(R.id.button_regist)
        val registerTextInput= findViewById<TextView>(R.id.text_to_login)


        usernameInput.setOnFocusChangeListener { view, hasFocus ->
            if(!hasFocus){
                val username = usernameInput.text
                if (!validateUsername(username)){
                    usernameInput.error = "User Incorrecto"
                }
            }
        }
        emailInput.setOnFocusChangeListener { view, hasFocus ->
            if(!hasFocus){
                val email = emailInput.text
                if (!validateEmail(email)){
                    emailInput.error = "Email incorrecto"
                }
            }
        }

        passwordInput.setOnFocusChangeListener { view, hasFocus ->
            if(!hasFocus){
                val password = passwordInput.text
                if (!validatePassword(password.toString())){
                    passwordInput.error = "La contraseña ha de contener mayusculas, minusculas y numeros"
                }
            }
        }
        passwordConfirmInput.setOnFocusChangeListener { view, hasFocus ->
            if(!hasFocus){
                val passwordConfirm = passwordConfirmInput.text.toString()
                val password = passwordInput.text.toString()
                if (passwordConfirm != password){
                    passwordConfirmInput.error = "La contraseña no coincide"
                }else if (!validatePassword(passwordConfirm)){
                    passwordConfirmInput.error = "La contraseña ha de contener mayusculas, minusculas y numeros"
                }
            }
        }

        buttonInput.setOnClickListener(){
            if(validateUsername(usernameInput?.text) && validateEmail(emailInput?.text)
                && validatePassword(passwordInput?.text.toString()) && validatePassword(passwordConfirmInput?.text.toString())){
                startActivity(Intent(this, GameMenusActivity::class.java))
                finish()
            }else {
                Toast.makeText(this, "Algunos de los campos no són correctos", Toast.LENGTH_SHORT).show()
                if (!validateUsername(usernameInput?.text)){
                    usernameInput.error = "User Incorrecto"
                }
                if (!validateEmail(emailInput?.text)){
                    emailInput.error = "Email incorrecto"
                }
                if (!validatePassword(passwordInput?.text.toString())){
                    passwordInput.error = "La contraseña ha de contener mayusculas, minusculas y numeros"
                }
                if (!validatePassword(passwordConfirmInput?.text.toString())){
                    passwordConfirmInput.error = "La contraseña ha de contener mayusculas, minusculas y numeros"
                }
            }
        }
        registerTextInput.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
    private fun validateUsername(user: Editable?): Boolean {
        return if(user.isNullOrEmpty()) false
        else "[a-zA-Z]+[a-zA-Z0-9]{3}".toRegex().matches(user)
    }

    private fun validateEmail(email: Editable?): Boolean {
        return if(email.isNullOrEmpty()) false
        else Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: String): Boolean {
        return if(password.isNullOrEmpty()) false
        else "[a-zA-Z0-9]{4,23}".toRegex().matches(password)
    }
}