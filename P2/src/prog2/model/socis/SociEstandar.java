/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.socis;

import prog2.model.abstracts.Soci;
import prog2.model.atributs.Asseguranca;
import prog2.vista.ExcepcioClub;

public class SociEstandar extends Soci {
    private Asseguranca asseguranca;

    public SociEstandar(String nom, String dni, String tipusAsseguranca) {
        super(nom, dni);
        asseguranca = new Asseguranca(tipusAsseguranca);
    }

    @Override
    public String toString() {
        String soci = super.toString();
        return soci + ", Assegurança: " + asseguranca.getTipus();
    }

    public String tipus(){
        return "estandar";
    }

    @Override
    public void comprova() throws ExcepcioClub {
        if (!this.asseguranca.getTipus().equals("Bàsica") && !this.asseguranca.getTipus().equals("Completa"))
            throw new ExcepcioClub("Tipus d'assegurança invàlida.");
    }
}
