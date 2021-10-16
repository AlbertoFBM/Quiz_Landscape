package com.aserranor.quiz_landscape;

import androidx.appcompat.app.AppCompatActivity;


public class Questions extends AppCompatActivity {

    private int sentenceId;
    private boolean answer;

    public Questions(int iSentenceId, boolean bAnswer){
        sentenceId = iSentenceId;
        answer = bAnswer;
    }

    public int getSentenceId() {

        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {

        this.sentenceId = sentenceId;
    }

    public boolean isAnswer() {

        return answer;
    }

    public void setAnswer(boolean answer) {

        this.answer = answer;
    }

}