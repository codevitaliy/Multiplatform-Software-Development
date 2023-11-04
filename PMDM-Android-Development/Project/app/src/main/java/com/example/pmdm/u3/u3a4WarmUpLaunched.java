package com.example.pmdm.u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmdm.R;

public class u3a4WarmUpLaunched extends AppCompatActivity {

  public static final String NAME_DATA = "com.example.pmdm.u3.NAME_DATA";
  static final String CLEAN_STRING = "";
  Button btnCancel, btnClean, btnContinue;
  EditText etUserName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u3a4_warm_up_launched);

    btnCancel = findViewById(R.id.u3a4BtnCancel);
    btnClean = findViewById(R.id.u3a4BtnClean);
    btnContinue = findViewById(R.id.u3a4BtnContinue);
    etUserName = findViewById(R.id.u3a4strEtName);

    btnCancel.setOnClickListener(view -> {
      setResult(RESULT_CANCELED);
      finish();
    });

    btnClean.setOnClickListener(view -> {
      Intent data = getIntent();

      data.putExtra(NAME_DATA,CLEAN_STRING);
      setResult(RESULT_OK,data);
      finish();

    });

    btnContinue.setOnClickListener(view -> {

      Intent data = getIntent();

      data.putExtra(NAME_DATA,etUserName.getText().toString());
      setResult(RESULT_OK, data);
      finish();

    });

  }
}