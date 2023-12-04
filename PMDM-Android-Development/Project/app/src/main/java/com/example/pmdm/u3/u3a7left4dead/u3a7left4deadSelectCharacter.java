package com.example.pmdm.u3.u3a7left4dead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3a7left4deadSelectCharacter extends AppCompatActivity {

  static final String INFO_CHARACTER_SELECTED = "com.example.pmdm.u3.INFO_CHARACTER_SELECTED";
  static final String INFO_PLAYER_SELECTED_CHARACTER = "com.example.pmdm.u3.INFO_PLAYER_SELECTED";
  static final Integer DEFAULT_VALUE = 0;
  public enum PlayerCharacter {
    CHARACTER1, CHARACTER2, CHARACTER3, CHARACTER4;
  }
  String playerSelection;
  Integer alreadySelected;
  ImageButton imgBtnCharacter1, imgBtnCharacter2, imgBtnCharacter3, imgBtnCharacter4, imgBtnGoBack, imgBtnClean;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Make the activity full-screen
    fullScreen();

    imgBtnCharacter1 = findViewById(R.id.u3a7btnCharacter1);
    imgBtnCharacter2 = findViewById(R.id.u3a7btnCharacter2);
    imgBtnCharacter3 = findViewById(R.id.u3a7btnCharacter3);
    imgBtnCharacter4 = findViewById(R.id.u3a7btnCharacter4);
    imgBtnGoBack = findViewById(R.id.u3a7btnGoBackCharacter);
    imgBtnClean = findViewById(R.id.u3a7btnClearCharacter);

    imgBtnCharacter1.setTag(PlayerCharacter.CHARACTER1);
    imgBtnCharacter2.setTag(PlayerCharacter.CHARACTER2);
    imgBtnCharacter3.setTag(PlayerCharacter.CHARACTER3);
    imgBtnCharacter4.setTag(PlayerCharacter.CHARACTER4);

    Intent intent = getIntent();

    if(intent != null) {
      playerSelection = intent.getStringExtra(u3a7left4deadMain.INFO_PLAYER);
    }



    View.OnClickListener handler = (View view) -> {
      PlayerCharacter selectedCharacter = (PlayerCharacter) view.getTag();
      //

      switch (selectedCharacter) {
        case CHARACTER1:
          handleCharacterSelection(PlayerCharacter.CHARACTER1);
          backgroundColor(imgBtnCharacter1);
          break;
        case CHARACTER2:
          handleCharacterSelection(PlayerCharacter.CHARACTER2);
          backgroundColor(imgBtnCharacter2);
          break;
        case CHARACTER3:
          handleCharacterSelection(PlayerCharacter.CHARACTER3);
          backgroundColor(imgBtnCharacter3);
          break;
        case CHARACTER4:
          handleCharacterSelection(PlayerCharacter.CHARACTER4);
          backgroundColor(imgBtnCharacter4);
          break;
        default:
          // for default
          break;
      }
    };

    imgBtnCharacter1.setOnClickListener(handler);
    imgBtnCharacter2.setOnClickListener(handler);
    imgBtnCharacter3.setOnClickListener(handler);
    imgBtnCharacter4.setOnClickListener(handler);

    goBack(imgBtnGoBack);

  }

  private void handleCharacterSelection(PlayerCharacter selectedCharacter) {
    // You can perform any actions related to character selection here
    // For example, you can pass the selected character to another activity
    Intent data = new Intent();
    data.putExtra(INFO_CHARACTER_SELECTED, selectedCharacter.toString());
    data.putExtra(INFO_PLAYER_SELECTED_CHARACTER, playerSelection);
    setResult(u3a7left4deadSelectCharacter.RESULT_OK, data);
    finish();
  }

  public void fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.u3a7left4dead_select_character);
  }

  public void backgroundColor(ImageButton button) {
    button.setBackgroundColor(0x6F000000);
  }

  public void goBack(ImageButton imgBtn) {
    imgBtn.setOnClickListener( v -> {
      finish();
    });

  }


}
