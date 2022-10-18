package com.example.firstquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuixQuestion : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var myQuestionlist : ArrayList<Questions>? = null
    private var mselectedoptionPosition : Int = 0
    private var optionselect : Int = 0;
    private var mCorrectAnswer : Int = 0
    private var u_name : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quix_question)

        u_name = intent.getStringExtra(Constants.user_name)

        myQuestionlist = Constants.getQuestions()
        setQuestion()

        findViewById<TextView>(R.id.op1).setOnClickListener(this)
        findViewById<TextView>(R.id.op2).setOnClickListener(this)
        findViewById<TextView>(R.id.op3).setOnClickListener(this)
        findViewById<TextView>(R.id.op4).setOnClickListener(this)
        findViewById<Button>(R.id.btnSubmit).setOnClickListener(this)
        }

    private fun setQuestion(){

        val question = myQuestionlist!!.get(mCurrentPosition-1)
        defaultOptionsView()

        var ques = findViewById<TextView>(R.id.tv_question)
        ques.text = question.Ques
        var img = findViewById<ImageView>(R.id.iv_image)
        img.setImageResource(question.img)
        var bar = findViewById<ProgressBar>(R.id.progressBar)
        bar.progress = mCurrentPosition
        var barv = findViewById<TextView>(R.id.tv_progress)
        barv.text = "${mCurrentPosition}" + "/5"
        var op1 = findViewById<TextView>(R.id.op1)
        op1.text = question.op1
        var op2 = findViewById<TextView>(R.id.op2)
        op2.text = question.op2
        var op3 = findViewById<TextView>(R.id.op3)
        op3.text = question.op3
        var op4 = findViewById<TextView>(R.id.op4)
        op4.text = question.op4
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,findViewById(R.id.op1))
        options.add(1,findViewById(R.id.op2))
        options.add(2,findViewById(R.id.op3))
        options.add(3,findViewById(R.id.op4))

        for (option in options) {
            option.setTextColor(Color.parseColor("#FF03DAC5"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
            R.drawable.default_option_border_bg)
        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.op1 -> {
                selectedOptionView(findViewById<TextView>(R.id.op1),1)
                optionselect = 1
            }
            R.id.op2 -> {
                selectedOptionView(findViewById<TextView>(R.id.op2),2)
                optionselect = 1
            }
            R.id.op3 -> {
                selectedOptionView(findViewById<TextView>(R.id.op3),3)
                optionselect = 1
            }
            R.id.op4 -> {
                selectedOptionView(findViewById<TextView>(R.id.op4),4)
                optionselect = 1
            }
            R.id.btnSubmit -> {
                if (mselectedoptionPosition == 0 && optionselect==1){
                    mCurrentPosition++

                    when{
                       (mCurrentPosition <= myQuestionlist!!.size) ->{
                           optionselect = 0
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.user_name,u_name)
                            intent.putExtra(Constants.correct_ans,mCorrectAnswer)
                            intent.putExtra(Constants.total_Question, myQuestionlist!!.size)
                            startActivity(intent)
                        }
                    }
                }
                else if (mselectedoptionPosition == 0 && optionselect==0){
                    Toast.makeText(this,"Please select an option",Toast.LENGTH_SHORT).show()
                }
                else{
                    val question = myQuestionlist?.get(mCurrentPosition-1)
                    if (mselectedoptionPosition != question?.cop){
                        answerView(mselectedoptionPosition,R.drawable.wrong_option_border_bg)
                    }else{mCorrectAnswer++}
                    if (question != null) {
                        answerView(question.cop,R.drawable.correct_option_border_bg)
                    }

                    if (mCurrentPosition == myQuestionlist!!.size){
                        findViewById<Button>(R.id.btnSubmit).text = "FINISH"
                    }else{
                        findViewById<Button>(R.id.btnSubmit).text = "GO TO NEXT QUESTION"
                    }
                    mselectedoptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int , drawable: Int){
        when(answer){
            1 -> {
                findViewById<TextView>(R.id.op1).background =
                    ContextCompat.getDrawable(this,drawable)
            }
            2 -> {
                findViewById<TextView>(R.id.op2).background =
                    ContextCompat.getDrawable(this,drawable)
            }
            3 -> {
                findViewById<TextView>(R.id.op3).background =
                    ContextCompat.getDrawable(this,drawable)
            }
            4 -> {
                findViewById<TextView>(R.id.op4).background =
                    ContextCompat.getDrawable(this,drawable)
            }
        }
    }

    private fun selectedOptionView(tv : TextView , SelectedOption : Int)
    {
        defaultOptionsView()
        mselectedoptionPosition = SelectedOption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border_bg)
    }
}
