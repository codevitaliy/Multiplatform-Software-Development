package com.example.pmdm.u3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                  String receivedData = data.getStringExtra(u3aExtra1PrimeNumbersLaunched.CHECK_PRIME);
                  if (receivedData != null) {
                    tvResult.setText(receivedData);
                  }
                }
              } else if (result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(u3aExtra1PrimeNumbers.this, R.string.CANCEL_MESSAGE, Toast.LENGTH_SHORT).show();
              }
            }
    );

    btnChooseNumber.setOnClickListener(view -> {
      Intent intent = new Intent(u3aExtra1PrimeNumbers.this, u3aExtra1PrimeNumbersLaunched.class);
      launcher.launch(intent);
    });
  }
}
