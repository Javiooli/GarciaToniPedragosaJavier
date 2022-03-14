package prog2.model;

public class Pista {
    private String nom;
    private String color;
    private float longitud;
    private String estatNeu;
    private String estatPista;
    private LlistaRemuntadors dependencies;

    /**
     * @param nom name of this trail
     * @param color colour assigned to the difficulty of this trail
     * @param longitud length of this trail
     * @param estatNeu the state of the snow in this trail
     * @param estatPista whether this trail is open or closed
     */
    Pista(String nom, String color, float longitud, String estatNeu, String estatPista) {
        this.nom = nom;
        this.color = color;
        this.longitud = Math.max(0, longitud);
        this.estatNeu = estatNeu;
        this.estatPista = estatPista;
        this.dependencies = new LlistaRemuntadors();
    }

    /**
     * @return the name of this trail
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @param nom the name for this trail
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the colour assigned to the difficulty of this trail
     */
    public String getColor() {
        return this.color;
    }

    /**
     * @param color the colour assigned to the difficulty for this trail
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the length of this trail
     */
    public float getLongitud() {
        return this.longitud;
    }

    /**
     * @param longitud the length for this trail
     */
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the state of the snow in this trail
     */
    public String getEstatNeu() {
        return this.estatNeu;
    }

    /**
     * @param estatNeu the state of the snow for this trail
     */
    public void setEstatNeu(String estatNeu) {
        if (estatNeu.equalsIgnoreCase("Pols") ||
            estatNeu.equalsIgnoreCase("Primavera") ||
            estatNeu.equalsIgnoreCase("Dura"))

            this.estatNeu = estatNeu;
    }

    /**
     * @return whether this trail is open or closed
     */
    public String getEstatPista() {
        return this.estatPista;
    }

    /**
     * @param estatPista whether this trail is open or closed
     */
    public void setEstatPista(String estatPista) {
        if (estatPista.equals("Oberta") || estatPista.equals("Tancada"))
            this.estatPista = estatPista;
    }

    //Updates the state of this trail depending on whether the lifters it depends on are open or closed
    public void actualitzaEstat(){
        if (dependencies.totsForaDeServei()) {
            this.setEstatPista("Tancada");
        } else {
            this.setEstatPista("Oberta");
        }
    }

    /**
     * @return Strin with all the info about this trail
     */
    public String toString() {
        return "\tPista: " + this.nom + ", Color: " + this.color + ", Longitud: " +
        longitud + "Km, Estat de la neu: " + estatNeu + ", Estat de la pista: " +
        estatPista + ", Dependències: " + dependencies.getNoms();
    }

    /**
     * @param rm the lifter we want to add to the list of dependencies of this trail
     */
    public void afegirDependencia(Remuntador rm) {
        if (rm != null) dependencies.afegirRemuntador(rm);
    }

}


