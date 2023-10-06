package com.example.pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
        String strTries;

        if (inputAge == randomAge) {
          promptMessage.setText(R.string.u2a1youWin);
          promptMessage.setTextColor(Color.parseColor("#008000"));
        } else {
          if (tries == 1) {
            promptMessage.setText(R.string.u2a1youLost);
            promptMessage.setTextColor(Color.parseColor("#FF0000"));
          } else {
            if (inputAge > randomAge) {
              tries--;
              promptMessage.setText(getString(R.string.u2a1lowerAge) + " " + tries);
            } else {
              tries--;
              promptMessage.setText(getString(R.string.u2a1higherAge) + " " + tries);
            }
          }
        }
      }
    });

    restartButton.setOnClickListener(new View.OnClickListener() {
      @SuppressLint("SetTextI18n")
      @Override
      public void onClick(View v) {
        tries = 5;
        promptMessage.setText(getString(R.string.u2a1startAgain) + " " + tries);
        randomAge = (int) (Math.random() * 99 + 1);
        promptMessage.setTextColor(Color.parseColor("#000000"));
      }
    });

  }
}