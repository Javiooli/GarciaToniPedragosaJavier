package prog2.model;

public abstract class Remuntador {

    private String nom;
    private float limitVent;
    private boolean estat;
    private boolean susceptibleVisib;
    
    //Default constructor
    Remuntador() {
        this.nom = "Sense nom";
        this.limitVent = 0;
        this.estat = false;
        this.susceptibleVisib = false;
    }

    /**
     * @param nom the name of this lifter
     * @param limitVent the wind speed limit for this lifter to stay open
     * @param estat the state of this lifter (open or closed)
     * @param susceptibleVisib whether if this lifter closes with bad visibility or not
     */
    Remuntador(String nom, float limitVent, boolean estat, boolean susceptibleVisib) {
        this.nom = nom;
        this.limitVent = Math.max(0, limitVent);
        this.estat = estat;
        this.susceptibleVisib = susceptibleVisib;
    }

    /**
     * @return the name of this lifter
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @param nom the name for this lifter
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the wind speed limit for this lifter to stay open
     */
    public float getLimitVent() {
        return this.limitVent;
    }
    
    /**
     * @param limitVent the wind speed limit we want to assign to this lifter
     * @return true if the operation has been successful, false if not
     */
    public boolean setLimitVent(float limitVent) {
        if (limitVent <= 0) return false;
        else {
            this.limitVent = limitVent;
            return true;
        }
    }

    /**
     * @return true if this lifter is open, false if closed
     */
    public boolean getEstat() {
        return this.estat;
    }

    /**
     * @param estat the state of this lifter
     */
    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    /**
     * @return "En servei" if estat == true, "Fora de servei" otherwise
     */
    public String estatToString(){
        return (this.estat) ? "En servei" : "Fora de servei";
    }

    /**
     * @return whether this lifter closes when visibility turns bad or not
     */
    public boolean getSusceptibleVisib() {
        return this.susceptibleVisib;
    }

    /**
     * @param susceptibleVisib whether this lifter closes when visibility turns bad or not
     */
    public void setSusceptibleVisib(boolean susceptibleVisib) {
        this.susceptibleVisib = susceptibleVisib;
    }

    /**
     * @return the type of this lifter
     */
    public abstract String tipus();

    /**
     * @param meteo the Meteo object which contains the meteorologic conditions of the sector this lifter is in
     */
    public void actualitzaEstat(Meteo meteo){
        if (meteo.getVelocitatVent() >= this.getLimitVent() ||
        (this.getSusceptibleVisib() && meteo.getVisibilitat().equalsIgnoreCase("Dolenta")))
            this.setEstat(false);

        else
            this.setEstat(true);
    }

    public String toString() {
        return "\tRemuntador: " + nom + ", Tipus: " + tipus() +
                ", Estat: " + estatToString() + ".";
    }
}
