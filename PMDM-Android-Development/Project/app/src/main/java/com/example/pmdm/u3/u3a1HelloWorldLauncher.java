package com.example.pmdm.u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.pmdm.R;

public class u3a1HelloWorldLauncher extends AppCompatActivity {
  
  Button btnHelloWorld;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a1_hello_world_launcher);

    btnHelloWorld = findViewById(R.id.u3a1btHelloWorld);

    btnHelloWorld.setOnClickListener(view -> {

      Intent i = new Intent(this, u3a1HelloWorldLaunched.class);
      startActivity(i);

    });





  }
}