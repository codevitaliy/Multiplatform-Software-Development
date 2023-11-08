package com.example.pmdm.u3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.pmdm.R;

public class u3a7left4deadMain extends AppCompatActivity {
  public static final Integer PLAYER_ONE_CHOICE = null;
  public static final Integer PLAYER_TWO_CHOICE =null;
  ImageButton btnPlayerOne;
  ImageButton btnPlayerTwo;
  ImageButton btnWeaponOne;
  ImageButton btnWeaponTwo;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Make the activity full-screen
    fullScreen();

    btnPlayerOne = findViewById(R.id.u3a7btnPlayer1);
    btnPlayerTwo = findViewById(R.id.u3a7btnPlayer2);
    btnWeaponOne = findViewById(R.id.u3a7btnWeapon1);
    btnWeaponTwo = findViewById(R.id.u3a7btnWeapon2);

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if(result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if(data != null) {
                  Integer receivedData = data.getIntExtra(u3a7left4deadSelectCharacter.CHARACTER_PLAYER_ONE,DEFAULT_KEYS_DISABLE);
                  System.out.println(receivedData);
                  if(receivedData != null) {
                    if(receivedData == 2) {
                      int newImageResource = R.drawable.character_3;
                      btnPlayerOne.setImageResource(newImageResource);
                    }
                    //Toast.makeText(u3a7left4deadMain.this, R.string.CANCEL_MESSAGE, Toast.LENGTH_SHORT).show();
                  }
                }
              }
            }
    );

    btnPlayerOne.setOnClickListener(view -> {
      Intent intent = new Intent(u3a7left4deadMain.this, u3a7left4deadSelectCharacter.class);
      launcher.launch(intent);
    });

    btnPlayerTwo.setOnClickListener(view ->{
      Intent intent = new Intent(u3a7left4deadMain.this, u3a7left4deadSelectCharacter.class);
      launcher.launch(intent);
    });

    btnWeaponOne.setOnClickListener(view -> {
      Intent intent = new Intent(u3a7left4deadMain.this, u3a7left4deadSelectWeapon.class);
      launcher.launch(intent);
    });


    btnWeaponTwo.setOnClickListener(view -> {
      Intent intent = new Intent(u3a7left4deadMain.this, u3a7left4deadSelectWeapon.class);
      launcher.launch(intent);
    });


  }

  public void fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.u3a7left4dead);
  }

}