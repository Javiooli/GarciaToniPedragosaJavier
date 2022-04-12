/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.socis;
import prog2.model.atributs.Asseguranca;
import prog2.vista.ExcepcioClub;

public class SociJunior extends SociEstandar{
    private int _diaNaixement;
    private int _mesNaixement;
    private int _anyNaixement;


    public SociJunior(String nom, String dni, Asseguranca as, int[] data) {
        super(nom, dni, as);
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
        soci += ", Data de naixement: " + (_diaNaixement % 10 == _diaNaixement ? "0" + _diaNaixement : _diaNaixement) + "/" +
            (_mesNaixement % 10 == _mesNaixement ? "0" + _mesNaixement : _mesNaixement) + "/" + _anyNaixement;
        return soci;
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return 0;
    }


}
