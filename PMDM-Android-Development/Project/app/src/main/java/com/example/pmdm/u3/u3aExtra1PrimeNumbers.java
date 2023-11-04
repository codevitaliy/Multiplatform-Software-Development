package com.example.pmdm.u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

public class u3aExtra1PrimeNumbers extends AppCompatActivity {

  Button btnChooseNumber;
  TextView tvResult;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u3aextra1_prime_numbers);

    btnChooseNumber = findViewById(R.id.u3aExtra1BtnChooseNumber);
    tvResult = findViewById(R.id.u3aExtra1tvResult);

    btnChooseNumber.setOnClickListener(view -> {

      Intent intent = new Intent(this, u3aExtra1PrimeNumbersLaunched.class);
      startActivity(intent);

    });

    Intent intent = getIntent();

    String result = intent.getStringExtra(u3aExtra1PrimeNumbersLaunched.CHECK_PRIME);

    tvResult.setText(result);


  }
}