package com.example.fitmeadmin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import retrofit2.Callback
import retrofit2.Response

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.fitmeadmin.APIServices.AdminAPI
import com.example.fitmeadmin.APIServices.MealService
import com.example.fitmeadmin.Entity.Admin
import com.example.fitmeadmin.R
import com.example.fitmeadmin.RetrofitService.RetrofitService
import retrofit2.Call

class SignIn : AppCompatActivity() {
    private lateinit var cvSignBtn: CardView
    private lateinit var etSignInEmail: EditText
    private lateinit var etSignInPassword:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        installSplashScreen()
        setContentView(R.layout.activity_sign_in)

        cvSignBtn = findViewById(R.id.cvSignbtn)
        etSignInEmail = findViewById(R.id.InputEmail)
        etSignInPassword = findViewById(R.id.Inputpwd)



        cvSignBtn.setOnClickListener {
            val email = etSignInEmail.text.toString()
            val password = etSignInPassword.text.toString()

            val emailValid = isValidEmail(email)
            val passwordValid = isValidPassword(password)

            if (emailValid && passwordValid) {
                // Email and password are valid; proceed with the login
                displayAlert("Admin Login", "Successful")
            } else {
                // Show error messages next to the text boxes for invalid email and password
                if (!emailValid) {
                    etSignInEmail.error = "Invalid email address"
                }
                if (!passwordValid) {
                    etSignInPassword.error = "Invalid password (minimum 6 characters required)"
                }
            }
        }

    }

    fun displayAlert(title:String, message:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
            // Do something when the "OK" button is clicked
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        val dialog = builder.create()
        dialog.show()
    }


    // Function to validate email
    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Function to validate password (you can define your own criteria here)
    private fun isValidPassword(password: String): Boolean {
        // Example: Password should be at least 6 characters long
        return password.length >= 6
    }






}