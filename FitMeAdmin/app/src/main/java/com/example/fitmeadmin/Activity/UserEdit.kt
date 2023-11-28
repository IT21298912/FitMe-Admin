package com.example.fitmeadmin.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.fitmeadmin.R

class UserEdit : AppCompatActivity() {

    private lateinit var back: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_edit)

        back = findViewById(R.id.imbBackBtn2)


        back.setOnClickListener {

            finish()
        }
    }
}