package com.example.drawerfamex.pantallas.configuracion.reportarProblema;

import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.drawerfamex.adapters.pMenu;
import com.example.drawerfamex.popups.tutorial.fragPantallaTutorial;
import com.example.drawerfamex.R;



public class pReportarProblema extends pMenu {

    private DrawerLayout drawerLayout;
    private static final int REQUEST_CODE_IMAGE = 101;
    private Uri mImageUri;
    private ImageView previaImagen;
    TextView btnreportar; //Mandar Datos
    ImageView btnEnviarCaptura; //Obtener imagenes

    EditText txtinformacion; //Obtener datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.aas_19_reportar);
        super.onCreate(savedInstanceState);
        //setMenu();
        btnreportar = findViewById(R.id.rep_4_txt_btnEnviar);
        btnEnviarCaptura = findViewById(R.id.imageView61);
        txtinformacion = findViewById(R.id.editTextTextPersonName);
        previaImagen = findViewById(R.id.imageView61);
        //
        //Dar un salto de linea al presionar ENTER
        txtinformacion.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                    // Insert line break
                    txtinformacion.append("\n");
                    return true;
                }
                return false;
            }
        });

        //Examiinar imagen de dispositivo de usuario
        btnEnviarCaptura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when TextView is clicked
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the image picker activity with a request code

                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });

        //Obtener informacion introducida por el usuario
        btnreportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String description = txtinformacion.getText().toString();

                if(description.isEmpty() && mImageUri == null){
                    Toast.makeText(getApplicationContext(), "Nos has introducido información para ser enviada", Toast.LENGTH_SHORT).show();
                } else if ( mImageUri != null && description.isEmpty() ) {
                    Toast.makeText(getApplicationContext(), "¿Cuál ha sido tu problema?", Toast.LENGTH_SHORT).show();
                    // } else if(!description.isEmpty() && mImageUri != null || mImageUri == null) {
                }else{
                    String titulo = "Error en app FAMEX";
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);

                    //String recipient = "problemasapp@famex.com.mx";
                    String recipient = "dedddddd78798@gmail.com";

                    emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, titulo);

                    //String body = "Title: " + title + "\n\nDescription: " + description;
                    String body = description;
                    emailIntent.putExtra(Intent.EXTRA_TEXT, body);

                    if (mImageUri != null) {
                        emailIntent.putExtra(Intent.EXTRA_STREAM, mImageUri);
                    }

                    // Set the email type
                    emailIntent.setType("message/rfc822");

                    // Start the email activity
                    startActivity(Intent.createChooser(emailIntent, "Send Email"));

                    Toast.makeText(getApplicationContext(), "Reporte listo para ser enviado. ¡Gracias!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
// GOOD CODE
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null) {
            // Get the image URI from the intent
            mImageUri = data.getData();

            // Display the selected image in the ImageView
            previaImagen = findViewById(R.id.imageView61);
            previaImagen.setImageURI(mImageUri);
        }

        Toast.makeText(getApplicationContext(), "La captura ha sido adjuntada", Toast.LENGTH_SHORT).show();
    }







    @Override
    protected void onResume() {
        super.onResume();
        //Pantalla tutorial


        /*  SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.p_rep), false);

        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.p_rep), Boolean.TRUE);
            edit.commit();
            fragPantallaTutorial popup = new fragPantallaTutorial(11);
            popup.show(getSupportFragmentManager(),"DialogFrag");
        }*/


    }
}