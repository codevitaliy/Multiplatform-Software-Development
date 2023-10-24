package com.example.pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmdm.R;

public class u2a5RockPaperScissors extends AppCompatActivity {

  static final int MAX_SCORE = 3;
  ImageButton btnRockCpu,btnPaperCpu,btnScissorsCpu,btnRockPlayer,btnPaperPlayer,btnScissorsPlayer;
  Button reset;
  TextView tvCpuScore, tvPlayerScore, tvDisplay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u2a5_rock_paper_scissors);

    //All imageButtons

    btnRockCpu = findViewById(R.id.u2a5iBtnRockCpu);
    btnPaperCpu = findViewById(R.id.u2a5iBtnPaperCpu);
    btnScissorsCpu = findViewById(R.id.u2a5iBtnScissorsCpu);
    btnRockPlayer = findViewById(R.id.u2a5iBtnRockPlayer);
    btnPaperPlayer = findViewById(R.id.u2a5iBtnPaperPlayer);
    btnScissorsPlayer = findViewById(R.id.u2a5iBtnScissorsPlayer);

    //Reset button
    reset = findViewById(R.id.u2a5btnReset);

    //Text views displays
    tvCpuScore = findViewById(R.id.u2a5tvCpuScore);
    tvPlayerScore = findViewById(R.id.u2a5tvPlayerScore);
    tvDisplay = findViewById(R.id.u2a5tvDisplay);





  }

  public int playerTurn () {

    int playerChoose;

    btnRockPlayer.setOnClickListener(v -> {

      playerChoose = 1;

    });


  }

}