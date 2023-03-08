package com.example.drawerfamex.API.models;



public class ApiFichaAnuncio {
    //@Setter    @Getter
    private int id;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String linkES;
    private String linkEN;
    private String linkFR;

    public String getLinkES() {
        return linkES;
    }

    public void setLinkES(String linkES) {
        this.linkES = linkES;
    }

    public String getLinkEN() {
        return linkEN;
    }

    public void setLinkEN(String linkEN) {
        this.linkEN = linkEN;
    }

    public String getLinkFR() {
        return linkFR;
    }

    public void setLinkFR(String linkFR) {
        this.linkFR = linkFR;
    }



   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagenEsp) {
        this.imagen1 = imagenEsp;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }
}
