package com.example.firstquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        var btn_start = findViewById<Button>(R.id.btn_Start)
        btn_start.setOnClickListener{
            if (findViewById<TextView>(R.id.Name_Space).text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuixQuestion::class.java)
                intent.putExtra(Constants.user_name,
                    findViewById<AppCompatEditText>(R.id.Name_Space).text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}