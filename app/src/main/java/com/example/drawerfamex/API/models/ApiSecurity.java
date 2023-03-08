package com.example.drawerfamex.API.models;

public class ApiSecurity {

    //update password
//"users":[
    private String password; //"Mexico.123"

    //  update_user
    //"users": [
    private String firstName; //"Eliezer Couoh",
    private String lastName; //"Morales"
//SETTERS Y GETTERS
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}