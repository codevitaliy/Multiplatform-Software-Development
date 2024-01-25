package com.example.repaso_pmdm.tema2;

import androidx.appcompat.app.AppCompatActivity;

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
    CheckBox cbColor;
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
        cbColor = findViewById(R.id.u2a2cbTextColor);
        tvOutput = findViewById(R.id.u2a2tvOutput);




        btnStart.setOnClickListener(v -> {
            String inputString = etInput.getText().toString();

            skBarRed.getProgress();
            skBarGreen.getProgress();
            skBarBlue.getProgress();





        });






    }
}