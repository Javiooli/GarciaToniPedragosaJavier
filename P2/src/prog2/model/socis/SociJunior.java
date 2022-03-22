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


    public SociJunior(String nom, String dni, String tipusAsseguranca) {
        super(nom, dni, tipusAsseguranca);
        //TODO Auto-generated constructor stub
    }

    public String tipus(){
        return "junior";
    }



}
