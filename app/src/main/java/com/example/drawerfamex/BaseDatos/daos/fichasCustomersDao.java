package com.example.drawerfamex.BaseDatos.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.drawerfamex.BaseDatos.entidades.fichaCustomers;

import java.util.List;

@Dao
public interface fichasCustomersDao {

    //@Query("SELECT * FROM fichaCustomers")
    @Query("SELECT * FROM fichaCustomers")
    LiveData<List<fichaCustomers>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(fichaCustomers... fichaCustomers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOne(fichaCustomers fichaCustomers);



}
