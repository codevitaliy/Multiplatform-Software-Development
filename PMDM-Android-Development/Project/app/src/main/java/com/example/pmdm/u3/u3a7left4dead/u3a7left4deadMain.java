package com.example.pmdm.u3.u3a7left4dead;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3a7left4deadMain extends AppCompatActivity {

  public enum SelectedType {
    CHARACTER,
    WEAPON;
  }

  static final String PLAYER_ONE = "PLAYER_ONE";
  static final String PLAYER_TWO = "PLAYER_TWO";
  static final String INFO_PLAYER = "com.example.pmdm.u3.INFO_PLAYER";
  static final String INFO_SELECTED_WEAPON = "com.example.pmdm.u3.INFO_SELECTED_WEAPON";
  String selectedPlayer = "";
  Integer selectedWeaponImage;
  Integer selectedCharacterImage;
  String receivedDataCharacters;
  String receiveDataWeapons;
  ImageButton btnPlayerOne, btnPlayerTwo, btnWeaponOne, btnWeaponTwo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Make the activity full-screen
    fullScreen();

    btnPlayerOne = findViewById(R.id.u3a7btnPlayer1);
    btnPlayerTwo = findViewById(R.id.u3a7btnPlayer2);
    btnWeaponOne = findViewById(R.id.u3a7btnWeapon1);
    btnWeaponTwo = findViewById(R.id.u3a7btnWeapon2);

    btnPlayerOne.setTag(SelectedType.CHARACTER);
    btnPlayerTwo.setTag(SelectedType.CHARACTER);
    btnWeaponOne.setTag(SelectedType.WEAPON);
    btnWeaponTwo.setTag(SelectedType.WEAPON);



    ActivityResultLauncher<Intent> launcherSelectCharacters = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if(result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if(data != null) {
                  receivedDataCharacters = data.getStringExtra(u3a7left4deadSelectCharacter.INFO_CHARACTER_SELECTED);
                  String receivedCharacter = data.getStringExtra(u3a7left4deadSelectCharacter.INFO_PLAYER_SELECTED_CHARACTER);
                  if(receivedDataCharacters != null || receivedCharacter != null) {
                      int newImageResource;

                      if(receivedCharacter.equals(PLAYER_ONE)) {
                        switch (receivedDataCharacters) {
                          case "CHARACTER1":
                            newImageResource = R.drawable.character_1;
                            btnPlayerOne.setImageResource(newImageResource);
                            selectedCharacterImage = 1;
                            break;
                          case "CHARACTER2":
                            newImageResource = R.drawable.character_2;
                            btnPlayerOne.setImageResource(newImageResource);
                            selectedCharacterImage = 2;
                            break;
                          case "CHARACTER3":
                            newImageResource = R.drawable.character_3;
                            btnPlayerOne.setImageResource(newImageResource);
                            selectedCharacterImage = 3;
                            break;
                          case "CHARACTER4":
                            newImageResource = R.drawable.character_4;
                            btnPlayerOne.setImageResource(newImageResource);
                            selectedCharacterImage = 4;
                        }
                      }else if (receivedCharacter.equals(PLAYER_TWO)) {
                        switch (receivedDataCharacters) {
                          case "CHARACTER1":
                            newImageResource = R.drawable.character_1;
                            btnPlayerTwo.setImageResource(newImageResource);
                            break;
                          case "CHARACTER2":
                            newImageResource = R.drawable.character_2;
                            btnPlayerTwo.setImageResource(newImageResource);
                            break;
                          case "CHARACTER3":
                            newImageResource = R.drawable.character_3;
                            btnPlayerTwo.setImageResource(newImageResource);
                            break;
                          case "CHARACTER4":
                            newImageResource = R.drawable.character_4;
                            btnPlayerTwo.setImageResource(newImageResource);
                        }
                      }
                  }
                }
              }
            }
    );

    ActivityResultLauncher<Intent> launcherSelectWeapons = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
              if (result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();
                if (data != null) {
                  String receivedWeapon = data.getStringExtra(u3a7left4deadSelectWeapon.INFO_WEAPON_SELECTED);
                  // Change the line below to get the correct information for the selected character
                  String receiveDataWeapons = data.getStringExtra(u3a7left4deadSelectWeapon.INFO_PLAYER_SELECTED_WEAPON);
                  //
                  if (receiveDataWeapons != null || receivedWeapon != null) {
                   int newImageResource;

                    if (receiveDataWeapons.equals(PLAYER_ONE)) {
                      switch (receivedWeapon) {
                        case "WEAPON1":
                          newImageResource = R.drawable.weapon_1;
                          btnWeaponOne.setImageResource(newImageResource);
                          break;
                        case "WEAPON2":
                          newImageResource = R.drawable.weapon_2;
                          btnWeaponOne.setImageResource(newImageResource);
                          break;
                        case "WEAPON3":
                          newImageResource = R.drawable.weapon_3;
                          btnWeaponOne.setImageResource(newImageResource);
                          break;
                        case "WEAPON4":
                          newImageResource = R.drawable.weapon_4;
                          btnWeaponOne.setImageResource(newImageResource);
                          break;
                      }
                    } else if (receiveDataWeapons.equals(PLAYER_TWO)) {
                      switch (receivedWeapon) {
                        case "WEAPON1":
                          newImageResource = R.drawable.weapon_1;
                          btnWeaponTwo.setImageResource(newImageResource);
                          break;
                        case "WEAPON2":
                          newImageResource = R.drawable.weapon_2;
                          btnWeaponTwo.setImageResource(newImageResource);
                          break;
                        case "WEAPON3":
                          newImageResource = R.drawable.weapon_3;
                          btnWeaponTwo.setImageResource(newImageResource);
                          break;
                        case "WEAPON4":
                          newImageResource = R.drawable.weapon_4;
                          btnWeaponTwo.setImageResource(newImageResource);
                          break;
                      }
                    }
                  }
                }
              }
            }
    );


    View.OnClickListener handlerPlayer = view -> {
      if (view.getId() == R.id.u3a7btnPlayer1 || view.getId() == R.id.u3a7btnWeapon1) {
        selectedPlayer = PLAYER_ONE;
      } else if (view.getId() == R.id.u3a7btnPlayer2 || view.getId() == R.id.u3a7btnWeapon2) {
        selectedPlayer = PLAYER_TWO;
      }

      if (view.getTag() == SelectedType.CHARACTER) {
        Intent intent = new Intent(u3a7left4deadMain.this, u3a7left4deadSelectCharacter.class);
        if(selectedCharacterImage == null) {
          intent.putExtra(INFO_PLAYER, selectedPlayer);
        }else {
          intent.putExtra(INFO_SELECTED_WEAPON,selectedWeaponImage);
          intent.putExtra(INFO_PLAYER, selectedPlayer);
        }
        launcherSelectCharacters.launch(intent);
      } else if (view.getTag() == SelectedType.WEAPON) {
        Intent intent = new Intent(u3a7left4deadMain.this, u3a7left4deadSelectWeapon.class);
        intent.putExtra(INFO_PLAYER, selectedPlayer);
        launcherSelectWeapons.launch(intent); // You were missing this line
      }
    };

    btnPlayerOne.setOnClickListener(handlerPlayer);
    btnPlayerTwo.setOnClickListener(handlerPlayer);
    btnWeaponOne.setOnClickListener(handlerPlayer);
    btnWeaponTwo.setOnClickListener(handlerPlayer);


  }

  public void fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.u3a7left4dead);
  }

}