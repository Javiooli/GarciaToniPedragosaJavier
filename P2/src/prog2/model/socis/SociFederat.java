/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.socis;

import prog2.model.abstracts.Soci;
import prog2.model.atributs.Federacio;
import prog2.vista.ExcepcioClub;

public class SociFederat extends Soci {
    public SociFederat(String nom, String dni) {
        super(nom, dni);
        //TODO Auto-generated constructor stub
    }

    private Federacio federacio;

    @Override
    public String toString() {
        String soci = super.toString();
        return soci + ", Federació: " + federacio.getNom();
    }

    @Override
    public void comprova() throws ExcepcioClub {
        if (this.federacio.getPreu() > 100)
            throw new ExcepcioClub("Federació no vàlida.");
    }
}
