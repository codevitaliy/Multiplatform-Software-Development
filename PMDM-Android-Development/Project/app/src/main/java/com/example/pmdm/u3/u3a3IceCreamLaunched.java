package com.example.pmdm.u3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.pmdm.R;

public class u3a3IceCreamLaunched extends AppCompatActivity {

  ImageView cone, tub, vanilla1, vanilla2, vanilla3, strawberry1, strawberry2,
                              strawberry3, chocolate1, chocolate2, chocolate3;
  Integer vanillaBallsInt,strawberryBallsInt,chocolateBallsInt;
  String spinnerSelection;
  static final int DEFAULT_VALUE = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a3_ice_cream_launched);

    cone = findViewById(R.id.u3a3ivCone);
    tub = findViewById(R.id.u3a3ivTub);
    vanilla1 = findViewById(R.id.u3a3ivVanilla1);
    vanilla2 = findViewById(R.id.u3a3ivVanilla2);
    vanilla3 = findViewById(R.id.u3a3ivVanilla3);
    strawberry1 = findViewById(R.id.u3a3ivStrawberry1);
    strawberry2 = findViewById(R.id.u3a3ivStrawberry2);
    strawberry3 = findViewById(R.id.u3a3ivStrawberry3);
    chocolate1 = findViewById(R.id.u3a3ivChocolate1);
    chocolate2 = findViewById(R.id.u3a3ivChocolate2);
    chocolate3 = findViewById(R.id.u3a3ivChocolate3);

    Bundle info = getIntent().getExtras();

    vanillaBallsInt = info.getInt(u3a3IceCreamShop.VANILLA_BALLS,DEFAULT_VALUE);
    strawberryBallsInt = info.getInt(u3a3IceCreamShop.STRAWBERRY_BALLS,DEFAULT_VALUE);
    chocolateBallsInt = info.getInt(u3a3IceCreamShop.CHOCOLATE_BALLS,DEFAULT_VALUE);
    spinnerSelection = info.getString(u3a3IceCreamShop.SPINNER_SELECTION);
    spinnerSelection = spinnerSelection.toLowerCase();

    generateIceCream();

  }

  public void generateIceCream() {

    // Set visibility based on the selected container
    if (spinnerSelection.equals("cornet")) {
      cone.setVisibility(View.VISIBLE);
    } else if (spinnerSelection.equals("tub")) {
      tub.setVisibility(View.VISIBLE);
    }

    // Set visibility for individual ice cream balls
    vanilla1.setVisibility(vanillaBallsInt >= 1 ? View.VISIBLE : View.GONE);
    vanilla2.setVisibility(vanillaBallsInt >= 2 ? View.VISIBLE : View.GONE);
    vanilla3.setVisibility(vanillaBallsInt == 3 ? View.VISIBLE : View.GONE);

    strawberry1.setVisibility(strawberryBallsInt >= 1 ? View.VISIBLE : View.GONE);
    strawberry2.setVisibility(strawberryBallsInt >= 2 ? View.VISIBLE : View.GONE);
    strawberry3.setVisibility(strawberryBallsInt == 3 ? View.VISIBLE : View.GONE);

    chocolate1.setVisibility(chocolateBallsInt >= 1 ? View.VISIBLE : View.GONE);
    chocolate2.setVisibility(chocolateBallsInt >= 2 ? View.VISIBLE : View.GONE);
    chocolate3.setVisibility(chocolateBallsInt == 3 ? View.VISIBLE : View.GONE);
  }
}