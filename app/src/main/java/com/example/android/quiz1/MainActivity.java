package com.example.android.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Scores the quiz
     *
     * @param view
     */
    public void scoreTest (View view){
        //Resets score to 0
        score = 0;


        // Checks all answers
        checkQuestionOne(view);
        checkQuestionTwo(view);
        checkQuestionThree(view);
        checkQuestionFour(view);

        // Creates message string
        String message = score + " " + getResources().getString(R.string.resultsMessage);

        // Toasts message
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, message, LENGTH_LONG);
        toast.show();

    }

    /** Checks the answer to question 1
     *
     * @param view
     */
    private void checkQuestionOne (View view){
        int score1 = 0;
        boolean checked = false;
        RadioGroup answerID = findViewById(R.id.radioGroup1);

        // Gets the radio button IDs for the correct answer and the selected answer
        RadioButton correctAnswer = answerID.findViewById(R.id.radioButtonQ1A2);
        checked = correctAnswer.isChecked();

        //Compares the selected answer against the correct answer
        if (checked){
            score += 1;
        }

    }

    /** Checks the answers to question 2
     *
     * @param view
     */
    public void checkQuestionTwo (View view){
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        CheckBox checkBox2 = findViewById(R.id.checkBox2);
        CheckBox checkBox3 = findViewById(R.id.checkBox3);

        if (checkBox1.isChecked() && checkBox2.isChecked() && !checkBox3.isChecked()){
            score += 1;
        }

    }


    /** checks the input answer from question 3
     *
     * @param view
     */
    private void checkQuestionThree (View view){
        EditText answer = findViewById(R.id.questionThreeInput);


        // Gets input answer
        String checkAnswer = answer.getText().toString();


        // Compares input answer to correct answer
        if (checkAnswer.equals("$100")){
            score += 1;
        } else if (checkAnswer.equals("100")){
            score += 1;
        }


    }

    /** Checks the answer to question 4
     *
     * @param view
     */
    private void checkQuestionFour (View view){
        RadioGroup answerID = findViewById(R.id.radioGroup2);

        // Gets the radio button IDs for the correct answer and the selected answer
        RadioButton correctAnswer = answerID.findViewById(R.id.radioButtonQ4A3);
        RadioButton checkedButton = answerID.findViewById(answerID.getCheckedRadioButtonId());

        //Compares the selected answer against the correct answer
        if (checkedButton == correctAnswer){
            score += 1;
        }

    }



}
