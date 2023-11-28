package com.example.fitmeadmin.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.fitmeadmin.Fragment.UsersFragment
import com.example.fitmeadmin.R

class UserDetail : AppCompatActivity() {

    private lateinit var back: ImageView
    private lateinit var editt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        back = findViewById(R.id.imgBackBtn3)
        editt = findViewById(R.id.edtbtn)

        back.setOnClickListener {

            finish()
        }
        editt.setOnClickListener {
            val intent = Intent(this, UserEdit::class.java)
            startActivity(intent)
        }


    }
}