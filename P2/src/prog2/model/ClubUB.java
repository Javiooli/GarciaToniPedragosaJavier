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

    public void crearSoci(Scanner sc, int tipus, String dni, String nom) throws ExcepcioClub {

        try {
            switch (tipus) {
                case 1:
                    SociFederat sociFederat = new SociFederat(nom, dni, selecFederacio(sc));
                    sociFederat.comprova();
                    _llistaSocis.afegirSoci(sociFederat);
                    break;

                case 2:
                    SociEstandar sociEstandar = new SociEstandar(nom, dni, selecAsseguranca(sc));
                    sociEstandar.comprova();
                    _llistaSocis.afegirSoci(sociEstandar);
                    break;

                case 3:
                    SociJunior sociJunior = new SociJunior(nom, dni, selecAsseguranca(sc), seleccionaDataNaixement(sc));
                    sociJunior.comprova();
                    _llistaSocis.afegirSoci(sociJunior);
                    break;
            }
        } catch (ExcepcioClub e) {
            throw e;
        }
    }
    //TODO: pasar esto a clubUB
    private String selecAsseguranca(Scanner sc) {
        boolean correcte = false;
        int tipus = -1;
        String[] assegurances = {"Bàsica", "Completa"};

        System.out.println("Selecciona tipus d'assegurança:");

        for (int i = 0; i < assegurances.length; i++) {
            System.out.println((i + 1) + ". " + assegurances[i]);
        }
        do {
            try {
                tipus = sc.nextInt();
                if (tipus < 1 || tipus > assegurances.length) throw new IllegalArgumentException();
                correcte = true;
            } catch (Exception e) {
                System.err.println("Opció no vàlida, introdueix un nombre d'entre les opcions de la llista.");
            } finally {
                sc.nextLine();
            }
        } while (!correcte);

        return assegurances[tipus - 1];
    }
    //TODO: pasar esto a clubUB
    private Federacio selecFederacio(Scanner sc) {
        String nom;
        float preu = 0;
        boolean correcte = false;
        System.out.println("Nom de la federacio:");
        nom = sc.nextLine();
        do {
            try {
                System.out.println("Preu de la federacio:");
                preu = sc.nextFloat();
                correcte = true;
            } catch (Exception e) {
                System.out.println("Entrada no vàlida, introdueix un nombre positiu.");
            }
        } while (!correcte);
        return new Federacio(nom, preu);
    }

    public void printLlistaSocis(String tipus){
        System.out.println(_llistaSocis.toString(tipus));
    }

    public boolean eliminaSoci(String DNI){
        return _llistaSocis.eliminaSoci(DNI);
    }
    public int calculQuota(int numExc, String DNI){
        //TODO: calcular cuota pq IDK
        Soci s = _llistaSocis.buscarSoci(DNI);
        return -1;
        
    }

    public void guardarLlista(){
        File fitxer = new File("clubUB.dat");
        //TODO guardar en fichero
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

    public int[] seleccionaDataNaixement(Scanner sc) {
        int[] data = new int[3];
        boolean correcte = false;
        do {
            try {
                System.out.println("Any de naixement del nou soci: ");
                data[2] = sc.nextInt();
                if (data[2] > 1900 && data[2] < 2022) correcte = true;
                else System.out.println("Introdueix un nombre entre 1900 i 2022.");
            } catch (Exception e) {
                System.out.println("Introdueix un nombre entre 1900 i 2022.");
            }
        } while (!correcte);
        correcte = false;

        do {
            try {
                System.out.println("Mes de naixement del nou soci: ");
                data[1] = sc.nextInt();
                if (data[1] > 0 && data[1] < 13) correcte = true;
                else System.out.println("Introdueix un nombre entre 1 i 12.");
            } catch (Exception e) {
                System.out.println("Introdueix un nombre entre 1 i 12.");
            }
        } while (!correcte);
        correcte = false;

        do {
            try {
                System.out.println("Dia de naixement del nou soci: ");
                data[0] = sc.nextInt();
                if (data[0] > 0 && data[0] < 32) correcte = true;
                else System.out.println("Introdueix un nombre entre 1 i 31.");
            } catch (Exception e) {
                System.out.println("Introdueix un nombre entre 1 i 31.");
            }
        } while (!correcte);

        return data;
    }

}
