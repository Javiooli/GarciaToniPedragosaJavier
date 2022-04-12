package prog2.model.abstractes;

import prog2.vista.ExcepcioClub;

public interface InAssegurat {
    public String getTipusAssegurança() throws ExcepcioClub;    
    public void setTipusAssegurança(String tipus, float preu) throws ExcepcioClub;
}
