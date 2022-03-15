package prog2.model;

import java.util.ArrayList;

public class LlistaRemuntadors {

    private ArrayList<Remuntador> llista = new ArrayList<>();  

    /**
     * @param rm the lifter object we want to add to this list
     */
    public void afegirRemuntador (Remuntador rm) {
        if (rm != null) this.llista.add(rm);
    }

    //Empties this list
    public void buidar() {
        this.llista = new ArrayList<>();
    }

    //Returns true if all lifters inside this list are closed, false otherwise
    public boolean totsForaDeServei() {
        if (this.llista.isEmpty()) return true;

        for (int i = 0; i < this.llista.size(); i++) {

            if (this.llista.get(i).getEstat()) return false;
        }

        return true;
    }

    /**
     * @param estat the state of the lifters we want to list
     * @return String with the list of lifters and their info in the state we entered via parameter
     */
    public String llistarRemuntadors(String estat) {
        if (this.llista.isEmpty()) return "No hi ha cap remuntador a la llista.\n";

        estat = estat.toLowerCase();
        estat = estat.substring(0, 1).toUpperCase() + estat.substring(1);

        if (!estat.equals("En servei") && !estat.equals("Fora de servei") &&
            !estat.equals("Tots")) return "Estat introduït no vàlid\n";

        StringBuilder llistaRemunt = new StringBuilder();

        if (!estat.equals("Tots")) {

            for (Remuntador remunt : llista) {
                if (remunt.estatToString().equals(estat))
                    llistaRemunt.append(remunt.toString() + "\n");
            }

        } else {

            for (Remuntador remunt : llista) {
                llistaRemunt.append(remunt.toString() + "\n");
            }
        }

        return (llistaRemunt.toString().isEmpty() ? "No hi ha cap remuntador a la llista.\n" : llistaRemunt.toString());
    }

    /**
     * @param meteo the Meteo object with the meteorologic conditions of the sector this list belongs to
     */
    public void actualitzaEstat(Meteo meteo){
        for (Remuntador remunt : llista) {
            remunt.actualitzaEstat(meteo);
        }
    }

    /**
     * @return String with the names of all lifters inside this list
     */
    public String getNoms() {
        if (this.llista.isEmpty()) return "No hi ha cap remuntador a la llista.\n";
        StringBuilder llistaRemunt = new StringBuilder();

        for (int i = 0; i < this.llista.size(); i++) {
            if (i != this.llista.size() -1) llistaRemunt.append(this.llista.get(i).getNom() + ", ");
            else llistaRemunt.append(this.llista.get(i).getNom());
        }

        return llistaRemunt.toString();
    }
    
}
