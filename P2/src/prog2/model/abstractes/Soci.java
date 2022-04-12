/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.abstractes;

import prog2.vista.ExcepcioClub;

/**
 * 
 */
public abstract class Soci implements InSoci {

    private String _nom;
    private String _dni;

    public Soci(String nom, String dni) {
        setNom(nom);
        this._dni = dni;
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

    @Override
    public void setDNI(String dni) {
        String ogDNI = "Undefined";
        if (this._dni != null)
            ogDNI = this._dni;
        this._dni = dni;
        try {
            comprovarDNI();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
            this._dni = ogDNI;
        }
    }

    @Override
    public String getDNI() {
        return this._dni;
    }

    @Override
    public void comprova() throws ExcepcioClub {
        comprovarDNI();
    }
    
    public String toString() {
        String soci = "Nom: " + _nom + ", DNI: " + _dni;
        return soci;
    }

    private void comprovarDNI() throws ExcepcioClub {
        char[] lletres = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        this._dni = this._dni.toUpperCase();
        char lletraNIF = this._dni.charAt(this._dni.length() - 1);
        int cadenaNIF = Integer.parseInt(this._dni.substring(0, this._dni.length() - 1));
        if (lletraNIF != lletres[cadenaNIF%23]) throw new ExcepcioClub("DNI invàlid.");
    }
    
}
