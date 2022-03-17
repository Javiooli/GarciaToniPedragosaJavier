package prog2.vista;

import java.io.Serializable;
import java.util.Scanner;

import prog2.model.LlistaSocis;
import prog2.model.socis.*;

public class ClubUB implements Serializable {
    private static String[] TIPUS_MEMBRES = {"Afegir soci f", "Júnior"}; //TODO
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

    public void afegirSoci(Scanner sc) {
        boolean correcte = false;
        int tipus = -1;
        String nom, dni;

        //TODO: Implementar esta seleccion utilizando una instancia de la clase Menu
        for (int i = 0; i < TIPUS_MEMBRES.length; i++) {
            System.out.println((i + 1) + ". " + TIPUS_MEMBRES[i]);
        }
        
        do {
            try {
                tipus = sc.nextInt();
                if (tipus < 1 || tipus > TIPUS_MEMBRES.length) throw new IllegalArgumentException();
                correcte = true;
            } catch (Exception e) {
                System.err.println("Opció no vàlida, introdueix un nombre d'entre les opcions de la llista.");
            } finally {
                sc.nextLine();
            }
        } while (!correcte);

        correcte = false;

        System.out.println("Nom del soci: ");
        nom = sc.nextLine();

        System.out.println("DNI del soci: ");
        dni = sc.next();
        sc.nextLine();
        
        switch (tipus) {
            case 1:
                String asseguranca = selecAsseguranca(sc);
                try {
                    _llistaSocis.afegirSoci(new SociEstandar(nom, dni, asseguranca));
                } catch (ExcepcioClub e) {
                    System.err.println(e.what());
                }
                break;
            case 2:
                break;
            case 3:
                break;
        }




    }

    public LlistaSocis getLlistaSocis() {
        return this._llistaSocis;
    }


    private String selecAsseguranca(Scanner sc) {
        boolean correcte = false;
        int tipus = -1;
        String[] assegurances = {"Bàsica", "Completa"};
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


}
