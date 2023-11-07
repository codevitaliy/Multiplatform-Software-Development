package com.example.pmdm.u3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm.R;

public class u3a6TextAnalyzer extends AppCompatActivity {

  static final String ANALYZING_DATA = "com.example.pmdm.u3.ANALYZE_DATA";
  EditText etInput;
  TextView tvOutput;
  Button btnAnalyze;
  String analyzeText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a6_text_analyzer);

    etInput = findViewById(R.id.u3a6etTextInput);
    tvOutput = findViewById(R.id.u3a6tvResult);
    btnAnalyze = findViewById(R.id.u3a6btnAnalyze);

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if(result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if(data != null) {
                  String receiveData = data.getStringExtra(u3a6TextAnalyzerLaunched.ANALYZED_DATA);
                  if(receiveData != null) {
                    tvOutput.setText(receiveData);
                  }
                }
              }else if (result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(u3a6TextAnalyzer.this,R.string.CANCEL_MESSAGE,Toast.LENGTH_SHORT).show();
              }
            }
    ) ;

    btnAnalyze.setOnClickListener(view -> {
      // Move this line inside the click listener
      analyzeText = etInput.getText().toString();

      Intent intent = new Intent(u3a6TextAnalyzer.this, u3a6TextAnalyzerLaunched.class);
      intent.putExtra(ANALYZING_DATA, analyzeText);
      launcher.launch(intent);
    });



  }
}