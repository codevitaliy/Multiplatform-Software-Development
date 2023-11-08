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
    setContentView(R.layout.u3aextra1_prime_numbers_launched);

    btnCheckPrime = findViewById(R.id.u3aExtra1btnCheckPrime);
    btnExit = findViewById(R.id.u3aExtra1btnExit);
    etNumberInput = findViewById(R.id.u3aExtra1etNumber);

    btnExit.setOnClickListener(view -> {
      setResult(RESULT_CANCELED);
      finish();
    });

    btnCheckPrime.setOnClickListener(view -> {
      int etNumberInt = Integer.parseInt(etNumberInput.getText().toString());

      Intent data = new Intent();

      String isPrime = "";

      if (checkPrimerNumber(etNumberInt)) {
        isPrime = "The number: " + etNumberInt + " is prime";
      } else {
        isPrime = "The number: " + etNumberInt + " is not prime";
      }

      data.putExtra(CHECK_PRIME, isPrime);
      setResult(RESULT_OK, data);
       /*method is used to set the result that will be sent back to the calling activity when the current
      activity finishes. This method is typically called when an action in the current activity is completed,
      and you want to send some data back to the activity that started it.*/
      finish();
    });
  }

  public boolean checkPrimerNumber(int number) {
    int counter = 0;

    for (int i = 1; i <= number; i++) {
      if ((number % i) == 0) {
        counter++;
      }
    }

    return counter == 2;
  }
}
