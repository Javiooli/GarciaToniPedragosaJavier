package prog2.model;

import java.io.*;
import java.util.Scanner;

import prog2.vista.*;
import prog2.model.abstracts.*;
import prog2.model.atributs.*;
import prog2.model.socis.*;

public class ClubUB implements Serializable {
    private static String[] TIPUS_MEMBRES = {"federat", "estandar", "junior"}; //TODO
    private String _nom;
    private int _maxMembres;
    private LlistaSocis _llistaSocis;

    public static float PREU_EXCURSIO_BASE = 20;
    public static float QUOTA_MENSUAL = 25;
    public static float DESCOMPTE_EXCURSIONS_FEDERATS = 20;
    public static float DESCOMPTE_QUOTA_FEDERATS = 30;


    //TODO: pasar prints y scanners a VistaClubUB

    public ClubUB(String nom, int maxMembres) {
        _nom = nom;
        _maxMembres = maxMembres;
        _llistaSocis = new LlistaSocis(_maxMembres);
    }


    public LlistaSocis getLlistaSocis() {
        return this._llistaSocis;
    }

    public void crearSoci(Scanner sc, int tipus, String dni, String nom, int assegurança,
                     float preuFed, String nomFed, int[] data) throws ExcepcioClub {

        try {
            switch (tipus) {
                case 1:
                    Federacio fed = new Federacio(nomFed, preuFed);
                    SociFederat sociFederat = new SociFederat(nom, dni, fed);
                    sociFederat.comprova();
                    _llistaSocis.afegirSoci(sociFederat);
                    break;

                case 2:
                    SociEstandar sociEstandar = new SociEstandar(nom, dni, Integer.toString(assegurança));
                    sociEstandar.comprova();
                    _llistaSocis.afegirSoci(sociEstandar);
                    break;

                case 3:
                    SociJunior sociJunior = new SociJunior(nom, dni, Integer.toString(assegurança), data);
                    sociJunior.comprova();
                    _llistaSocis.afegirSoci(sociJunior);
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

    public void setTipusAssegurança(String tipus) throws ExcepcioClub{
        
    }
    public void guardarLlista(){
        File fitxer = new File("clubUB.dat");
        try{ 
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(_llistaSocis);
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
