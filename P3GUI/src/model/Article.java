package model;

import prog2.vista.MercatException;

public class Article {
    
    private String id;
    private String nom;
    private float preu;
    private float temps;
    private boolean admetUrgent;

    public Article() {}
    public Article(String id, String nom, float preu, float temps, boolean admetUrgent) throws MercatException {
        if (preu<0 || temps<0 )
            throw new MercatException("Els valors de preu i temps han de ser positius.");
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.temps = temps;
        this.admetUrgent = admetUrgent;
    }

    //Getters and Setters
    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return this.preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public boolean isUrgent() {
        return this.admetUrgent;
    }

    public void setUrgent(boolean urgent) {
        this.admetUrgent = urgent;
    }

    public float getTemps() {
        return this.temps;
    }

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public String toString() {
        return "ID = " + id + ", Nom = " + nom + ", Preu = " + preu +
            ", Temps fins enviament = " + temps + " minuts, Enviament Urgent = " + admetUrgent;
    }

}
