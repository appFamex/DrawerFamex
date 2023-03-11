package com.example.drawerfamex.pantallas.iniciarSesion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drawerfamex.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class pRegistrar extends AppCompatActivity {

    EditText etxtCorreo, etxtContraseña, etxtConfirmarContraseña;
    Button btnRegistrar, back;
    TextView txtTengoCuenta;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    String correo = "";
    String contraseña = "";
    String confirmarcontraseña = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aab_2_registro);

        etxtCorreo = findViewById(R.id.rgr_1_txt_iCorreo);
        etxtContraseña = findViewById(R.id.rgr_2_txt_iContra);
        etxtConfirmarContraseña = findViewById(R.id.rgr_3_txt_iRepContra);

        btnRegistrar = findViewById(R.id.rgr_4_btn_rgr);
        back = findViewById(R.id.rgr_5_btn_back);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(pRegistrar.this);
        progressDialog.setTitle("Espere un momento por favor");
        progressDialog.setCanceledOnTouchOutside(false); //bloquea la pantalla para que no lo cancele

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarDatos();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pRegistrar.this, MainActivity.class));
                finish();
            }
        });

        //Boton de Confirmar Contrasena -
        EditText passwordEditText = findViewById(R.id.rgr_2_txt_iContra);
        Drawable lockDrawable = ContextCompat.getDrawable(this, R.drawable.ic_action_lock);
        Drawable eyeDrawable = ContextCompat.getDrawable(this, R.drawable.ic_visibility);

// Set the bounds of the drawables to match their intrinsic sizes
        if (lockDrawable != null) {
            lockDrawable.setBounds(0, 0, lockDrawable.getIntrinsicWidth(), lockDrawable.getIntrinsicHeight());
        }
        if (eyeDrawable != null) {
            eyeDrawable.setBounds(0, 0, eyeDrawable.getIntrinsicWidth(), eyeDrawable.getIntrinsicHeight());
        }

// Set the compound drawables for the EditText
        passwordEditText.setCompoundDrawablesWithIntrinsicBounds(lockDrawable, null, eyeDrawable, null);

        //Poder ver/ocultar la contrasena cuando se toca el icono del ojo
        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordEditText.getRight() - passwordEditText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (passwordEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        } else {
                            passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        }
                        passwordEditText.setSelection(passwordEditText.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });

        //Boton de Confirmar Contrasena -
        EditText passwordEditText2 = findViewById(R.id.rgr_3_txt_iRepContra);
        Drawable lockDrawable2 = ContextCompat.getDrawable(this, R.drawable.ic_action_lock);
        Drawable eyeDrawable2 = ContextCompat.getDrawable(this, R.drawable.ic_visibility);

// Set the bounds of the drawables to match their intrinsic sizes
        if (lockDrawable2 != null) {
            lockDrawable2.setBounds(0, 0, lockDrawable2.getIntrinsicWidth(), lockDrawable2.getIntrinsicHeight());
        }
        if (eyeDrawable2 != null) {
            eyeDrawable2.setBounds(0, 0, eyeDrawable2.getIntrinsicWidth(), eyeDrawable2.getIntrinsicHeight());
        }

// Set the compound drawables for the EditText
        passwordEditText2.setCompoundDrawablesWithIntrinsicBounds(lockDrawable2, null, eyeDrawable2, null);

        //Poder ver/ocultar la contrasena cuando se toca el icono del ojo
        passwordEditText2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordEditText2.getRight() - passwordEditText2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (passwordEditText2.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                            passwordEditText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        } else {
                            passwordEditText2.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        }
                        passwordEditText2.setSelection(passwordEditText2.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });


   }




    public void validarDatos() {
        correo = etxtCorreo.getText().toString();
        contraseña = etxtContraseña.getText().toString();
        confirmarcontraseña = etxtConfirmarContraseña.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) { // valida @ y .com
            Toast.makeText(this, getString(R.string.TOAST_REG_TXT_Correo), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(contraseña)) {
            Toast.makeText(this, getString(R.string.TOAST_REG_TXT_Contraseña), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(confirmarcontraseña)){
            Toast.makeText(this, getString(R.string.TOAST_REG_TXT_RepContraseña), Toast.LENGTH_SHORT).show();
        } else if(!contraseña.equals(confirmarcontraseña)){
            Toast.makeText(this, getString(R.string.TOAST_REG_TXT_RepContraseña2), Toast.LENGTH_SHORT).show();
        } else{
            crearCuenta();
        }
    }

    private void crearCuenta() {
        progressDialog.setMessage("Creando su cuenta...");
        progressDialog.show();

        //Creando usuario en firebase
        firebaseAuth.createUserWithEmailAndPassword(correo, contraseña)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) { // registro exitoso
                        guardarInformacion();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) { //registro no exitoso
                        /* causas de registro no exitoso es por el internes*/
                        progressDialog.dismiss();
                        Toast.makeText(pRegistrar.this,"" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void guardarInformacion() {
        progressDialog.setTitle("Guardando su información");
        progressDialog.dismiss();

        //Obtener la identificacion de usuario
        String iduser = firebaseAuth.getUid();

        //Se designa las claves para los valores correspondientes
        HashMap<String, String> Datos = new HashMap<>();
        Datos.put("uid",iduser);
        Datos.put("correo", correo);

        String [] correopartes = correo.split("(@)");
        Datos.put("nombres", correopartes[0]);
        Datos.put("contraseña",contraseña);

        //usuarios nombre de la base de datos
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
        databaseReference.child(iduser)     // enlistar la bd por el id
                .setValue(Datos) // cada usuario que se registre tendra los datos
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        progressDialog.dismiss();
                        Toast.makeText(pRegistrar.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(pRegistrar.this, MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.dismiss();
                        Toast.makeText(pRegistrar.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // presionar la flecha atras te regresa
        return super.onSupportNavigateUp();
    }

    public void ClickVolver(View view) {
        MainActivity.redirectActivity(this, MainActivity.class);
    }
}