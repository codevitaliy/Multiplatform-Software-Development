package com.example.pmdm.u2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.pmdm.R;

public class u2a4DoctorAppointment extends AppCompatActivity {

  EditText etDNI;
  //public static final REGEX_DNI =

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_u2a4_doctor_appointment);
    etDNI = findViewById(R.id.u2a4etInputDNI);

  }


  public String getDNI() {
    return etDNI.getText().toString();
  }

  public boolean checkDNI() {
    String dni = getDNI();
    int dniNumbers = Integer.parseInt(dni.substring(0,9));

  }

}