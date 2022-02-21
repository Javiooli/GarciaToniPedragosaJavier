package prog2.model;

public class Meteo {
    private String visibilitat;
    private int velocitatVent;

    public String getVisibilitat() {
        return this.visibilitat;
    }

    public boolean setVisibilitat(String visibilitat) {
        visibilitat = visibilitat.toLowerCase();
        visibilitat = visibilitat.substring(0, 1).toUpperCase() + visibilitat.substring(1);

        if (!"Bona".equals(visibilitat) || !"Dolenta".equals(visibilitat)) return false;
        else {
            this.visibilitat = visibilitat;
            return true;
        }
    }

    public int getVelocitatVent() {
        return this.velocitatVent;
    }

    public boolean setVelocitatVent(int velocitatVent) {
        if (velocitatVent <= 0) return false;
        else {
            this.velocitatVent = velocitatVent;
            return true;
        }
    }

}
