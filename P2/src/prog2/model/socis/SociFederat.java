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
    private Federacio federacio;

    public SociFederat(String nom, String dni, Federacio federacio) {
        super(nom, dni);
        this.federacio = federacio;
        
    }

    public String tipus(){
        return "federat";
    }

    @Override
    public String toString() {
        String soci = super.toString();
        return soci + ", Federació: " + federacio.getNom() + ", Preu: " + federacio.getPreu();
    }

    @Override
    public void comprova() throws ExcepcioClub {
        super.comprova();
        if (this.federacio == null || this.federacio.getPreu() < 100)
            throw new ExcepcioClub("Federació no vàlida.");
    }
}
