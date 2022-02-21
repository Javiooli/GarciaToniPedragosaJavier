package prog2.model;

public class Meteo {
    private String visibilitat;
    private float velocitatVent;

    Meteo(String visibilitat, float velocitatVent) {
        visibilitat = visibilitat.toLowerCase();
        visibilitat = visibilitat.substring(0, 1).toUpperCase() +
                                        visibilitat.substring(1);

        this.visibilitat = ("Bona".equals(visibilitat) ||
                    "Dolenta".equals(visibilitat)) ? visibilitat : "No definida";

        this.velocitatVent = Math.max(0, velocitatVent);
    }

    Meteo() {
        this.visibilitat = "Bona";
        this.velocitatVent = 0;
    }

    public String getVisibilitat() {
        return this.visibilitat;
    }

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

    public float getVelocitatVent() {
        return this.velocitatVent;
    }

    public boolean setVelocitatVent(float velocitatVent) {
        if (velocitatVent <= 0) return false;
        else {
            this.velocitatVent = velocitatVent;
            return true;
        }
    }

}
