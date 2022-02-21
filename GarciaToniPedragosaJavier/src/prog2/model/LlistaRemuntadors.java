package prog2.model;

import java.util.ArrayList;

public class LlistaRemuntadors {

    private ArrayList<Remuntador> llista = new ArrayList<>();

    //TODO: Definir actualitzaEstat().
    //public void actualitzaEstat(Meteo meteo);
    

    public void afegirRemuntador (Remuntador rm) {
        if (rm != null) this.llista.add(rm);
    }

    public void buidar() {
        this.llista = new ArrayList<>();
    }

    public boolean totsForaDeServei() {
        if (this.llista.isEmpty()) return true;

        for (int i = 0; i < this.llista.size(); i++) {

            if (this.llista.get(i).getEstat()) return false;
        }

        return true;
    }

    public String llistarRemuntadors(String estat) {
        if (this.llista.isEmpty()) return "No hi ha cap remuntador a la llista.\n";

        estat = estat.toLowerCase();
        estat = estat.substring(0, 1).toUpperCase() + estat.substring(1);

        if (!estat.equals("En servei") && !estat.equals("Fora de servei") &&
            !estat.equals("Tots")) return "Estat introduït no vàlid";

        StringBuilder llistaRemunt = new StringBuilder();

        if (!estat.equals("Tots")) {

            for (int i = 0; i < this.llista.size(); i++) {
                if (this.llista.get(i).estatToString().equals(estat))
                    llistaRemunt.append(this.llista.get(i).toString() + "\n");
            }

        } else {

            for (int i = 0; i < this.llista.size(); i++) {
                llistaRemunt.append(this.llista.get(i).toString() + "\n");
            }
        }

        return llistaRemunt.toString();
    }

    public String getNoms() {
        if (this.llista.isEmpty()) return "No hi ha cap remuntador a la llista.\n";
        StringBuilder llistaRemunt = new StringBuilder();

        for (int i = 0; i < this.llista.size(); i++) {
            if (i != this.llista.size() -1) llistaRemunt.append(this.llista.get(i).getNom() + ", ");
            else llistaRemunt.append(this.llista.get(i).getNom() + ".\n");
        }

        return llistaRemunt.toString();
    }
    
}
