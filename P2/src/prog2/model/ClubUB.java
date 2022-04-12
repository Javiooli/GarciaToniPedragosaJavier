package prog2.model;

import java.io.*;
import java.util.Scanner;

import prog2.vista.*;
import prog2.model.abstracts.*;
import prog2.model.atributs.*;
import prog2.model.socis.*;

public class ClubUB implements Serializable {
    private static String[] TIPUS_MEMBRES = {"federat", "estandar", "junior"};
    private String _nom;
    private int _maxMembres;
    private LlistaSocis _llistaSocis;

    public static float PREU_EXCURSIO_BASE = 20;
    public static float QUOTA_MENSUAL = 25;
    public static float DESCOMPTE_EXCURSIONS_FEDERATS = 20;
    public static float DESCOMPTE_QUOTA_FEDERATS = 30;

    public ClubUB(String nom, int maxMembres) {
        _nom = nom;
        _maxMembres = maxMembres;
        _llistaSocis = new LlistaSocis(_maxMembres);
    }


    public LlistaSocis getLlistaSocis() {
        return this._llistaSocis;
    }

    public void crearSoci(Scanner sc, int tipus, String dni, String nom, String tipusAsseguranca, float preuAssegurança,
                     float preuFed, String nomFed, int[] data) throws ExcepcioClub {

        try {
            switch (tipus) {
                case 1:
                    Federacio fed = new Federacio(nomFed, preuFed);
                    SociFederat sociFederat = new SociFederat(nom, dni, fed);
                    sociFederat.comprova();
                    _llistaSocis.afegirSoci(sociFederat);
                    System.out.println("Soci afegit: " + sociFederat.toString());
                    break;

                case 2:
                    SociEstandar sociEstandar = new SociEstandar(nom, dni, tipusAsseguranca, preuAssegurança);
                    sociEstandar.comprova();
                    _llistaSocis.afegirSoci(sociEstandar);
                    System.out.println("Soci afegit: " + sociEstandar.toString());
                    break;

                case 3:
                    SociJunior sociJunior = new SociJunior(nom, dni, tipusAsseguranca, preuAssegurança, data);
                    sociJunior.comprova();
                    _llistaSocis.afegirSoci(sociJunior);
                    System.out.println("Soci afegit: " + sociJunior.toString());
                    break;
            }
        } catch (ExcepcioClub e) {
            throw e;
        }
    }

    public void printLlistaSocis(String tipus){
        System.out.println(_llistaSocis.toString(tipus));
    }

    public void eliminaSoci(String DNI) throws ExcepcioClub{
        try{
            _llistaSocis.eliminaSoci(DNI);
        }
        catch (ExcepcioClub e){
            throw e;
        }
    }

    public int calculQuota(int numExc, String DNI) throws ExcepcioClub{
        //TODO: calcular cuota pq IDK
        try{
            Soci s = _llistaSocis.buscarSoci(DNI);
            return -1;
        }
        catch (ExcepcioClub e){
            throw e;
        }    
    }

    public void canviaNom(String DNI,String nouNom) throws ExcepcioClub{
        Soci s = _llistaSocis.buscarSoci(DNI);
        s.setNom(nouNom);
    }

    public String getTipusAssegurança(String DNI) throws ExcepcioClub{
        Soci s = _llistaSocis.buscarSoci(DNI);
        try{
            SociEstandar so = (SociEstandar) s;
            return so.getTipusAssegurança();
        }
        catch(Exception e){
            throw new ExcepcioClub("El soci trobat no té assegurança (és federat).");
        }
    }

    public void setTipusAssegurança(String dni, String tipus, float preu) throws ExcepcioClub{        
        Soci s = _llistaSocis.buscarSoci(dni);
        try{
            SociEstandar so = (SociEstandar) s;
            so.setTipusAssegurança(tipus, preu);
        }
        catch(Exception e){
            throw new ExcepcioClub("El soci trobat no té assegurança (és federat).");
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
