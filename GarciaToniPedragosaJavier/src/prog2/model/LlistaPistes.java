package prog2.model;

import java.util.ArrayList;

public class LlistaPistes {

    private ArrayList<Pista> llista = new ArrayList<>();

    //TODO: actualitzaEstat();
    //public void actualitzaEstat();

    public Pista getPista (String nom) {
        if (!this.llista.isEmpty()) {
            for (int i = 0; i < this.llista.size(); i++) {
                if (this.llista.get(i).getNom().toLowerCase().equals(nom.toLowerCase()))
                    return this.llista.get(i);
            }
        }
        return null;
    }

    public void afegirPista (Pista p) {
        if (p != null) this.llista.add(p);
    }

    public void buidar() {
        this.llista = new ArrayList<>();
    }

    public String llistarPistes(String estat) {
        if (this.llista.isEmpty()) return "No hi ha cap pista a la llista.\n";

        estat = estat.toLowerCase();
        estat = estat.substring(0, 1).toUpperCase() + estat.substring(1);

        if (!estat.equals("Oberta") && !estat.equals("Tancada") &&
            !estat.equals("Tots")) return "Estat introduït no vàlid\n";

        StringBuilder llistaPistes = new StringBuilder();

        if (!estat.equals("Tots")) {

            for (int i = 0; i < this.llista.size(); i++) {

                if (this.llista.get(i).getEstatPista().equals(estat))
                    llistaPistes.append(this.llista.get(i).toString() + "\n");
            }

        } else {

            for (int i = 0; i < this.llista.size(); i++) {
                llistaPistes.append(this.llista.get(i).toString() + "\n");
            }
        }

        return llistaPistes.toString();
    }

    public float calculaKmsPistes(String estat) {

        estat = estat.toLowerCase();
        estat = estat.substring(0, 1).toUpperCase() + estat.substring(1);

        if (this.llista.isEmpty() || (!estat.equals("Oberta") && !estat.equals("Tancada")
            && !estat.equals("Tots"))) return -1;

        float kmsPistes = 0;

        if (!estat.equals("Tots")) {

            for (int i = 0; i < this.llista.size(); i++) {

                if (this.llista.get(i).getEstatPista().equals(estat))
                    kmsPistes += this.llista.get(i).getLongitud();
            }

        } else {

            for (int i = 0; i < this.llista.size(); i++) {
                kmsPistes += this.llista.get(i).getLongitud();
            }
        }

        return kmsPistes;
    }
}
