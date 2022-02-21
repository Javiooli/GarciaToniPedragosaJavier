package prog2.model;

public class Pista {
    private String nom;
    private String color;
    private float longitud;
    private String estatNeu;
    private String estatPista;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getLongitud() {
        return this.longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
        //TODO
    }

    public String getEstatNeu() {
        return this.estatNeu;
    }

    public void setEstatNeu(String estatNeu) {
        this.estatNeu = estatNeu;
    }

    public String getEstatPista() {
        return this.estatPista;
    }

    public void setEstatPista(String estatPista) {
        this.estatPista = estatPista;
    }

}


