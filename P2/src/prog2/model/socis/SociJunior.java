/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.socis;

import prog2.model.abstracts.Soci;

public class SociJunior extends Soci {
    private int _diaNaixement;
    private int _mesNaixement;
    private int _anyNaixement;


    public SociJunior(String nom, String dni) {
        super(nom, dni);
        //TODO Auto-generated constructor stub
    }

    public String tipus(){
        return "junior";
    }



}
