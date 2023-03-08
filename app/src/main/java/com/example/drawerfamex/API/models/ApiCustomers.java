package com.example.drawerfamex.API.models;

import android.text.format.DateFormat;

public class ApiCustomers {

    //ACTUALIZAR
    private String idCustomer;
    //private String segment;
    //private String photo;

    //REGISTRO
    private Boolean newCustomer;//"true"
            //customer":
    private String segment; //"x",
    private String idUser; // "121212",
    private String userId; //"1212",
    private String firstName; //"Mauricio",
    private String lastName; //"Mendoza",
    private String motherMaidenName; //"Mendoza",
    private DateFormat birthDate; //"21/10/1997",
    private Boolean active; //true,
    private int idOccupation; // 1,
    private int idEconomicActivity; // "1",
    private String gender;// "H",
    private String expirationId; //"",
    private String numberId; // "",
    private String countryOfIssue; //"",
    private String nationality; //"MX",
    private String birthState; //"MX",
    private String photo;// "",
            //emails;
       private String idEmail; //"",
    private String email; //"mauricio.mendoza@adira.com.mx"
///GETTERS Y SETTERS
    public Boolean getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Boolean newCustomer) {
        this.newCustomer = newCustomer;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public DateFormat getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateFormat birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getIdOccupation() {
        return idOccupation;
    }

    public void setIdOccupation(int idOccupation) {
        this.idOccupation = idOccupation;
    }

    public int getIdEconomicActivity() {
        return idEconomicActivity;
    }

    public void setIdEconomicActivity(int idEconomicActivity) {
        this.idEconomicActivity = idEconomicActivity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExpirationId() {
        return expirationId;
    }

    public void setExpirationId(String expirationId) {
        this.expirationId = expirationId;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
