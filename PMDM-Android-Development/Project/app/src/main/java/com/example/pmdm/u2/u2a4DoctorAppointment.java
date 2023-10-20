package com.example.pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class u2a4DoctorAppointment extends AppCompatActivity {

  EditText etDNI;
  TextView dniValidationText;
  View rootView;
  Button btnDatePicker;
  Button btnTimePicker;
  DatePickerDialog.OnDateSetListener onDateSetListener;
  String selectedDate;
  TimePickerDialog.OnTimeSetListener onTimeSetListener;
  String selectedTime;
  TextView displayTimeDayMessage;

  //String regex = "^[a-zA-Z0-9_]+$"; Letras, Números y Guiones Bajos (Underscores);
  //String regex = "^[a-zA-Z]{5}[0-9]{2}$"; 5 letras y 2 números al final;
  private static final String REGEX_DNI = "[0-9]{8}[A-Za-z]$";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u2a4_doctor_appointment);

    etDNI = findViewById(R.id.u2a4etInputDNI);
    dniValidationText = findViewById(R.id.u2a4tvValidation);
    btnDatePicker = findViewById(R.id.u2a4btChooseDate);
    btnTimePicker = findViewById(R.id.u2a4btChooseTime);
    displayTimeDayMessage = findViewById(R.id.u2a4tvMessage);

    //find the root layout content of the activity
    rootView = findViewById(android.R.id.content);

    // Click listener to hide the soft keyboard
    rootView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        hideSoftKeyboard();
      }
    });

    // SIRVE PARA ACTUALIZAR EN TIEMPO REAL EL EDIT TEXT CON LA FUNCION DE CHECKDNI
    etDNI.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
      }
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }
      @Override
      public void afterTextChanged(Editable s) {
        dniValidationText.setText("");
        dniValidationText.setTextColor(Color.BLACK);
        checkDNI();
      }
    });

    //----------------------------------------------------------------------------------------------
    //Seleccionar fecha elegida por el dialog de date picker
    btnDatePicker.setOnClickListener(v -> {

      Calendar calendar = Calendar.getInstance();
      int year = calendar.get(Calendar.YEAR);
      int month = calendar.get(Calendar.MONTH);
      int day = calendar.get(Calendar.DAY_OF_MONTH);

      DatePickerDialog datePickerDialog = new DatePickerDialog(
              u2a4DoctorAppointment.this,
              onDateSetListener,
              year,
              month,
              day
      );

      datePickerDialog.show();
    });

    onDateSetListener = (view, year, monthOfYear, dayOfMonth) -> {
      // This is the callback method when the date is set
      // You can handle the selected date here
      selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
      // Do something with the selected date, like updating a TextView
    };

  //-----------------------------------------------------------------------------------------------
  //UTILIZAMOS EL TIME PICKER DIALOG PARA SELECCIONAR LA HORA

    btnTimePicker.setOnClickListener(v -> {

      Calendar calendar = Calendar.getInstance();
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      int minute = calendar.get(Calendar.MINUTE);

      //create a TimePickerDialog

      TimePickerDialog timePickerDialog = new TimePickerDialog(
              u2a4DoctorAppointment.this,
              onTimeSetListener,
              hour,
              minute,
              true // false if you want 12 hr format

      );
      timePickerDialog.show();
    });

    /* SI NO FUERA LAMBDA
    onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
      @Override
      public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        selectedTime = hourOfDay + ":" + minute;
      }
    };
    */

    onTimeSetListener = (view, hourOfDay, minute) -> {
      selectedTime = hourOfDay + ":" + minute;
    };
    //---------------------------------------------------------------------------------------------

    //Shows the message of the date and time in the TextView
    //displayTimeDayMessage.setText(setDateTimeMessage());


  }
  public void checkDNI() {
    String dni = etDNI.getText().toString().trim();  // Trim to remove leading/trailing spaces

    if (dni.isEmpty()) {
      dniValidationText.setText("DNI cannot be empty");
      dniValidationText.setTextColor(Color.RED);
      return;
    }

    if (dni.matches(REGEX_DNI)) {
      int dniInt = Integer.parseInt(dni.substring(0, 8));
      String dniLetterString = dni.toUpperCase().substring(8);
      char dniLetter = dniLetterString.charAt(0);
      int dniModNumber = 23;
      int dniRemainder = dniInt % dniModNumber;

      char[] letterArray = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

      for (int i = 0; i < letterArray.length; i++) {
        if (dniLetter == letterArray[i] && dniRemainder == i) {
          dniValidationText.setText("RIGHT DNI");
          dniValidationText.setTextColor(Color.GREEN);
          return;  // No need to continue checking
        }
      }
      dniValidationText.setText("WRONG DNI LETTER");
      dniValidationText.setTextColor(Color.RED);
    } else {
      dniValidationText.setText("WRONG DNI FORMAT");
      dniValidationText.setTextColor(Color.RED);
    }
  }

  //hide the soft keyboard
  public void hideSoftKeyboard() {
    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
      if (inputMethodManager != null) {
        View currentFocus = getCurrentFocus();
        if(currentFocus != null) {
          inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
      }
  }

  public String setDateTimeMessage() {
    String message = "";

    if(!selectedTime.isEmpty() && !selectedDate.isEmpty() && selectedTime != null && selectedDate != null) {
      message = "Fecha: " + selectedDate + "\n" +
                "Hora: " + selectedTime;
      displayTimeDayMessage.setText(message);
      displayTimeDayMessage.setTextColor(Color.BLACK);

    }
    return message;
  }
}