/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.abstracts;

import prog2.vista.ExcepcioClub;

/**
 * 
 */
public abstract class Soci implements InSoci {

    private String _nom;
    private String _dni;

    @Override
    public void setNom(String nom) {
        try {
            this._nom = nom;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public String getNom() {
        return this._nom;
    }

    @Override
    public void setDNI(String dni) {
        char[] lletres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        dni = dni.toUpperCase();
        char lletraNIF = dni.charAt(dni.length() - 1);
        int cadenaNIF = Integer.parseInt(dni.substring(0, dni.length() - 2));
        if (lletraNIF == lletres[cadenaNIF%23]) {
            System.out.println("DNI definit :" + dni + ".");
            this._dni = dni;
        } else {
            System.out.println("DNI invàlid.");
        }
    }

    @Override
    public String getDNI() {
        return this._dni;
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return preuExcursioBase;
    }

    @Override
    public void comprova() throws ExcepcioClub {
        throw new ExcepcioClub();
        
    }
    
}
