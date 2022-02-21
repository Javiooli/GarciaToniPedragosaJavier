package prog2.model;

public class Sector {
    
    private String nom;
    private LlistaPistes llistaPistes;
    private LlistaRemuntadors llistaRemuntadors;
    private Meteo meteo;

    
    Sector(String nom, LlistaPistes llistaPistes,
    LlistaRemuntadors llistaRemuntadors, Meteo meteo) {
        this.nom = nom;
        this.llistaPistes = llistaPistes;
        this.llistaRemuntadors = llistaRemuntadors;
        this.meteo = meteo;
    }
    
    Sector(String nom, String visibilitat, float velocitatVent) {
        this.nom = nom;
        this.llistaPistes = new LlistaPistes();
        this.llistaRemuntadors = new LlistaRemuntadors();
        this.meteo = new Meteo(visibilitat, velocitatVent);
    }
    
    public Sector(String nomSector) {
        this.nom = nomSector;
        this.llistaPistes = new LlistaPistes();
        this.llistaRemuntadors = new LlistaRemuntadors();
        this.meteo = new Meteo();
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public LlistaPistes getLlistaPistes() {
        return this.llistaPistes;
    }

    public void setLlistaPistes(LlistaPistes llistaPistes) {
        this.llistaPistes = llistaPistes;
    }

    public LlistaRemuntadors getLlistaRemuntadors() {
        return this.llistaRemuntadors;
    }

    public void setLlistaRemuntadors(LlistaRemuntadors llistaRemuntadors) {
        this.llistaRemuntadors = llistaRemuntadors;
    }

    public Meteo getMeteo() {
        return this.meteo;
    }

    public void setMeteo(Meteo meteo) {
        this.meteo = meteo;
    }

    public boolean setVelocitatVent(float velocitatVent) {
        return this.meteo.setVelocitatVent(velocitatVent);
    }

    public boolean setVisibilitat(String visibilitat) {
        return this.meteo.setVisibilitat(visibilitat);
    }

    public String llistarPistes(String estat) {
        return llistaPistes.llistarPistes(estat);
    }

    public String llistarRemuntadors(String estat) {
        return llistaRemuntadors.llistarRemuntadors(estat);
    }

    //public void actualitzaEstat();

    public float calculaKmsPistes(String estat) {
        return llistaPistes.calculaKmsPistes(estat);
    }

    public void reportMeteo() {
        System.out.println("El temps al sector " + this.nom +
            ":\n La velocitat del vent és de " + meteo.getVelocitatVent() +
            " Km/h, i la visibilitat és " + meteo.getVisibilitat().toLowerCase() +
            ".\n");
    }

}
