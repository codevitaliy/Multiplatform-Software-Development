package com.example.pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm.R;

public class u2a1GuessNumber extends AppCompatActivity {

  private EditText ageEditText;
  private TextView promptMessage;
  private int inputAge;
  private static int tries;
  int randomAge;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u2a1_guess_number);

    //referencing UI elements
    ageEditText = findViewById(R.id.u2e1etEnterAge);
    Button guessButton = findViewById(R.id.u2e1btStart);
    Button restartButton = findViewById(R.id.u2a1btRestart);
    promptMessage = findViewById(R.id.u2a1tvPrompt);
    tries = 5;
    randomAge = (int) (Math.random() * 99 + 1);


    guessButton.setOnClickListener(new View.OnClickListener() {
      @SuppressLint("SetTextI18n")
      @Override
      public void onClick(View v) {

        inputAge = Integer.parseInt(ageEditText.getText().toString());

        if (inputAge == randomAge) {
          promptMessage.setText("You won!");
        } else {
          if (tries == 1) {
            promptMessage.setText("You lost and out of chances");
          } else {
            if (inputAge > randomAge) {
              tries--;
              promptMessage.setText("The age must be lower, chances left: " + tries);
            } else {
              tries--;
              promptMessage.setText("The age must be higher, chances left: " + tries);
            }
          }
        }
      }
    });

    restartButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        tries = 5;
        promptMessage.setText("Lets start again, number of tries: " + tries);
        randomAge = (int) (Math.random() * 99 + 1);
      }
    });

  }
}