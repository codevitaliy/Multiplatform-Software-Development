package com.example.pmdm.u3;

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
  static final int MAX_NUMBER = 3;
  View rootView;
  EditText numberVanilla;
  EditText numberStrawberry;
  EditText numberChocolate;
  Spinner spinner;
  ArrayAdapter<String> adapter;
  ArrayList<String> spinnerData;
  Button generateBtn;


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
    addElementToSpinner("CHOCO CORNET");
    addElementToSpinner("TUB");

    //GENERATE BUTTON

    generateBtn.setOnClickListener(view -> {

      checkIceCream();





    });




  }

  public boolean checkIceCream() {

    int vanillaInt,strawberryInt,chocolateInt,totalIceCream;

    vanillaInt = Integer.parseInt(numberVanilla.getText().toString());
    strawberryInt = Integer.parseInt(numberStrawberry.getText().toString());
    chocolateInt = Integer.parseInt(numberChocolate.getText().toString());

    totalIceCream = vanillaInt + strawberryInt + chocolateInt;

    if(totalIceCream > MAX_NUMBER) {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle("MAX NUMBER OF BALLS IS 3")
             .setMessage("Try again")
              .setNegativeButton("OK", (dialog, which) -> dialog.dismiss());

      AlertDialog alertDialog = builder.create();
      alertDialog.show();
      return false;
    }else {
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