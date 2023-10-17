package com.example.pmdm.u2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdm.R;

public class u2a2ColorsName extends AppCompatActivity {

  int skIntRed;
  int skIntGreen;
  int skIntBlue;
  int color;
  private EditText colorEditText;
  private String textColor;
  @SuppressLint("UseSwitchCompatOrMaterialCode")
  private Switch blackWhiteSwitch;
  private SeekBar skRed;
  private SeekBar skGreen;
  private SeekBar skBlue;
  private TextView switchTextView;
  private Button colorMeButton;
  private TextView finalResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u2a2_colors_name);

    colorEditText = findViewById(R.id.u2a2etColorInput);
    blackWhiteSwitch = findViewById(R.id.u2a2swTxColor);
    skRed = findViewById(R.id.u2a2sbR);
    skGreen = findViewById(R.id.u2a2sbG);
    skBlue = findViewById(R.id.u2a2sbB);
    colorMeButton = findViewById(R.id.u2a2btShowColor);
    finalResult = findViewById(R.id.u2a2tvResult);


    skRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        colorLive();
      }
      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }
      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

    skGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        colorLive();
      }
      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }
      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });

    skBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        colorLive();
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });


    // Set initial color and text based on the switch state
    blackWhiteSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> changeSwitchText());

    setBackgroundAndText();

  }

  private void setTextColor() {
    colorMeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
    });
  }

  private void colorLive() {
    skIntRed = skRed.getProgress();
    skIntGreen = skGreen.getProgress();
    skIntBlue = skBlue.getProgress();
    color = Color.rgb(skIntRed, skIntGreen, skIntBlue);
    finalResult.setBackgroundColor(color);
  }

  private void setBackgroundAndText() {
    colorMeButton.setOnClickListener(new View.OnClickListener() {
      @RequiresApi(api = Build.VERSION_CODES.O)
      @Override
      public void onClick(View v) {
        skIntRed = skRed.getProgress();
        skIntGreen = skGreen.getProgress();
        skIntBlue = skBlue.getProgress();
        color = Color.rgb(skIntRed, skIntGreen, skIntBlue);
        finalResult.setBackgroundColor(color);
        textColor = colorEditText.getText().toString();
        finalResult.setText(textColor);
      }
    });
  }

  private void changeSwitchText() {
    String swTextOn = "White";
    String swTextOff = "Black";

    if (blackWhiteSwitch.isChecked()) {
      colorEditText.setTextColor(Color.parseColor("#FFFFFF"));
      blackWhiteSwitch.setText(swTextOn);
      finalResult.setTextColor(Color.parseColor("#FFFFFF"));
    } else {
      colorEditText.setTextColor(Color.BLACK);
      blackWhiteSwitch.setText(swTextOff);
      finalResult.setTextColor(Color.BLACK);
    }
  }

}

