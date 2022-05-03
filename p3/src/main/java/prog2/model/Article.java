package main.java.prog2.model;

public class Article {
    
    private String id;
    private String nom;
    private float preu;
    private boolean urgent;
    private float temps;

    public Article() {}
    public article(String nom, float preu, boolean urgent, float temps) {
        this.nom = nom;
        this.preu = preu;
        this.urgent = urgent;
        this.temps = temps;
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
        return this.urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public float getTemps() {
        return this.temps;
    }

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public String toString() {
        return "ID=" + id + ", Nom=" + nom + ", Preu=" + preu +
            ", Temps fins enviament=" + temps + ", Enviament Urgent=" + urgent;
    }

}
