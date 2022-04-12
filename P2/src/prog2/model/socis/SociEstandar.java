/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.model.socis;

import prog2.model.abstractes.InAssegurat;
import prog2.model.abstractes.Soci;
import prog2.model.atributs.Asseguranca;
import prog2.vista.ExcepcioClub;

public class SociEstandar extends Soci implements InAssegurat{
    private Asseguranca asseguranca;

    public SociEstandar(String nom, String dni, Asseguranca as) {
        super(nom, dni);
        asseguranca = as;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String soci = super.toString();
        return soci + ", Asseguranca: " + asseguranca.getTipus() + ", " + asseguranca.getPreu() + " Euros";
    }

    
    /** 
     * @throws ExcepcioClub
     */
    @Override
    public void comprova() throws ExcepcioClub {
        if (!this.asseguranca.getTipus().equals("Bàsica") && !this.asseguranca.getTipus().equals("Completa"))
            throw new ExcepcioClub("Tipus d'asseguranca invàlida.");
    }

    
    /** 
     * @return String
     * @throws ExcepcioClub
     */
    public String getTipusAsseguranca() throws ExcepcioClub{
        return asseguranca.getTipus();
    }

    
    /** 
     * @param tipus
     * @param preu
     * @throws ExcepcioClub
     */
    public void setTipusAsseguranca(String tipus, float preu) throws ExcepcioClub{
        asseguranca = new Asseguranca(tipus, preu);
        comprova();
    }

    
    /** 
     * @param quotaBase
     * @return float
     * @throws ExcepcioClub
     */
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub {
        return quotaBase;
    }

    
    /** 
     * @param preuExcursioBase
     * @return float
     * @throws ExcepcioClub
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return (preuExcursioBase + asseguranca.getPreu());
    }
}
