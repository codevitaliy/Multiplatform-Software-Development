package com.example.repaso_pmdm.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.repaso_pmdm.R;

public class u2a1AdivinarNumero extends AppCompatActivity {

    static final int NUM_MAX_TRY = 5;
    static final String WINNER = "YOU WON";
    static final String LOSER = "YOU LOST";
    static final String EMPTY_STRING = "";
    static final String OPPORTUNITIES_LEFT = "OPPORTUNITIES LEFT : ";
    Button btnPlay;
    Button btnReset;
    TextView tvDisplay;
    EditText etInput;
    int randNumber, input_number;
    int tryCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2e1_adivinar_numero);

        btnPlay = findViewById(R.id.u2a1btnPlay);
        btnReset = findViewById(R.id.u2a1btnReset);
        tvDisplay = findViewById(R.id.u2a1tvDisplay);
        etInput = findViewById(R.id.u2e1etNumberInput);


        randNumber = (int) (Math.random() * 20 + 1);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                input_number = Integer.parseInt(etInput.getText().toString());
                if (input_number == randNumber) {
                    tryCounter++;
                    tvDisplay.setText(WINNER);
                    btnPlay.setEnabled(false);
                } else if (tryCounter < NUM_MAX_TRY) {
                    tryCounter++;
                    int triesLeft = NUM_MAX_TRY - tryCounter;
                    String triesLeftString = OPPORTUNITIES_LEFT + triesLeft;
                    tvDisplay.setText(triesLeftString);
                    if (tryCounter == NUM_MAX_TRY) {
                        tvDisplay.setText(LOSER);
                        btnPlay.setEnabled(false);
                    }
                }
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setEnabled(true);
                tvDisplay.setText(EMPTY_STRING);
                tryCounter = 0;
                randNumber = (int) (Math.random() * 20 + 1);

            }
        });
    }
}