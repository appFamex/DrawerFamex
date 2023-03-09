package com.example.drawerfamex.pantallas.prefamex;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;

import com.example.drawerfamex.R;

public class fragPopUpPasabus extends DialogFragment {

    private ImageView Imagen, Imagen2, txtclose;
    private TextView nombre;
    private TextView txtslogan, txtDescr;
    private TextView txtclose1;

    private String linkpasabus = "https://play.google.com/store/apps/details?id=mx.jetty.spsc";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.aan_14_popup_pasabus, container, false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        LinearLayout linearL;
        linearL = view.findViewById(R.id.lltfondopopexpoest);
        Imagen = (ImageView) view.findViewById(R.id.imgPasaBus);
        Imagen2 = (ImageView) view.findViewById(R.id.pasabusIcon);
        nombre = (TextView) view.findViewById(R.id.txtTransport);
        txtslogan = (TextView) view.findViewById(R.id.pfmx_pas_1_pop_1_txt_PasaBus);
        txtDescr = (TextView) view.findViewById(R.id.pfmx_pas_1_pop_2_txt_PasaBus);
        //descripcion = (TextView) view.findViewById(R.id.txtdesc);
        txtclose =  (ImageView) view.findViewById(R.id.closeIc);
        txtclose1 = (TextView) view.findViewById(R.id.textclose2);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        Imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri Link = Uri.parse(linkpasabus);
                Intent i = new Intent(Intent.ACTION_VIEW,Link);
                startActivity(i);
            }
        });

        txtclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return view;
    }
}
