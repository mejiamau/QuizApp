package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int radioButtonScore = 0;
    int checkBoxScore = 0;
    int totalScore = 0;


    public void submitAnswers(View view) {
        // get user name
        EditText nameInput = (EditText) findViewById(R.id.user_name);
        String userName = nameInput.getText().toString();

        // get answers from Question 1,
        CheckBox q1_Checkbox1 = (CheckBox) findViewById(R.id.q1_option1);
        boolean CheckBox1Selected = q1_Checkbox1.isChecked();

        CheckBox q1_Checkbox2 = (CheckBox) findViewById(R.id.q1_option2);   //Correct answer
        boolean CheckBox2Selected = q1_Checkbox2.isChecked();

        CheckBox q1_Checkbox3 = (CheckBox) findViewById(R.id.q1_option3);   //Correct answer
        boolean CheckBox3Selected = q1_Checkbox3.isChecked();


        // get answer from Question 2
        RadioButton question_2Button = findViewById(R.id.q2_true);
        boolean RadioButton2a = question_2Button.isChecked();


        // get answer from Question 3
        RadioButton question_3Button = findViewById(R.id.q3_true);
        boolean RadioButton3a = question_3Button.isChecked();


        // get answer from Question 4
        RadioButton question_4Button = findViewById(R.id.q4_true);
        boolean RadioButton4a = question_4Button.isChecked();


        // get answer from Question 5
        RadioButton question_5Button = findViewById(R.id.q5_true);
        boolean RadioButton5a = question_5Button.isChecked();


        // get answer from Question 6
        RadioButton question_6Button = findViewById(R.id.q6_true);
        boolean RadioButton6a = question_6Button.isChecked();



        double totalScore = checkBoxScore + radioButtonScore;



        // toast
        if (totalScore == 7) {
            Toast.makeText(this, userName + ", you scored " + totalScore + " out of 7" + "\n Perfect Score \n Congratulations!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, userName + ", you scored " + totalScore + " out of 7" + "\n Press RESET to try again!", Toast.LENGTH_LONG).show();
        }
    }


    /**
     * this method adds the points for question 1
     *
     * @param q1_option1 boolean, did the user check this box -1 point
     * @param q1_option2 boolean, did the user check this box +1 point
     * @param q1_option3 boolean, did the user check this box +1 point
     * @return integer of sum of total score
     */
    private int CheckBoxPoints(boolean q1_option1, boolean q1_option2, boolean q1_option3) {
        if (q1_option1 == true) {
            checkBoxScore = checkBoxScore - 1;
        }
        if (q1_option2 == true) {
            checkBoxScore = checkBoxScore + 1;
        }
        if (q1_option3 == true) {
            checkBoxScore = checkBoxScore + 1;
        }

        return checkBoxScore;
    }


    /**
     * this method adds points for questions 2 to 6
     *
     * @param RadioButton2a/RadioButton3a/... boolean, did the user check the correct answer
     * @return totalScore
     */
    private int RadioButtonPoints(boolean RadioButton2a, boolean RadioButton3a, boolean RadioButton4a,
                                  boolean RadioButton5a, boolean RadioButton6a) {


        if (RadioButton2a) {
            radioButtonScore = radioButtonScore + 1;
        }
        if (RadioButton3a) {
            radioButtonScore = radioButtonScore + 1;
        }
        if (RadioButton4a) {
            radioButtonScore = radioButtonScore + 1;
        }
        if (RadioButton5a) {
            radioButtonScore = radioButtonScore + 1;
        }
        if (RadioButton6a) {
            radioButtonScore = radioButtonScore + 1;
        }

        return radioButtonScore;

    }


    // when RESET button is clicked, set the totalScore to 0
    public void resetButton(View view) {
        totalScore = 0;
        setContentView(R.layout.activity_main);
    }

}



