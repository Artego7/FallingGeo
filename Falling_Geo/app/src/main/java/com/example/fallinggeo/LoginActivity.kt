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


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput= findViewById<TextInputEditText>(R.id.username_login)
        val emailInput= findViewById<TextInputEditText>(R.id.email_login)
        val passwordInput= findViewById<TextInputEditText>(R.id.password_login)
        val buttonInput= findViewById<Button>(R.id.button_login)
        val registerTextInput= findViewById<TextView>(R.id.text_to_regist)

        
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
                if (!validatePassword(password)){
                    passwordInput.error = "La contraseña ha de contener mayusculas, minusculas y numeros"
                }
            }
        }

        buttonInput.setOnClickListener(){
            if(validateUsername(usernameInput?.text) && validateEmail(emailInput?.text) && validatePassword(passwordInput?.text)){
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
                if (!validatePassword(passwordInput?.text)){
                    passwordInput.error = "La contraseña ha de contener mayusculas, minusculas y numeros"
                }
            }
        }
        registerTextInput.setOnClickListener(){
            startActivity(Intent(this, RegistActivity::class.java))
            finish()
        }

    //aaa("hola")



    }

    private fun validateUsername(user: Editable?): Boolean {
        return if(user.isNullOrEmpty()) false
        else "[a-zA-Z]+[a-zA-Z0-9]{3}".toRegex().matches(user)
    }

    private fun validateEmail(email: Editable?): Boolean {
        return if(email.isNullOrEmpty()) false
        else Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun validatePassword(password: Editable?): Boolean {
        return if(password.isNullOrEmpty()) false
        else "[a-zA-Z0-9]{4,23}".toRegex().matches(password)
    }
}
