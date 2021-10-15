package com.aserranor.quiz_landscape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables declaration
    private Button trueButton;
    private Button falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ID
        trueButton = (Button) findViewById(R.id.buttonTrue);
        falseButton = (Button) findViewById(R.id.buttonFalse);

        // Create the listeners
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the toast
                Toast.makeText(getApplicationContext(), "Has pulsed True", Toast.LENGTH_SHORT).show();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has pulsed False", Toast.LENGTH_SHORT).show();
            }
        });
    }
}