package com.example.pmdm.u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

public class u3a5FibonacciLaunched extends AppCompatActivity {

  public static final int DEFAULT_VALUE = 0;
  static final String SUM_DATA = "COM.EXAMPLE.PMDM.U3.SUM_DATA";
  TextView tvResult;
  Button btnContinue;
  Integer number1;
  Integer number2;
  Integer total;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a5_fibonacci_launched);

    tvResult = findViewById(R.id.u3a5strTvResult);
    btnContinue = findViewById(R.id.u3a5BtnContinue);

    Intent intent = getIntent();

    if(intent != null) {
       number1 = intent.getIntExtra(u3a5Fibonacci.NUMBER1_DATA, DEFAULT_VALUE);
       number2 = intent.getIntExtra(u3a5Fibonacci.NUMBER2_DATA, DEFAULT_VALUE);
      if(number1 != null) {
        total = number1 + number2;
        tvResult.setText(String.valueOf(total));
      }
    }

    btnContinue.setOnClickListener(view -> {

      Intent data = new Intent();

      data.putExtra(SUM_DATA, total);
      setResult(RESULT_OK, data);
      finish();

    });

  }
}