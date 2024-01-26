package com.example.repaso_pmdm.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.repaso_pmdm.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class u2a4CitaMedica extends AppCompatActivity {
  Button btnDatePicker;
  TextView tvSelectedDate;
  DatePickerDialog.OnDateSetListener onDateSetListener;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u2a4_cita_medica);



}


