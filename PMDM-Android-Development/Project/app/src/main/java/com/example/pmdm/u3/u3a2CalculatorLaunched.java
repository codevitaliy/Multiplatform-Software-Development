package com.example.pmdm.u3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public class u3a2CalculatorLaunched extends AppCompatActivity {
  static final int DEFAULT_VALUE = 0;
  static final int MAX_RESULT_SIZE = 999_999_999;
  static final int NUMBER_TOO_LONG_MSG = R.string.u3a2TooLongMessage;
  TextView tvResult;
  Button btExit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a2_calculator_launched);

    tvResult = findViewById(R.id.u3a2LaunchedResult);
    btExit = findViewById(R.id.u3a2Exit);

    Intent i = getIntent();

    int result = i.getIntExtra(u3a2CalculatorMain.INFO_RESULT, DEFAULT_VALUE);

    if (result < MAX_RESULT_SIZE) {
      tvResult.setText(String.valueOf(result));
    } else {
      tvResult.setText(NUMBER_TOO_LONG_MSG);
    }

    btExit.setOnClickListener(view -> {
      finish();
    });



  }
}