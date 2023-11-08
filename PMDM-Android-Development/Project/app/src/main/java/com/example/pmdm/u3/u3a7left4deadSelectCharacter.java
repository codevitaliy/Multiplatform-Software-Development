package com.example.pmdm.u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3a7left4deadSelectCharacter extends AppCompatActivity {

  static final String CHARACTER_PLAYER_ONE = "com.example.pmdm.u3.CHARACTER_PLAYER_ONE";
  ImageButton btnCharacter1;
  ImageButton btnCharacter2;
  ImageButton btnCharacter3;
  ImageButton btnCharacter4;
  ImageButton btnGoBack;
  ImageButton btnClear;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Make the activity full-screen
    fullScreen();

    btnCharacter1 = findViewById(R.id.u3a7btnCharacter1);
    btnCharacter2 = findViewById(R.id.u3a7btnCharacter2);
    btnCharacter3 = findViewById(R.id.u3a7btnCharacter3);
    btnCharacter4 = findViewById(R.id.u3a7btnCharacter4);
    btnGoBack = findViewById(R.id.u3a7btnGoBackCharacter);
    btnClear = findViewById(R.id.u3a7btnClearCharacter);
    Intent data = new Intent();

    btnCharacter1.setOnClickListener(view -> {
    backgroundColor(btnCharacter1);
    turnOffBackground(btnCharacter2,btnCharacter3,btnCharacter4);
    int choice = 1;

    });

    btnCharacter2.setOnClickListener(view -> {
      backgroundColor(btnCharacter2);
      turnOffBackground(btnCharacter1,btnCharacter3,btnCharacter4);
      int choice = 2;
      data.putExtra(CHARACTER_PLAYER_ONE,choice);
      setResult(RESULT_OK, data);
      finish();

    });

    btnCharacter3.setOnClickListener(view -> {
      backgroundColor(btnCharacter3);
      turnOffBackground(btnCharacter1,btnCharacter2,btnCharacter4);
      int choice = 3;
    });

    btnCharacter4.setOnClickListener(view -> {
      backgroundColor(btnCharacter4);
      turnOffBackground(btnCharacter1,btnCharacter2,btnCharacter3);
      int choice = 4;
    });


  }

  public void fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.u3a7left4dead_select_character);
  }

  public void backgroundColor(ImageButton button) {
    button.setBackgroundColor(0x6F000000);
  }

  public void turnOffBackground(ImageButton button, ImageButton button1, ImageButton button2) {
    button.setBackgroundColor(0xFF5A1E1E);
    button1.setBackgroundColor(0xFF5A1E1E);
    button2.setBackgroundColor(0xFF5A1E1E);
  }



}