package prog2.model.atributs;

import java.io.Serializable;

public class Asseguranca implements Serializable{
    private String _tipus;
    private float _preu;

    public Asseguranca(String tipus, float preu) {
        this._tipus = tipus;
        this._preu=preu;
    }

    public String getTipus() {
        return this._tipus;
    }
    
    public float getPreu(){
        return this._preu;
    }
}
