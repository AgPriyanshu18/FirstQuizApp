package com.example.firstquizapp

object Constants {

    const val user_name : String = "user_name"
    const val total_Question : String = "total_questions"
    const val correct_ans : String = "Correct_ans"

    fun getQuestions() : ArrayList<Questions>{
         val allQuestions = arrayListOf<Questions>()

        //1
        val ques1 = Questions(1, "Name the character",R.drawable.ques1,"Yorichhi Tsugikuni","Muzan Kibutsuji",
        "Kyojuro Rengoku","Tanjiro Kamado",2)

        allQuestions.add(ques1)

        //2
        val ques2 = Questions(2,"Name the Cosplaying Character",R.drawable.ques2,"Kamashiro Rueze","Azusa Hamaoka",
            "Rapunzel","Azuna",3)

        allQuestions.add(ques2)

//
//        //3
//
//        val ques3 = Questions(3,"Choose your Tier",R.drawable.ques3,"A","S","B","Fucked up",2)
//        allQuestions.add(ques3)
//
//        //4
//        val ques4 = Questions(4,"What do you like about cosplay",R.drawable.ques4,"Eyes","Boobs","Pink Dress",
//        "Nothing",4)
//
//        allQuestions.add((ques4))
//
//        //5
//        val ques5 = Questions(5,"If she is your girlfriend, what will you choose",R.drawable.ques5,"**** in class",
//        "**** in oyo","After marriage","Take things slowly",2)
//
//        allQuestions.add(ques5)

        // 6
        val ques6 =  Questions(6,"Name the freedom fighter",R.drawable.download,"Mahatma Gandhi","Bhagat Singh","Bankim" +
                "Chandra Chatopadhyay","Motilala Nehru",2)
        allQuestions.add(ques6)


        return allQuestions
    }
}