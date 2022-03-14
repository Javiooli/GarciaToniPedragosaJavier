package prog2.model;

public class Sector {
    
    private String nom;
    private LlistaPistes llistaPistes;
    private LlistaRemuntadors llistaRemuntadors;
    private Meteo meteo;


    //Default constructor
    public Sector() {
        this.nom = "Sense nom";
        this.llistaPistes = new LlistaPistes();
        this.llistaRemuntadors = new LlistaRemuntadors();
        this.meteo = new Meteo();
    }

    /**
     * @param nom the name of this sector
     * @param llistaPistes the list of trails of this sector
     * @param llistaRemuntadors the list of lifters of this sector
     * @param meteo the Meteo object we want to assign to this sector
     */
    Sector(String nom, LlistaPistes llistaPistes, LlistaRemuntadors llistaRemuntadors, Meteo meteo) {
        this.nom = nom;
        this.llistaPistes = llistaPistes;
        this.llistaRemuntadors = llistaRemuntadors;
        this.meteo = meteo;
    }
    
    /**
     * @param nom the name of this sector
     * @param visibilitat the visibility conditions of this sector
     * @param velocitatVent the wind speed in this sector
     */
    Sector(String nom, String visibilitat, float velocitatVent) {
        this.nom = nom;
        this.llistaPistes = new LlistaPistes();
        this.llistaRemuntadors = new LlistaRemuntadors();
        this.meteo = new Meteo(visibilitat, velocitatVent);
    }
    
    /**
     * @param nom the name of this sector
     */
    public Sector(String nom) {
        this.nom = nom;
        this.llistaPistes = new LlistaPistes();
        this.llistaRemuntadors = new LlistaRemuntadors();
        this.meteo = new Meteo();
    }
    
    /**
     * @return the name of this sector
     */
    public String getNom() {
        return this.nom;
    }
    
    /**
     * @param nom the name for this sector
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * @return the list of trails in this sector
     */
    public LlistaPistes getLlistaPistes() {
        return this.llistaPistes;
    }

    /**
     * @param llistaPistes the list of trails for this sector
     */
    public void setLlistaPistes(LlistaPistes llistaPistes) {
        this.llistaPistes = llistaPistes;
    }

    /**
     * @return the list of lifters in this sector
     */
    public LlistaRemuntadors getLlistaRemuntadors() {
        return this.llistaRemuntadors;
    }

    /**
     * @param llistaRemuntadors the list of lifters for this sector
     */
    public void setLlistaRemuntadors(LlistaRemuntadors llistaRemuntadors) {
        this.llistaRemuntadors = llistaRemuntadors;
    }

    /**
     * @return the Meteo object assigned to this sector
     */
    public Meteo getMeteo() {
        return this.meteo;
    }

    /**
     * @param meteo a Meteo object to assign to this sector
     */
    public void setMeteo(Meteo meteo) {
        this.meteo = meteo;
    }

    /**
     * @param velocitatVent new wind speed to assign to the Meteo object of this sector
     * @return true if the operation has been successful, false if not
     */
    public boolean setVelocitatVent(float velocitatVent) {
        boolean ok;
        ok = this.meteo.setVelocitatVent(velocitatVent);
        this.actualitzaEstat();
        return ok;
    }

    /**
     * @param visibilitat new visibility conditions to assign to the Meteo object of this sector
     * @return true if the operation has been successful, false if not
     */
    public boolean setVisibilitat(String visibilitat) {
        boolean ok;
        ok = this.meteo.setVisibilitat(visibilitat);
        this.actualitzaEstat();
        return ok;
    }

    /**
     * @param estat state of the trails we want to get printed
     * @return the string with the list of trails in the state we introduced via parameter
     */
    public String llistarPistes(String estat) {
        return llistaPistes.llistarPistes(estat);
    }

    /**
     * @param estat state of the lifters we want to get printed
     * @return the string with the list of lifters in the state we introduced via parameter
     */
    public String llistarRemuntadors(String estat) {
        return llistaRemuntadors.llistarRemuntadors(estat);
    }

    /**
     * Updates the state of the lifters and the trails of this sector
     */
    public void actualitzaEstat(){
        this.llistaRemuntadors.actualitzaEstat(meteo);
        this.llistaPistes.actualitzaEstat();
        
    }

    /**
     * @param estat state of the trails we want to get the total length of
     * @return the total length of the trails in the state we enterd via parameter
     */
    public float calculaKmsPistes(String estat) {
        return llistaPistes.calculaKmsPistes(estat);
    }

    /**
     * Prints the meteorologic conditions (wind speed and visibility) of this sector
     */
    public void reportMeteo() {
        System.out.println("El temps al sector " + this.nom +
            ":\n La velocitat del vent és de " + meteo.getVelocitatVent() +
            " Km/h, i la visibilitat és " + meteo.getVisibilitat().toLowerCase() +
            ".\n");
    }

}
