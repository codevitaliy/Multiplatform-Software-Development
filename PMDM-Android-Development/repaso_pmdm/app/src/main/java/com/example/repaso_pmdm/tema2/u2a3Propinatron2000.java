package com.example.repaso_pmdm.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.repaso_pmdm.R;

public class u2a3Propinatron2000 extends AppCompatActivity {

  Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnCalcularPropina, btnDel;
  RadioGroup radioGroup;
  RadioButton rBtnMal, rBtnNormal, rBtnBien;
  TextView tvOutput, tvInput;
  static final double BIEN =0.3, NORMAL = 0.1, MAL = 0.01;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u2a3_propinatron2000);

    btn0 = findViewById(R.id.u2a3btnNum0);
    btn1 = findViewById(R.id.u2a3btnNum1);
    btn2 = findViewById(R.id.u2a3btnNum2);
    btn3 = findViewById(R.id.u2a3btnNum3);
    btn4 = findViewById(R.id.u2a3btnNum4);
    btn5 = findViewById(R.id.u2a3btnNum5);
    btn6 = findViewById(R.id.u2a3btnNum6);
    btn7 = findViewById(R.id.u2a3btnNum7);
    btn8 = findViewById(R.id.u2a3btnNum8);
    btn9 = findViewById(R.id.u2a3btnNum9);
    btnCalcularPropina = findViewById(R.id.u2a3btnCalcularPropina);
    btnDel = findViewById(R.id.u2a3btnBorrar);
    radioGroup = findViewById(R.id.u2a3radioGroup);
    rBtnMal = findViewById(R.id.u2a3rbMal);
    rBtnNormal = findViewById(R.id.u2a3rbNormal);
    rBtnBien = findViewById(R.id.u2a3rbBien);
    tvOutput = findViewById(R.id.u2a3tvOutput);
    tvInput = findViewById(R.id.u2a3tvInput);


    View.OnClickListener numberButtonHandler = new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Button btn = (Button) view;

        String previousTxt = tvInput.getText().toString();

        String btnText = btn.getText().toString();

        previousTxt = previousTxt + "" +  btnText;

        tvInput.setText(previousTxt);

      }
    };

    btn0.setOnClickListener(numberButtonHandler);
    btn1.setOnClickListener(numberButtonHandler);
    btn2.setOnClickListener(numberButtonHandler);
    btn3.setOnClickListener(numberButtonHandler);
    btn4.setOnClickListener(numberButtonHandler);
    btn5.setOnClickListener(numberButtonHandler);
    btn6.setOnClickListener(numberButtonHandler);
    btn7.setOnClickListener(numberButtonHandler);
    btn8.setOnClickListener(numberButtonHandler);
    btn9.setOnClickListener(numberButtonHandler);
    btn0.setOnClickListener(numberButtonHandler);


    btnDel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String input = tvInput.getText().toString();

        if(input.length() > 0) {
          input = input.substring(0, input.length() - 1);
          tvInput.setText(input);
        }
      }
    });

    btnCalcularPropina.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        double total = Integer.parseInt(tvInput.getText().toString());
        double propina = 0;


        if(rBtnBien.isChecked()) {
          propina = total * BIEN;
        }else if(rBtnNormal.isChecked()) {
          propina = total * NORMAL;
        }else if(rBtnMal.isChecked()) {
          propina = total * MAL;
        }

        String propinaStr = String.valueOf(propina);

        tvOutput.setText(propinaStr);

      }
    });









  }
}