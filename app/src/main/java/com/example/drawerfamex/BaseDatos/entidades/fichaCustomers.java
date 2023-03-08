package com.example.drawerfamex.BaseDatos.entidades;

import android.text.format.DateFormat;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity
public class fichaCustomers {

        @PrimaryKey
        public int id;

        //ACTUALIZAR
        @ColumnInfo(name = "idCustomer")
        public String idCustomer;

        //REGISTRO
        @ColumnInfo(name = "newCustomer")
        public Boolean newCustomer;

        @ColumnInfo(name = "segment")
        public String segment;

        @ColumnInfo(name = "idUser")
        public String idUser;

        @ColumnInfo(name = "userId")
        public String userId;

        @ColumnInfo(name = "firstName")
        public String firstName;

        @ColumnInfo(name = "lastName")
        public String lastName;

        @ColumnInfo(name = "motherMaidenName")
        public String motherMaidenName;

        @ColumnInfo(name = "birthDate")
        public String birthDate;

        @ColumnInfo(name = "active")
        public Boolean active;

        @ColumnInfo(name = "idOccupation")
        public int idOccupation;

        @ColumnInfo(name = "idEconomicActivity")
        public int idEconomicActivity;

        @ColumnInfo(name = "gender")
        public String gender;

        @ColumnInfo(name = "expirationId")
        public String expirationId;

        @ColumnInfo(name = "numberId")
        public String numberId;

        @ColumnInfo(name = "countryOfIssue")
        public String countryOfIssue;

        @ColumnInfo(name = "nationality")
        public String nationality;

        @ColumnInfo(name = "birthState")
        public String birthState;

        @ColumnInfo(name = "photo")
        public String photo;

        @ColumnInfo(name = "idEmail")
        public String idEmail;

        @ColumnInfo(name = "email")
        public String email;



        public fichaCustomers(){

        }





    public fichaCustomers(int id, String idCustomer, Boolean newCustomer, String segment, String idUser, String firstName, String lastName, String motherMaidenName, String birthDate, Boolean active, int idOccupation, int idEconomicActivity, String gender, String expirationId, String numberId, String countryOfIssue, String nationality, String birthState, String photo) {
            this.id = id;
            this.idCustomer = idCustomer;
            this.newCustomer = newCustomer;
            this.segment = segment;
            this.idUser = idUser;
            this.firstName = firstName;
            this.lastName = lastName;
            this.motherMaidenName = motherMaidenName;
            this.birthDate = birthDate;
            this.active = active;
            this.idOccupation = idOccupation;
            this.idEconomicActivity = idEconomicActivity;
            this.gender = gender;
            this.expirationId = expirationId;
            this.numberId = numberId;
            this.countryOfIssue = countryOfIssue;
            this.nationality = nationality;
            this.birthState = birthState;
            this.photo = photo;
            this.idEmail = idEmail;
            this.email = email;

            //ACTUALIZAR



        }
    }

