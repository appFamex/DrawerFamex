package com.example.drawerfamex.pantallas.prefamex.rutas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.drawerfamex.adapters.pMenu;
import com.example.drawerfamex.popups.tutorial.fragPantallaTutorial;
import com.example.drawerfamex.R;

public class pRutas extends pMenu {


    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.aap_16_rutas);
        super.onCreate(savedInstanceState);
        //setMenu();

        ConstraintLayout texto1,texto2,texto3;
        fragPopUpRutas mFragment = new fragPopUpRutas();
        mFragment.valor = 1;
        mFragment.nom = "HOTELES FAMEX";
        mFragment.txtH = "Transporte desde los hoteles";
        mFragment.txtBaseDest = "Se proporcionara el el transporte a todos nuestros visitantes desde nuestros hoteles sede. Saliendo desde los mismos a las 8:30a.m. hacia el recinto ferial y de retorno a las 5:30p.m.";
        texto1 =  (ConstraintLayout) findViewById(R.id.ppp1);
        texto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFragment.img = R.drawable.gr_rutas_ppp_img_camion;
                mFragment.show(getSupportFragmentManager(),"DialogFrag");
            }
        });



        fragPopUpRutas ppp2 = new fragPopUpRutas();
        ppp2.valor = 2;
        ppp2.nom = "TRANSPORTE EXTERNO";
        ppp2.txtH = "Base Militar a FAMEX";
        ppp2.txtBaseDest = "Se proporcionara el transporte a todos nuestros visitantes desde la entrada de la base militar a la entrada del recinto ferial, comenzando desde las 7:30 a.m. y saliendo cada quince minutos en ambos puntos.";
        texto2 =  (ConstraintLayout) findViewById(R.id.ppp2);
        texto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ppp2.img = R.drawable.gr_rutas_ppp_img_camion2;
                ppp2.show(getSupportFragmentManager(),"DialogFrag");
            }
        });

        fragPopUpRutas ppp3 = new fragPopUpRutas();
        ppp3.valor = 3;
        ppp3.nom = "TRANSPORTE INTERNO";
        ppp3.txtH = "Carro de golf";
        ppp3.txtBaseDest = "Se proporcionara el transporte a todos nuestros acreditados dentro del recinto ferial entre pabellones y los diversos eventos. Recuerda portar tu acreditación.";

        texto3 =  (ConstraintLayout) findViewById(R.id.ppp3);
        texto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ppp3.img = R.drawable.gr_rutas_ppp_img_golf;
                ppp3.show(getSupportFragmentManager(),"DialogFrag");
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        //Pantalla tutorial

       /*
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.p_rutas), false);

        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.p_rutas), Boolean.TRUE);
            edit.commit();
            fragPantallaTutorial popup = new fragPantallaTutorial(9);
            popup.show(getSupportFragmentManager(),"DialogFrag");
        }*/
    }



}