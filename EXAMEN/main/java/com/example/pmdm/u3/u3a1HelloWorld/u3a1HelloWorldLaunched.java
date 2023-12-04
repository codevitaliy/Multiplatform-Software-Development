package com.example.pmdm.u3.u3a1HelloWorld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.pmdm.R;

public class u3a1HelloWorldLaunched extends AppCompatActivity {

  Button btnCloseActivity;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a1_hello_world_launched);

    btnCloseActivity = findViewById(R.id.u3a1LaunchedBtnClose);

    btnCloseActivity.setOnClickListener(view -> {

      finish();

    });


  }
}