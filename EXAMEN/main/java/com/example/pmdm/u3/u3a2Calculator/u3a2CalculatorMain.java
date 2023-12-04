package com.example.pmdm.u3.u3a2Calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public class u3a2CalculatorMain extends AppCompatActivity {

  public static final String INFO_RESULT = "u3.RESULT";
  RadioGroup radioGroup;
  EditText firstOperator;
  EditText secondOperator;
  Button btnCalculate;
  Integer result;
  View rootView;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a2_calculator_main);

    radioGroup = findViewById(R.id.u3a2rgMain);

    firstOperator = findViewById(R.id.u3a2etNumber1);
    secondOperator = findViewById(R.id.u3a2etNumber2);

    //find the root layout content of the activity
    rootView = findViewById(android.R.id.content);
    // Click listener to hide the soft keyboard
    rootView.setOnClickListener(v -> hideSoftKeyboard());

    btnCalculate = findViewById(R.id.u3a2btCalculateMain);

    btnCalculate.setOnClickListener(view -> {
      String firstOperatorStr = firstOperator.getText().toString();
      String secondOperatorStr = secondOperator.getText().toString();

      if (isNumber(firstOperatorStr, secondOperatorStr)) {
        Intent i = new Intent(this, u3a2CalculatorLaunched.class);
        i.putExtra(INFO_RESULT, result);
        startActivity(i);
      }
      ;
    });
  }

  public boolean isNumber(String num1, String num2) {
    if (num1.matches("\\d+") && num2.matches("\\d+")) {
      Integer firstOperatorInt = Integer.parseInt(firstOperator.getText().toString());
      Integer secondOperatorInt = Integer.parseInt(secondOperator.getText().toString());

      //KNOW WHICH RADIO BUTTON HAS BEEN SELECTED
      int checkedId = radioGroup.getCheckedRadioButtonId();

      if (checkedId == R.id.u3a2rbAddition) {
        result = firstOperatorInt + secondOperatorInt;
      } else if (checkedId == R.id.u3a2rbSubtraction) {
        result = firstOperatorInt - secondOperatorInt;
      } else if (checkedId == R.id.u3a2rbMultiplication) {
        result = firstOperatorInt * secondOperatorInt;
      } else if (checkedId == R.id.u3a2rbDivision) {
        if (secondOperatorInt != 0) {
          result = firstOperatorInt / secondOperatorInt;
        } else {
          showDivisionByZeroError();
          return false;
        }
      }

      return true;
    } else {
      showNotNumbersError();
      return false;
    }
  }

  private void showNotNumbersError() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("ERROR: NOT NUMBERS INTRODUCED")
            .setMessage("Please introduce numbers again")
            .setNegativeButton("NO", (dialog, which) -> dialog.dismiss());

    AlertDialog alertDialog = builder.create();
    alertDialog.show();
  }

  private void showDivisionByZeroError() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("ERROR: DIVISION BY ZERO")
            .setMessage("Cannot divide by zero. Please enter a non-zero value for the second number.")
            .setNegativeButton("NO", (dialog, which) -> dialog.dismiss());

    AlertDialog alertDialog = builder.create();
    alertDialog.show();
  }

  public void hideSoftKeyboard() {
    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    if (inputMethodManager != null) {
      View currentFocus = getCurrentFocus();
      if (currentFocus != null) {
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
      }
    }
  }
}