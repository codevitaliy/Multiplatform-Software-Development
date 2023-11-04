package com.example.pmdm.u3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmdm.R;

public class u3a4WarmUp extends AppCompatActivity {

  TextView tvUserName;
  Button btnChooseName;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u3a4_warm_up);

    tvUserName = findViewById(R.id.u3a4tvName);
    btnChooseName = findViewById(R.id.u3a4BtnChangeName);


    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if(result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if(data != null){
                  String receivedData = data.getStringExtra(u3a4WarmUpLaunched.NAME_DATA);
                  if (receivedData != null) {
                    tvUserName.setText(receivedData);
                  }
                }
              }else if(result.getResultCode() == RESULT_CANCELED) {
                Toast.makeText(u3a4WarmUp.this,R.string.CANCEL_MESSAGE,Toast.LENGTH_SHORT).show();
              }
            }
    );

    btnChooseName.setOnClickListener(view -> {
      Intent intent = new Intent(this, u3a4WarmUpLaunched.class);

      launcher.launch(intent);

    });

  }
}