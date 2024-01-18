package com.example.pmdm.u3.u3a5fibonacci;

import static com.example.pmdm.u3.u3a5fibonacci.u3a5FibonacciLaunched.DEFAULT_VALUE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public class u3a5Fibonacci extends AppCompatActivity {

  static final String NUMBER1_DATA = "COM.EXAMPLE.PMDM.U3.NUMBER1_DATA";
  static final String NUMBER2_DATA = "COM.EXAMPLE.PMDM.U3.NUMBER2_DATA";
  TextView tvNumber1;
  TextView tvNumber2;
  Button btnNext;
  Integer number1Int,number2Int;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a5_fibonacci);

    tvNumber1 = findViewById(R.id.u3a5tvNumber1);
    tvNumber2 = findViewById(R.id.u3a5tvNumber2);
    btnNext = findViewById(R.id.u3a5btnNext);

   number1Int = Integer.parseInt(tvNumber1.getText().toString());
   number2Int = Integer.parseInt(tvNumber2.getText().toString());


    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                  Integer receivedData = data.getIntExtra(u3a5FibonacciLaunched.SUM_DATA,DEFAULT_VALUE);
                  if (receivedData != null) {
                    tvNumber1.setText(tvNumber2.getText().toString());
                    number1Int = number2Int;
                    tvNumber2.setText(String.valueOf(receivedData));
                    number2Int = receivedData;
                  }
                }
              } else if (result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(u3a5Fibonacci.this, R.string.CANCEL_MESSAGE, Toast.LENGTH_SHORT).show();
              }
            }
    );

    btnNext.setOnClickListener(view -> {

      Intent intent = new Intent(u3a5Fibonacci.this, u3a5FibonacciLaunched.class);

      intent.putExtra(NUMBER1_DATA, number1Int);
      intent.putExtra(NUMBER2_DATA, number2Int);

      launcher.launch(intent);

    });


  }
}

btnFechaIda.setOnClickListener(v ->{
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                            onDateSetListener,
                            year,
                            month,
                            day
            );

            datePickerDialog.show();
        });

        onDateSetListener = (view, year, monthOfYear, dayOfMonth) -> {
            // This is the callback method when the date is set
            // You can handle the selected date here
            selectDataIda = LocalDate.of(year, monthOfYear, dayOfMonth);
            // Do something with the selected date, like updating a TextView
            fechaIda = establecerIda();
            Toast.makeText(this, "HPÑA", Toast.LENGTH_SHORT).show();
        };