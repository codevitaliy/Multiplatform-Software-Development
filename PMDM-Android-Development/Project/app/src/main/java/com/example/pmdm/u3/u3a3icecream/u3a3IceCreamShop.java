package com.example.pmdm.u3.u3a3icecream;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3a3IceCreamShop extends AppCompatActivity {

  public static final String VANILLA_BALLS = "com.example.pmdm.u3.VANILLA_BALLS";
  public static final String STRAWBERRY_BALLS ="com.example.pmdm.u3.STRAWBERRY_BALLS";
  public static final String CHOCOLATE_BALLS ="com.example.pmdm.u3.CHOCOLATE_BALLS";
  public static final String SPINNER_SELECTION ="com.example.pmdm.ur.SPINNER_SELECTION";
  static final int MAX_NUMBER_BALLS = 3;
  static final int MIN_NUMBER_BALLS = 1;
  //PARA OCULTAR EL TECLADO PULSANDO EN CUALQUIER PARTE DE LA PANTALLA
  View rootView;
  EditText numberVanilla;
  EditText numberStrawberry;
  EditText numberChocolate;
  Spinner spinner;
  ArrayAdapter<String> adapter;
  ArrayList<String> spinnerData;
  Button generateBtn;
  int intVanillaBalls, intStrawberryBalls,intChocolateBalls, totalIceCream;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u3a3_ice_cream_shop);

    //find the root layout content of the activity
    rootView = findViewById(android.R.id.content);
    // Click listener to hide the soft keyboard
    rootView.setOnClickListener(v -> hideSoftKeyboard());

    numberVanilla = findViewById(R.id.u3a3etVanilla);
    numberStrawberry = findViewById(R.id.u3a3etStrawberry);
    numberChocolate = findViewById(R.id.u3a3etChocolate);
    generateBtn = findViewById(R.id.u3a3btGenerate);

    //ADD ELEMENTS TO A SPINNER
    spinner = findViewById(R.id.u3a3SpinnerTip);
    spinnerData = new ArrayList<>();
    adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerData);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    addElementToSpinner("CORNET");
    addElementToSpinner("TUB");

    //GENERATE BUTTON

    generateBtn.setOnClickListener(view -> {

      if(checkIceCream()) {
        Intent intent = new Intent(this, u3a3IceCreamLaunched.class);
        intent.putExtra(VANILLA_BALLS, intVanillaBalls);
        intent.putExtra(STRAWBERRY_BALLS, intStrawberryBalls);
        intent.putExtra(CHOCOLATE_BALLS, intChocolateBalls);

        String spinnerValue = spinner.getSelectedItem().toString();
        intent.putExtra(SPINNER_SELECTION, spinnerValue);

        startActivity(intent);
      }
    });

  }

  public boolean checkIceCream() {

    try {
      intVanillaBalls = Integer.parseInt(numberVanilla.getText().toString());
    }catch (NumberFormatException e) {
      intVanillaBalls = 0;
    }

    try {
      intStrawberryBalls = Integer.parseInt(numberStrawberry.getText().toString());
    }catch (NumberFormatException e) {
      intStrawberryBalls = 0;
    }

    try {
      intChocolateBalls = Integer.parseInt(numberChocolate.getText().toString());
    }catch (NumberFormatException e) {
      intChocolateBalls = 0;
    }

    totalIceCream = intVanillaBalls + intStrawberryBalls + intChocolateBalls;

    if(totalIceCream > MAX_NUMBER_BALLS) {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle("MAX NUMBER OF BALLS IS 3")
             .setMessage("Try again")
              .setNegativeButton("OK", (dialog, which) -> dialog.dismiss());

      AlertDialog alertDialog = builder.create();
      alertDialog.show();
      return false;
    }else if(totalIceCream < MIN_NUMBER_BALLS ) {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle("MIN NUMBER OF BALLS IS 1")
              .setMessage("Try again")
              .setNegativeButton("OK", (dialog, which) -> dialog.dismiss());

      AlertDialog alertDialog = builder.create();
      alertDialog.show();
      return false;
    } else {
      return true;
    }
  }

  public void hideSoftKeyboard() {
    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
    if (inputMethodManager != null) {
      View currentFocus = getCurrentFocus();
      if (currentFocus != null) {
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
      }
    }
  }


  //METHOD USED FOR ADDING ITEMS TO SPINNER
  public void addElementToSpinner(String element) {
    spinnerData.add(element);
    adapter.notifyDataSetChanged();
  }


}