package com.example.drawerfamex.BaseDatos.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.drawerfamex.BaseDatos.entidades.fichaCustomers;
import com.example.drawerfamex.BaseDatos.entidades.fichaCustomers;
import com.example.drawerfamex.BaseDatos.repository.FichasCustomerRep;
import com.example.drawerfamex.BaseDatos.repository.FichasCustomerRep;

import java.util.List;

public class FichasCustomersVM extends AndroidViewModel {
    FichasCustomerRep repository;
    LiveData<List<fichaCustomers>> listaFichas;

    public interface OnFichaSaveListenerVM {
        void onFichaSavedVM();
    }

    public FichasCustomersVM(Application application) {
       super(application);
        repository = new FichasCustomerRep(application);
    }

    public void getFichas(){

        listaFichas = repository.getFichas();
    }

    public LiveData<List<fichaCustomers>> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(LiveData<List<fichaCustomers>> listaFichas) {
        this.listaFichas = listaFichas;
}

    public void insertFicha(fichaCustomers fichaCustomers, @NonNull final FichasInicioVM.OnFichaSaveListenerVM listenerVM){
        repository.insertFicha(fichaCustomers, new FichasCustomerRep.OnFichaSaveListener() {
            @Override
            public void onFichaSaved() {
                listenerVM.onFichaSavedVM();
            }
        });
    }
    
}
