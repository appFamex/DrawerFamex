package com.example.drawerfamex.BaseDatos.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.drawerfamex.BaseDatos.daos.fichasCustomersDao;

import com.example.drawerfamex.BaseDatos.db.AppDatabase;
import com.example.drawerfamex.BaseDatos.entidades.fichaCustomers;

import com.example.drawerfamex.adapters.BasicImageDownloader;

//com.example.drawerfamex.BaseDatos.daos.fichasCustomersDao fichasCustomersDao;

import java.util.List;

public class FichasCustomerRep {

    fichasCustomersDao fichasCustomersDao;

    

    public interface OnFichaSaveListener {
        void onFichaSaved();
    }

    public FichasCustomerRep(Application application) {
        AppDatabase db = AppDatabase.getDataBase(application);
        fichasCustomersDao = db.fichasCustomersDao();
    }

    /*public LiveData<List<fichaCustomers>> getFichas(){
        return fichasCustomersDao.getAll();
    }

    public void insertFicha(fichaCustomers fichaCustomers, @NonNull final FichasCustomerRep.OnFichaSaveListener listener){

        new FichasCustomerRep.InsertAsyncTask(fichasCustomersDao, (FichasCustomerRep.OnFichaSaveListener) listener).execute(fichaCustomers);

    }*/


    public LiveData<List<fichaCustomers>> getFichas(){
        return fichasCustomersDao.getAll();
    }

    public void insertFicha(fichaCustomers fichaCustomers, @NonNull final FichasCustomerRep.OnFichaSaveListener listener){

        new FichasCustomerRep.InsertAsyncTask(fichasCustomersDao, listener).execute(fichaCustomers);

    }

    private static class InsertAsyncTask extends AsyncTask<fichaCustomers, Void ,Void> {
        private fichasCustomersDao taskDao;
        private FichasCustomerRep.OnFichaSaveListener evento;

        InsertAsyncTask(fichasCustomersDao fichasCustomersDao, FichasCustomerRep.OnFichaSaveListener listener){
            BasicImageDownloader.FICHAS++;
            taskDao = fichasCustomersDao;
            evento = listener;

        }

        @Override
        protected Void doInBackground(fichaCustomers... fichaCustomerss) {

            taskDao.insertAll(fichaCustomerss[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            BasicImageDownloader.FICHAS--;
            evento.onFichaSaved();
        }
    }

}
