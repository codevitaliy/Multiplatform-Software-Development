package com.example.repaso_pmdm.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.repaso_pmdm.R;

public class u2a2ColorNames extends AppCompatActivity {

    EditText etInput;
    SeekBar skBarRed, skBarGreen, skBarBlue;
    CheckBox checkColor;
    Button btnStart;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a2_color_names);

        etInput = findViewById(R.id.u2a2etColorName);
        skBarRed = findViewById(R.id.u2a2sbR);
        skBarGreen = findViewById(R.id.u2a2sbG);
        skBarBlue = findViewById(R.id.u2a2sbB);
        checkColor = findViewById(R.id.u2a2cbTextColor);
        tvOutput = findViewById(R.id.u2a2tvOutput);
        btnStart = findViewById(R.id.u2a2btnStart);

        btnStart.setOnClickListener(v -> {

            int colorRed, colorGreen, colorBlue;

            colorRed = skBarRed.getProgress() ;
            colorGreen = skBarGreen.getProgress();
            colorBlue = skBarBlue.getProgress();
            tvOutput.setBackgroundColor(Color.rgb(colorRed, colorGreen, colorBlue));
            String inputString = etInput.getText().toString();
            if (checkColor.isChecked()) {
                tvOutput.setText(inputString);
                tvOutput.setTextColor(Color.WHITE);

            }else{
                tvOutput.setText(inputString);
            }
        });

        SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int colorRed, colorGreen, colorBlue;

                colorRed = skBarRed.getProgress() ;
                colorGreen = skBarGreen.getProgress();
                colorBlue = skBarBlue.getProgress();
                tvOutput.setBackgroundColor(Color.rgb(colorRed, colorGreen, colorBlue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        skBarRed.setOnSeekBarChangeListener(seekBarChangeListener);
        skBarGreen.setOnSeekBarChangeListener(seekBarChangeListener);
        skBarBlue.setOnSeekBarChangeListener(seekBarChangeListener);
    }
}