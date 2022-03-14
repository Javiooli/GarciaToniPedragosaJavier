package prog2.model;

public class Meteo {
    private String visibilitat;
    private float velocitatVent;

    /**
     * @param visibilitat visibility conditions of the sector this Meteo object is assigned to
     * @param velocitatVent wind speed in the sector this Meteo object is assigned to
     */
    Meteo(String visibilitat, float velocitatVent) {
        visibilitat = visibilitat.toLowerCase();
        visibilitat = visibilitat.substring(0, 1).toUpperCase() + visibilitat.substring(1);

        this.visibilitat = ("Bona".equals(visibilitat) || "Dolenta".equals(visibilitat)) ? visibilitat : "No definida";

        this.velocitatVent = Math.max(0, velocitatVent);
    }

    //Default constructor
    Meteo() {
        this.visibilitat = "Bona";
        this.velocitatVent = 0;
    }

    /**
     * @return the visibility conditions of the sector this Meteo object is assigned to
     */
    public String getVisibilitat() {
        return this.visibilitat;
    }

    /**
     * @param visibilitat the visibility conditions we want to set to the sector this Meteo object is assigned to
     * @return true if the operation has been successful, false otherwise
     */
    public boolean setVisibilitat(String visibilitat) {
        visibilitat = visibilitat.toLowerCase();
        visibilitat = visibilitat.substring(0, 1).toUpperCase() +
                                        visibilitat.substring(1);

        if (!"Bona".equals(visibilitat) && !"Dolenta".equals(visibilitat)) return false;
        else {
            this.visibilitat = visibilitat;
            return true;
        }
    }

    /**
     * @return the wind speed in the sector this Meteo object is assigned to
     */
    public float getVelocitatVent() {
        return this.velocitatVent;
    }

    /**
     * @param velocitatVent the wind speed we want to set to the sector this Meteo object is assigned to
     * @return true if the operation has been sucessful, false otherwise
     */
    public boolean setVelocitatVent(float velocitatVent) {
        if (velocitatVent <= 0) return false;
        else {
            this.velocitatVent = velocitatVent;
            return true;
        }
    }

}
