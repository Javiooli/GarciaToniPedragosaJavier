package prog2.model.atributs;

import java.io.Serializable;

public class Federacio implements Serializable{
    private float _preu;
    private String _nom;

    public Federacio(String nom, float preu) {
        this._nom = nom;
        this._preu = preu;
    }


    public String getNom() {
        return this._nom;
    }

    public float getPreu() {
        return this._preu;
    }
}
