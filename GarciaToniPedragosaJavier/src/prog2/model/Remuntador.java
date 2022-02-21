package prog2.model;

public abstract class Remuntador {

    private String nom;
    private float limitVent;
    private boolean estat;
    private boolean susceptibleVisib;

    Remuntador(String nom, float limitVent, boolean estat,
               boolean susceptibleVisib) {

        this.nom = nom;
        this.limitVent = Math.max(0, limitVent);
        this.estat = estat;
        this.susceptibleVisib = susceptibleVisib;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public float getLimitVent() {
        return this.limitVent;
    }
    
    public boolean setLimitVent(float limitVent) {
        if (limitVent <= 0) return false;
        else {
            this.limitVent = limitVent;
            return true;
        }
    }

    public boolean getEstat() {
        return this.estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public String estatToString(){
        return (this.estat) ? "En servei" : "Fora de servei";
    }

    public boolean getSusceptibleVisib() {
        return this.susceptibleVisib;
    }

    public void setSusceptibleVisib(boolean susceptibleVisib) {
        this.susceptibleVisib = susceptibleVisib;
    }

    public String tipus() {
        return this.getClass().getName();
    }

    //public void actualitzaEstat(Meteo meteo);

    public String toString() {
        return "Remuntador :" + nom + ", Tipus: " + tipus() +
                ", Estat: " + estatToString() + ".";
    }
}
