package com.example.pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

public class u2a5RockPaperScissors extends AppCompatActivity {

  Button btnRockCpu,btnPaperCpu,btnScissorsCpu,btnRockPlayer,btnPaperPlayer,btnScissorsPlayer;
  Button reset;

  TextView tvCpuScore, tvPlayerScore, tvDisplay;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u2a5_rock_paper_scissors);
  }




  
}