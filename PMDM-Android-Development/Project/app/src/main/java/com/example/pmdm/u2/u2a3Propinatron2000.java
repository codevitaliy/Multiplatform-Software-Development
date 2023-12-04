package com.example.pmdm.u2;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public class u2a3Propinatron2000 extends AppCompatActivity {

  private static final int MAX_NUMBERS = 8;
  EditText etNumberInput;
  TextView tvDisplay;
  Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, btC, btD, buttonCalculate;
  RadioGroup radioGroup;
  RadioButton btPoor, btNice, btGreat;
  double tipPercentage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u2a3_propinatron2000);

    bt1 = findViewById(R.id.u2a3btId1);
    bt2 = findViewById(R.id.u2a3btId2);
    bt3 = findViewById(R.id.u2a3btId3);
    bt4 = findViewById(R.id.u2a3btId4);
    bt5 = findViewById(R.id.u2a3btId5);
    bt6 = findViewById(R.id.u2a3btId6);
    bt7 = findViewById(R.id.u2a3btId7);
    bt8 = findViewById(R.id.u2a3btId8);
    bt9 = findViewById(R.id.u2a3btId9);
    bt0 = findViewById(R.id.u2a3btId0);
    btC = findViewById(R.id.u2a3btIdC);
    btD = findViewById(R.id.u2a3btIdD);

    //Make the soft keyboard to not pop up
    //Max number in the Edit text is in the xml layout android:maxLength="10"
    etNumberInput = findViewById(R.id.u2a3etNumberInput);
    etNumberInput.setShowSoftInputOnFocus(false);

    radioGroup = findViewById(R.id.radioGroup);

    btPoor = findViewById(R.id.u2a3rbPoor);
    btNice = findViewById(R.id.u2a3rbNice);
    btGreat = findViewById(R.id.u2a3rbGreat);
    tvDisplay = findViewById(R.id.u2a3tvTip);
    buttonCalculate = findViewById(R.id.u2a3btIdCalculate);

    // Se crea un objeto OnClickListener utilizando una expresión lambda.
    OnClickListener numberButtonHandler = (View view) -> {

      // Se obtiene el botón que fue clickeado.
      Button bt = (Button) view;

      // Se obtiene el texto actual del EditText (posiblemente un campo de entrada de números).
      String previousText = etNumberInput.getText().toString();

      // Se obtiene el texto del botón clickeado.
      String buttonText = bt.getText().toString();

      // Se concatena el texto actual con el texto del botón clickeado.
      String newText = previousText + buttonText;

      // Se establece el nuevo texto en el EditText.
      etNumberInput.setText(newText);
    };


    bt0.setOnClickListener(numberButtonHandler);
    bt1.setOnClickListener(numberButtonHandler);
    bt2.setOnClickListener(numberButtonHandler);
    bt3.setOnClickListener(numberButtonHandler);
    bt4.setOnClickListener(numberButtonHandler);
    bt5.setOnClickListener(numberButtonHandler);
    bt6.setOnClickListener(numberButtonHandler);
    bt7.setOnClickListener(numberButtonHandler);
    bt8.setOnClickListener(numberButtonHandler);
    bt9.setOnClickListener(numberButtonHandler);

    btC.setOnClickListener(v -> {
      etNumberInput.setText("");
    });

    btD.setOnClickListener(v -> {

      String originalString = etNumberInput.getText().toString();
      int stringLength = originalString.length();
      String substringString;

      if (stringLength > 0) {
        //take the last character from a string
        substringString = originalString.substring(0, stringLength - 1);
        etNumberInput.setText(substringString);
      }
    });

    //sets the percentage of the tip depending on the radio button selected
    setTipPercentage();

    //calculate the tip and show it in the display
    calculateTip();


  }

  public void setTipPercentage() {
    radioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {

      if (checkedId == R.id.u2a3rbPoor) {
        this.tipPercentage = 0.15;
        tvDisplay.setText("");
      } else if (checkedId == R.id.u2a3rbNice) {
        this.tipPercentage = 0.20;
        tvDisplay.setText("");
      } else if (checkedId == R.id.u2a3rbGreat) {
        this.tipPercentage = 0.25;
        tvDisplay.setText("");
      }
    });
  }

  public double getTipPercentage() {
    return tipPercentage;
  }

  public double getTotalAmout() {
    String totalAmount = etNumberInput.getText().toString();
    return Double.parseDouble(totalAmount);
  }

  public void calculateTip() {

    buttonCalculate.setOnClickListener(v -> {

      double totalTip = getTotalAmout() * getTipPercentage();
      String totalStr = String.valueOf(totalTip);

      tvDisplay.setText(totalStr);

    });


  }


}