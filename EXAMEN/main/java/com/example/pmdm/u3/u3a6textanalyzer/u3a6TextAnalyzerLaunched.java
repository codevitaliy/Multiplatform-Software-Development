package com.example.pmdm.u3.u3a6textanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class u3a6TextAnalyzerLaunched extends AppCompatActivity {
  static final String ANALYZED_DATA = "com.example.pmdm.u3.ANALYZED_DATA";

  static final String REGEX_LETTERS = "[A-Z]$";
  TextView tvOutput;
  Button btnFinish;
  String receivedData;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a6_text_analyzer_launched);

    tvOutput = findViewById(R.id.u3a6tvTextOutput);
    btnFinish = findViewById(R.id.u3a6btnFinish);

    Intent intent = getIntent();

    if(intent != null) {
      receivedData = intent.getStringExtra(u3a6TextAnalyzer.ANALYZING_DATA);
      //Toast.makeText(u3a6TextAnalyzerLaunched.this,receivedData, Toast.LENGTH_SHORT).show();
    }
    try{
    receivedData = receivedData.toUpperCase();
    }catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }

    Map <String, Integer> countLettersHashMap = new LinkedHashMap<>();

    for (int i = 0; i < receivedData.length(); i++) {

      String letter = receivedData.substring(i,i+1);
      if(letter.matches(REGEX_LETTERS)) {
        countLettersHashMap.put(letter, countLettersHashMap.getOrDefault(letter, 0) + 1);
      }
    }

    StringBuilder outputBuilder = new StringBuilder();

    for(Map.Entry<String, Integer> entry : countLettersHashMap.entrySet()) {
      String key = entry.getKey();
      Integer value = entry.getValue();
      outputBuilder.append("Key: ").append(key).append(", Value: ").append(value).append("\n");
    }

    tvOutput.setText(outputBuilder.toString());

    ArrayList<Map.Entry<String, Integer>> entryArrayList = new ArrayList<>(countLettersHashMap.entrySet());

    entryArrayList.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed());
    //also like this: entryArrayList.sort((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));

    btnFinish.setOnClickListener(view -> {

      StringBuilder threeNumbers = new StringBuilder();

      for (int i = 0; i < 3; i++) {

        Map.Entry<String, Integer> entry = entryArrayList.get(i);
        threeNumbers.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
      }
      Intent data = new Intent();
      data.putExtra(ANALYZED_DATA,threeNumbers.toString());
      setResult(RESULT_OK, data);
      finish();
    });

  }
}