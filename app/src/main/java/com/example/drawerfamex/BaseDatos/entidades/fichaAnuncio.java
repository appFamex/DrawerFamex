package com.example.drawerfamex.BaseDatos.entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class fichaAnuncio {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "imagenEsp")
    public String imagen1;

    @ColumnInfo(name = "imagenEn")
    public String Imagen2;

    @ColumnInfo(name = "imagenFr")
    public String Imagen3;

    @ColumnInfo(name = "linkES")
    public String linkES;

    @ColumnInfo(name = "linkEN")
    public String linkEN;

    @ColumnInfo(name = "linkFR")
    public String linkFR;

    public fichaAnuncio(){

    }

    public fichaAnuncio(int id, String imagen1, String imagenEn, String imagen3,String linkES, String linkEN, String linkFR) {
        this.id = id;
        this.imagen1 = imagen1;
        Imagen2 = imagenEn;
        Imagen3 = imagen3;
        this.linkES = linkES;
        this.linkEN = linkEN;
        this.linkFR = linkFR;
    }
}
