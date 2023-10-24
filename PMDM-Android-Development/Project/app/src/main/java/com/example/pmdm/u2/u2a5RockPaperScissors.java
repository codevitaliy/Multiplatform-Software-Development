package com.example.pmdm.u2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pmdm.R;

public class u2a5RockPaperScissors extends AppCompatActivity {

  static final int MAX_SCORE = 3;
  static int playerScore = 0;
  static int cpuScore = 0;
  static final int ROCK = 1;
  static final int PAPER = 2;
  static final int SCISSORS = 3;
  static int choose;
  ImageButton btnRockCpu,btnPaperCpu,btnScissorsCpu,btnRockPlayer,btnPaperPlayer,btnScissorsPlayer;
  Button reset;
  TextView tvCpuScore, tvPlayerScore, tvDisplay;
  int playerChoice;

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

    //disable cpu buttons
    btnRockCpu.setEnabled(false);
    btnPaperCpu.setEnabled(false);
    btnScissorsCpu.setEnabled(false);

    reset.setOnClickListener(view -> {
      if (playerScore <= 2 && playerScore > 0 || cpuScore <= 2 && cpuScore > 0) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set the title and message for the dialog
        builder.setTitle("RESET")
                .setMessage("SURE TO RESET?");
        // SET POSITIVE BUTTON AND ITS CLICK LISTENER
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            setReset();
          }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {

            dialog.dismiss();
          }
        });
        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
      } else {
        setReset();

      }
    });


    playerTurn();

  }

  public int cpuTurn() {
    int cpuChoice;
    cpuChoice = (int) (Math.random()*3) + 1;
    return cpuChoice;
  }

  public int playerTurn() {
    btnRockPlayer.setOnClickListener(v-> {
      playerChoice = ROCK;
      playRound();
    });

    btnPaperPlayer.setOnClickListener(v ->{
      playerChoice = PAPER;
      playRound();
    });

    btnScissorsPlayer.setOnClickListener(v->{
      playerChoice = SCISSORS;
      playRound();
    });

    return playerChoice;
  }
  public void playRound() {

      int playerChoice = playerTurn();
      int cpuChoice = cpuTurn();

      if (cpuChoice == playerChoice) {
        tvDisplay.setText(R.string.u2a5Draw);
      } else if (playerChoice == ROCK && cpuChoice == SCISSORS ||
              playerChoice == PAPER && cpuChoice == ROCK ||
              playerChoice == SCISSORS && cpuChoice == PAPER) {
        tvDisplay.setText(R.string.u2a5PlayerWinsRound);
        playerScore++;
        tvPlayerScore.setText(String.valueOf(playerScore));
      } else {
        tvDisplay.setText(R.string.u2a5CpuWinsRound);
        cpuScore++;
        tvCpuScore.setText(String.valueOf(cpuScore));
      }
      if (playerScore == MAX_SCORE) {

        tvDisplay.setText(R.string.u2a5PlayerWins);

        btnRockPlayer.setEnabled(false);
        btnPaperPlayer.setEnabled(false);
        btnScissorsPlayer.setEnabled(false);
      } else if (cpuScore == MAX_SCORE) {
        tvDisplay.setText(R.string.u2a5CpuWins);

        btnRockPlayer.setEnabled(false);
        btnPaperPlayer.setEnabled(false);
        btnScissorsPlayer.setEnabled(false);
      }
  }

  public void setReset() {

    cpuScore = 0;
    playerScore = 0;
    tvCpuScore.setText(String.valueOf(cpuScore));
    tvPlayerScore.setText(String.valueOf(playerScore));

    btnRockPlayer.setEnabled(true);
    btnPaperPlayer.setEnabled(true);
    btnScissorsPlayer.setEnabled(true);

  }

}