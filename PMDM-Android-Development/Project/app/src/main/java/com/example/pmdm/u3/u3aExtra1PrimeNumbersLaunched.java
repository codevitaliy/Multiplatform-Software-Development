package com.example.pmdm.u3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public class u3aExtra1PrimeNumbersLaunched extends AppCompatActivity {

  static final String CHECK_PRIME = "com.example.pmdm.u3.CHECK_PRIME";
  Button btnCheckPrime;
  Button btnExit;
  EditText etNumberInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u3aextra1_prime_numbers_launched);

    btnCheckPrime = findViewById(R.id.u3aExtra1btnCheckPrime);
    btnExit = findViewById(R.id.u3aExtra1btnExit);
    etNumberInput = findViewById(R.id.u3aExtra1etNumber);

    btnExit.setOnClickListener(view -> {
      finish();
    });

    btnCheckPrime.setOnClickListener(view -> {

      int etNumberInt = Integer.parseInt(etNumberInput.getText().toString());

      Intent intent = new Intent(this, u3aExtra1PrimeNumbers.class);

      String isPrime = "";

      if(checkPrimerNumber(etNumberInt)) {

        isPrime = "The number: " + etNumberInt + " is prime";

        intent.putExtra(CHECK_PRIME,isPrime);

      }else {
        isPrime = "The number: " + etNumberInt + " is not prime";

        intent.putExtra(CHECK_PRIME,isPrime);
      }

      startActivity(intent);

    });
  }

  public boolean checkPrimerNumber(int number) {
    int counter = 0;

    for (int i = 1; i <= number; i++) {

      if ((number % i) == 0) {
        counter++;
      }
    }

    if (counter == 2) {
      return true;
    }
    return false;
  }


}