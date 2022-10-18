package com.example.firstquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra(Constants.user_name)
        findViewById<TextView>(R.id.tv_uname).text = userName
        val totQuestions = intent.getIntExtra(Constants.total_Question,0)
        val correctanswer = intent.getIntExtra(Constants.correct_ans,0)

        findViewById<TextView>(R.id.tv_score).text =
            "Your score is $correctanswer out of $totQuestions"

        findViewById<Button>(R.id.button_submit).setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}