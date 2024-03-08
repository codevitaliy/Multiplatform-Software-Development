package com.example.pmdm.u5.pruebaPermiso;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.pmdm.R;

public class u5a1PruebaPermiso extends AppCompatActivity {

  Button btnLlamar;
  ActivityResultLauncher<String> requestPermissionLauncher;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.u5a1_prueba_permiso);

    btnLlamar = findViewById(R.id.u5a1BtnLlamar);

    btnLlamar.setOnClickListener(view -> {

      if (ContextCompat.checkSelfPermission(
              u5a1PruebaPermiso.this, Manifest.permission.CALL_PHONE) ==
              PackageManager.PERMISSION_GRANTED) { //  If it does, it means the app has the permission to perform operations that require this permission.
        // You can use the API that requires the permission.
        llamar();
      } else {
        // You can directly ask for the permission.
        // The registered ActivityResultCallback gets the result of this request.
        requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
      }
    });

    // Register the permissions callback, which handles the user's response to the
    // system permissions dialog. Save the return value, an instance of
    // ActivityResultLauncher, as an instance variable.

    requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
      if (isGranted) {
        // Permission is granted. Continue the action or workflow in your
        // app.
        llamar();
      } else {
        // Explain to the user that the feature is unavailable because the
        // feature requires a permission that the user has denied. At the
        // same time, respect the user's decision. Don't link to system
        // settings in an effort to convince the user to change their
        // decision.
        Toast.makeText(u5a1PruebaPermiso.this, "Necesitamos permiso para llamar", Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void llamar() {
    Intent phoneIntent = new Intent(Intent.ACTION_CALL);
    phoneIntent.setData(Uri.parse("tel:0034 666 66 66 66"));
    startActivity(phoneIntent);
  }

  //METHOD FOR PERMISSION IF NEEDED


  /* public void llamadaClick() {
    if (ContextCompat.checkSelfPermission(
            u5a1PruebaPermiso.this, Manifest.permission.CALL_PHONE) ==
            PackageManager.PERMISSION_GRANTED) {
      // You can use the API that requires the permission.
      llamar();
    } else if (false) {
      // In an educational UI, explain to the user why your app requires this
      // permission for a specific feature to behave as expected, and what
      // features are disabled if it's declined. In this UI, include a
      // "cancel" or "no thanks" button that lets the user continue
      // using your app without granting the permission.

      // Mostrar UI Dialog para explicar al usuarios la necesidad del permiso
      // Vamos a usar la de por defecto de Android. Se ejecuta en el else

    } else {
      // You can directly ask for the permission.
      // The registered ActivityResultCallback gets the result of this request.
      requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE);
    }
  } */


}