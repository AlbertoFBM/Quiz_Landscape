package com.aserranor.quiz_landscape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables declaration
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView textViewQuestion;
    private Button previousButton;
    private ImageButton nextI;
    private ImageButton prevI;

    private Questions[] questionsBank = new Questions[] {

            new Questions(R.string.question_London, false),
            new Questions(R.string.question_Berlin, true),
            new Questions(R.string.question_Athens, false),
            new Questions(R.string.question_Bucharest, true),
            new Questions(R.string.question_Copenhagen, true),
            new Questions(R.string.question_Oslo, false),
            new Questions(R.string.question_Stockholm, false),
            new Questions(R.string.question_Monaco, false),
            new Questions(R.string.question_Dublin, true),
            new Questions(R.string.question_Madrid, false)
    };

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ID
        trueButton = (Button) findViewById(R.id.buttonTrue);
        falseButton = (Button) findViewById(R.id.buttonFalse);
        nextButton = (Button) findViewById(R.id.buttonNext);
        textViewQuestion= (TextView) findViewById(R.id.questionId);

        // Create the listeners
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the toast
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex +1) % questionsBank.length;
                updateQuestion();
            }
        });

        // Challenge:  Add a Listener to the TextView

        textViewQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex +1) % questionsBank.length;
                updateQuestion();
            }
        });

        // Challenge: Add a Previous Button

        previousButton = (Button) findViewById(R.id.buttonPrevious);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex -1) % questionsBank.length;
                updateQuestion();
            }
        });

        // Challenge: From Button to ImageButton --> (add ImageButton)

        nextI = (ImageButton) findViewById(R.id.nextImage);
        nextI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex +1) % questionsBank.length;
                updateQuestion();
            }
        });

        prevI = (ImageButton) findViewById(R.id.prevImage);
        prevI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex -1) % questionsBank.length;
                updateQuestion();
            }
        });
    }


    private void updateQuestion(){

        int question = questionsBank[currentIndex].getSentenceId();
        textViewQuestion.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){

        boolean answerIsTrue = questionsBank[currentIndex].isAnswer();
        int messageResId = 0;

        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(getApplicationContext(),
                messageResId,
                Toast.LENGTH_SHORT).show();
    }


}