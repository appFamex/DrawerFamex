package com.example.drawerfamex.pantallas.evento.chalets;

import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drawerfamex.BaseDatos.entidades.fichaPabellon;
import com.example.drawerfamex.BaseDatos.viewModel.FichasPabVieModel;
import com.example.drawerfamex.R;
import com.example.drawerfamex.adapters.pabellonAdapter;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.util.List;

public class FragChalPab extends Fragment {
    private int numero, idioma;
    private RecyclerView recyclerView;
    private pabellonAdapter adapter;
    private List<fichaPabellon> fichas;
    private ImageView imgLogo;
    private TextView fichatxt, txtId;
    private boolean francia = false;

//Francia

    public FragChalPab(int numero,boolean francia, int idioma){
        this.numero = numero;
        this.francia = francia;
        this.idioma = idioma;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FichasPabVieModel viewModel = ViewModelProviders.of(this).get(FichasPabVieModel.class);
        if(!francia){
            viewModel.getFichasPab(numero);
        }
        else{
            viewModel.getFichasPabF(numero, francia);

        }
        viewModel.getListaFichas().observe(this, lista -> {

            if(lista == null){
                return;
            }

            adapter.adicionarListaFichas(lista);
            fichas = lista;

        });

    }

    @Override
    public void onResume() {
        super.onResume();
        if(adapter != null && fichas != null){
            adapter.adicionarListaFichas(fichas);
        }

    }

    ///////////////No sirve
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.aah_8_chalpabfragment, container, false);

        //Controladores
        final ImageView imgFicha = view.findViewById(R.id.imgFRM1);
        //final  View scroll = view.findViewById(R.id.constraintLayout3);
        final  View constrainframe1 = view.findViewById(R.id.constraintFrame1A);
        final ImageView logo = view.findViewById(R.id.PAB_imgFicha);
        final TextView ID = view.findViewById(R.id.PAB_txt_itemSel);

        //Inicializar
        //scroll.setVisibility(View.VISIBLE);
        constrainframe1.setVisibility(View.VISIBLE);

        //Inicilizar
        final TextView txtFicha =view.findViewById(R.id.texto_pabellones);

        adapter = new pabellonAdapter(getContext(), numero, txtFicha, logo,ID,idioma);
        recyclerView = view.findViewById(R.id.recycler_pabellones);

        //Recycler View
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        return view;

    }
    ////////////////////////////////////

    private void getReference(){
    }
}
