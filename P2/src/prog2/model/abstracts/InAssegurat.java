package prog2.model.abstracts;

import prog2.vista.ExcepcioClub;

public interface InAssegurat {
    public String getTipusAssegurança() throws ExcepcioClub;    
    public void setTipusAssegurança(String tipus) throws ExcepcioClub;
}
