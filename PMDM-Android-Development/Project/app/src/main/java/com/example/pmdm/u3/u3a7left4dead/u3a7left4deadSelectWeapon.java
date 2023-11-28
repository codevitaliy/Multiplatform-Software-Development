package com.example.pmdm.u3.u3a7left4dead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.pmdm.R;

public class u3a7left4deadSelectWeapon extends AppCompatActivity {

  static final String INFO_WEAPON_SELECTED = "com.example.pmdm.u3.INFO_WEAPON_SELECTED";
  static final String INFO_PLAYER_SELECTED_WEAPON = "com.example.pmdm.u3.INFO_PLAYER_SELECTED";

  public enum PlayerWeapon {
    WEAPON1, WEAPON2, WEAPON3, WEAPON4;
  }
  String playerSelection;
  ImageButton imgBtnWeapon1, imgBtnWeapon2, imgBtnWeapon3, imgBtnWeapon4, imgBtnGoBack, imgBtnClean;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Make the activity full-screen
    fullScreen();

    imgBtnWeapon1 = findViewById(R.id.u3a7btnWeapon1);
    imgBtnWeapon2 = findViewById(R.id.u3a7btnWeapon2);
    imgBtnWeapon3 = findViewById(R.id.u3a7btnWeapon3);
    imgBtnWeapon4 = findViewById(R.id.u3a7btnWeapon4);
    imgBtnGoBack = findViewById(R.id.btnGoBackWeapon);
    imgBtnClean = findViewById(R.id.u3a7btnClearWeapon);

    imgBtnWeapon1.setTag(PlayerWeapon.WEAPON1);
    imgBtnWeapon2.setTag(PlayerWeapon.WEAPON2);
    imgBtnWeapon3.setTag(PlayerWeapon.WEAPON3);
    imgBtnWeapon4.setTag(PlayerWeapon.WEAPON4);

    Intent intent = getIntent();

    if(intent != null) {
      playerSelection = intent.getStringExtra(u3a7left4deadMain.INFO_PLAYER);
    }


    View.OnClickListener handler = (View view) -> {
      PlayerWeapon selectedWeapon = (PlayerWeapon) view.getTag();

      switch (selectedWeapon) {
        case WEAPON1:
          handleWeaponSelection(PlayerWeapon.WEAPON1);
          backgroundColor(imgBtnWeapon1);
          break;
        case WEAPON2:
          handleWeaponSelection(PlayerWeapon.WEAPON2);
          backgroundColor(imgBtnWeapon2);
          break;
        case WEAPON3:
          handleWeaponSelection(PlayerWeapon.WEAPON3);
          backgroundColor(imgBtnWeapon3);
          break;
        case WEAPON4:
          handleWeaponSelection(PlayerWeapon.WEAPON4);
          backgroundColor(imgBtnWeapon4);
          break;
        default:
          // for default
          break;
      }
    };

    imgBtnWeapon1.setOnClickListener(handler);
    imgBtnWeapon2.setOnClickListener(handler);
    imgBtnWeapon3.setOnClickListener(handler);
    imgBtnWeapon4.setOnClickListener(handler);

    goBack(imgBtnGoBack);
  }

  private void handleWeaponSelection(PlayerWeapon selectedWeapon) {
    // You can perform any actions related to weapon selection here
    // For example, you can pass the selected weapon to another activity
    Intent data = new Intent();
    data.putExtra(INFO_WEAPON_SELECTED, selectedWeapon.toString());
    data.putExtra(INFO_PLAYER_SELECTED_WEAPON, playerSelection);
    setResult(u3a7left4deadSelectWeapon.RESULT_OK, data);
    finish();
  }


  public void fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.u3a7left4dead_select_weapon);
  }

  public void backgroundColor(ImageButton button) {
    button.setBackgroundColor(0x6F000000);
  }

  public void goBack(ImageButton imgBtn) {
    imgBtn.setOnClickListener( v -> {
      finish();
    });
  }

  public void Clean(ImageButton imgBtn){
    imgBtn.setOnClickListener(v -> {
      Intent data = new Intent();
    });
  }
}
