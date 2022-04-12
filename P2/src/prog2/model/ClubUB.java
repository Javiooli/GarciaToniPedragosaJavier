package prog2.model;

import java.io.*;
import java.util.Scanner;

import prog2.vista.*;
import prog2.model.abstractes.*;
import prog2.model.atributs.*;
import prog2.model.socis.*;

public class ClubUB implements Serializable {
    private String _nom;
    private int _maxMembres;
    private LlistaSocis _llistaSocis;

    public static float PREU_EXCURSIO_BASE = 25.00f;
    public static float QUOTA_MENSUAL = 30.00f;
    public static float DESCOMPTE_EXCURSIONS_FEDERATS = 20;
    public static float DESCOMPTE_QUOTA_FEDERATS = 30;

    public ClubUB(String nom, int maxMembres) {
        _nom = nom;
        _maxMembres = maxMembres;
        _llistaSocis = new LlistaSocis(_maxMembres);
    }


    
    /** 
     * @return LlistaSocis
     */
    public LlistaSocis getLlistaSocis() {
        return this._llistaSocis;
    }

    
    /** 
     * @param sc
     * @param tipus
     * @param dni
     * @param nom
     * @param tipusAsseguranca
     * @param preuAsseguranca
     * @param preuFed
     * @param nomFed
     * @param data
     * @throws ExcepcioClub
     */
    public void crearSoci(Scanner sc, int tipus, String dni, String nom, String tipusAsseguranca, float preuAsseguranca,
                            float preuFed, String nomFed, int[] data) throws ExcepcioClub {

            switch (tipus) {
            case 1:
                Federacio fed = new Federacio(nomFed, preuFed);
                SociFederat sociFederat = new SociFederat(nom, dni, fed);
                sociFederat.comprova();
                _llistaSocis.addSoci(sociFederat);
                System.out.println("Soci afegit: " + sociFederat.toString());
                break;

            case 2:
                Asseguranca as = new Asseguranca(tipusAsseguranca, preuAsseguranca);
                SociEstandar sociEstandar = new SociEstandar(nom, dni, as);
                sociEstandar.comprova();
                _llistaSocis.addSoci(sociEstandar);
                System.out.println("Soci afegit: " + sociEstandar.toString());
                break;

            case 3:
                as = new Asseguranca(tipusAsseguranca, preuAsseguranca);
                SociJunior sociJunior = new SociJunior(nom, dni, as, data);
                sociJunior.comprova();
                _llistaSocis.addSoci(sociJunior);
                System.out.println("Soci afegit: " + sociJunior.toString());
                break;
            }

    }

    
    /** 
     * @throws ExcepcioClub
     */
    public void comprova() throws ExcepcioClub{
        _llistaSocis.verificarSocis();
    }

    
    /** 
     * @param tipus
     */
    public void printLlistaSocis(String tipus){
        System.out.println(_llistaSocis.toString(tipus));
    }

    
    /** 
     * @param DNI
     * @throws ExcepcioClub
     */
    public void eliminaSoci(String DNI) throws ExcepcioClub{
        Soci s = _llistaSocis.getSoci(DNI);
        _llistaSocis.removeSoci(s);
    }

    
    /** 
     * @param numExc
     * @param DNI
     * @return float
     * @throws ExcepcioClub
     */
    public float calculQuota(int numExc, String DNI) throws ExcepcioClub{
        Soci s = _llistaSocis.getSoci(DNI);
        return (s.calculaQuota(QUOTA_MENSUAL) + numExc*s.calculaPreuExcursio(PREU_EXCURSIO_BASE));
 
    }

    
    /** 
     * @param DNI
     * @param nouNom
     * @throws ExcepcioClub
     */
    public void canviaNom(String DNI,String nouNom) throws ExcepcioClub{
        Soci s = _llistaSocis.getSoci(DNI);
        s.setNom(nouNom);
    }

    
    /** 
     * @param DNI
     * @return String
     * @throws ExcepcioClub
     */
    public String getTipusAsseguranca(String DNI) throws ExcepcioClub{
        Soci s = _llistaSocis.getSoci(DNI);
        try{
            SociEstandar so = (SociEstandar) s;
            return so.getTipusAsseguranca();
        }
        catch(Exception e){
            throw new ExcepcioClub("El soci trobat no té asseguranca (és federat).");
        }
    }

    
    /** 
     * @param dni
     * @param tipus
     * @param preu
     * @throws ExcepcioClub
     */
    public void setTipusAsseguranca(String dni, String tipus, float preu) throws ExcepcioClub{        
        Soci s = _llistaSocis.getSoci(dni);
        try{
            SociEstandar so = (SociEstandar) s;
            so.setTipusAsseguranca(tipus, preu);
        }
        catch(Exception e){
            throw new ExcepcioClub("El soci trobat no té asseguranca (és federat).");
        }
    }
    public void guardarLlista(){
        File fitxer = new File("clubUB.dat");
        fitxer.delete();
        try{ 
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(_llistaSocis);
            oos.close();
            fout.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }

    public void carregarLlista(){
        File fitxer = new File("clubUB.dat");
        try{
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);
            _llistaSocis = (LlistaSocis) ois.readObject();
            fin.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
