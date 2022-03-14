package prog2.model;

import java.util.ArrayList;

public class LlistaPistes {

    private ArrayList<Pista> llista = new ArrayList<>();
    
    //Updates the state of all the trails inside this list
    public void actualitzaEstat(){
        for (Pista pista : llista) {
            pista.actualitzaEstat();
        }
    }

    /**
     * @param nom name of the Pista object (trail) we want to get returned
     * @return Pista object with the same name we entered via parameter
     */
    public Pista getPista(String nom) {
        if (!this.llista.isEmpty()) {
            for (Pista pista : llista) {
                if (pista.getNom().equalsIgnoreCase(nom))
                    return pista;
            }
        }
        return null;
    }

    /**
     * @param p Pista object (trail) we want to add to this list
     */
    public void afegirPista (Pista p) {
        if (p != null) this.llista.add(p);
    }

    //Empties this list
    public void buidar() {
        this.llista = new ArrayList<>();
    }

    /**
     * @param estat the state of the trails we want to get listed
     * @return String with the list of the trails and their info which are in the state entered via parameter
     */
    public String llistarPistes(String estat) {
        int pistesAfegides = 0;
        if (this.llista.isEmpty()) return "No hi ha cap pista a la llista.\n";

        estat = estat.toLowerCase();
        estat = estat.substring(0, 1).toUpperCase() + estat.substring(1);

        if (!estat.equals("Oberta") && !estat.equals("Tancada") && !estat.equals("Tots"))
            return "Estat introduït no vàlid\n";

        StringBuilder llistaPistes = new StringBuilder();

        if (!estat.equals("Tots")) {

            for (Pista pista : llista) {

                if (pista.getEstatPista().equals(estat)) {
                    llistaPistes.append(pista.toString() + "\n");
                    pistesAfegides++;
                }
            }

        } else {

            for (Pista pista : llista) {
                llistaPistes.append(pista.toString() + "\n");
                pistesAfegides++;
            }
        }

        return (pistesAfegides == 0 ? "No hi ha cap pista a la llista\n\n" : llistaPistes.toString());
    }

    /**
     * @param estat the state of the trails we want to calculate the total length of
     * @return the total length of the trails in the state we entered via parameter
     */
    public float calculaKmsPistes(String estat) {

        if (this.llista.isEmpty() || (!estat.equalsIgnoreCase("Oberta") && !estat.equalsIgnoreCase("Tancada")
            && !estat.equalsIgnoreCase("Tots"))) return -1;

        float kmsPistes = 0;

        if (!estat.equalsIgnoreCase("Tots")) {

            for (Pista pista : llista) {

                if (pista.getEstatPista().equalsIgnoreCase(estat))
                    kmsPistes += pista.getLongitud();
            }

        } else {

            for (Pista pista : llista) {
                kmsPistes += pista.getLongitud();
            }
        }

        return kmsPistes;
    }
}
