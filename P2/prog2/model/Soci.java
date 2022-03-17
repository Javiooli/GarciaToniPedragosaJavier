package prog2.model;

import prog2.vista.ExcepcioClub;

public abstract class Soci implements InSoci {

    private String nom;
    private String dni;

    @Override
    public void setNom(String nom) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getNom() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDNI(String dni) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getDNI() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void comprova() throws ExcepcioClub {
        // TODO Auto-generated method stub
        
    }
    
}
