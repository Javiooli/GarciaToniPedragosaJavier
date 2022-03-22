/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.socis;

import prog2.model.socis.SociEstandar;

public class SociJunior extends SociEstandar {
    private int _diaNaixement;
    private int _mesNaixement;
    private int _anyNaixement;


    public SociJunior(String nom, String dni, String tipusAsseguranca, int[] data) {
        super(nom, dni, tipusAsseguranca);
        this._diaNaixement = data[0];
        this._mesNaixement = data[1];
        this._anyNaixement = data[2];
    }

    public String tipus(){
        return "junior";
    }

    @Override
    public String toString() {
        String soci = super.toString();
        soci += ", Data de naixement: " + _diaNaixement + "/" + _mesNaixement + "/" + _anyNaixement;
        return soci;
    }



}
