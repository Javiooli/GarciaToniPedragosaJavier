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

    public Soci(String nom, String dni) {
        setNom(nom);
        setDNI(dni);
    }

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


    /**
     * TODO: Proteger el DNI utilizando el algoritmo que hicimos en algorísmica (en el comprovar()):
     * char[] lletres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        dni = dni.toUpperCase();
        char lletraNIF = dni.charAt(dni.length() - 1);
        int cadenaNIF = Integer.parseInt(dni.substring(0, dni.length() - 2));
        if (!lletraNIF == lletres[cadenaNIF%23]) throw new ExcepcioClub("DNI invàlid.");
     */
    @Override
    public void setDNI(String dni) {
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
        
    }

    //TODO
    public String toString() {
        String soci = "Nom: " + _nom + ", DNI: " + _dni;
        return soci;
    }
    
}
