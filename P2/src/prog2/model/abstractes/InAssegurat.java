package prog2.model.abstractes;

import prog2.vista.ExcepcioClub;

public interface InAssegurat {
    public String getTipusAsseguranca() throws ExcepcioClub;    
    public void setTipusAsseguranca(String tipus, float preu) throws ExcepcioClub;
}
