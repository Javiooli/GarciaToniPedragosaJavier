/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.vista;

import java.util.Scanner;

import prog2.model.ClubUB;

/**
 * 
 */
public class VistaClubUB {

    private ClubUB club;

    public VistaClubUB(String nomClub, int maxMembres) {
        this.club = new ClubUB(nomClub, maxMembres);
    }

    private static enum Opcions {
        M_Opcion_1_DonarDalta,
        M_Opcion_2_MostrarLlista,
        M_Opcion_3_MostrarLlistaFederats,
        M_Opcion_4_MostrarLlistaEstandard,
        M_Opcion_5_MostrarLlistaJunior,
        M_Opcion_6_EliminarSoci,
        M_Opcion_7_VerificarSocis,
        M_Opcion_8_MostrarTotalFactura,
        M_Opcion_9_ModificarNom,
        M_Opcion_10_ModificarAsseguranca,
        M_Opcion_11_GuardarLlista,
        M_Opcion_12_RecuperarLlista,
        M_Opcion_13_Sortir
    };

    private static enum Opcions_afegir {
        M_Opcion_1_AfegirFederat,
        M_Opcion_2_AfegirEstandar,
        M_Opcion_3_AfegirJunior,
        M_Opcion_4_Tornar
    };
    
    private static String[] descripcions = {"Donar d'alta un nou soci", "Mostrar llista de socis", "Mostrar llista de socis federats",
    "Mostrar llista de socis estàndard", "Mostrar llista de socis junior", "Eliminar soci", "Verificar socis", "Mostrar total factura",
    "Modificar nom soci", "Modificar tipus assegurança soci", "Guardar llista", "Recuperar llista", "Sortir"};

    private static String[] descripcions_afegir = {"Afegir soci federat", "Afegir soci estàndard", "Afegir soci junior", "Menú anterior"};

    public void gestioClubUB() {

        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);

        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }

    private String entrarDNI(Scanner sc) {
        String dni = "";
        dni = sc.nextLine();

        return dni;
    }

    private float demanaPreuFed(Scanner sc) throws ExcepcioClub{
        float preuFed = 0;
        boolean correcte = false;
        do {
            try {
                sc.nextLine();
                System.out.println("Preu de la federacio:");
                preuFed = sc.nextFloat();
                if (preuFed>0)
                    correcte = true;
                else 
                    System.out.println("Entrada no vàlida, introdueix un nombre positiu.");
            } catch (Exception e) {
                System.out.println("Entrada no vàlida, introdueix un nombre positiu.");
            }
        } while (!correcte);
        return preuFed;
    }

    private String demanaTipusAssegurança(Scanner sc){
        boolean OK = false;
        int asegurança = -1;
        String[] assegurances = {"Bàsica", "Completa"};

        System.out.println("Selecciona tipus d'assegurança:");

        for (int i = 0; i < assegurances.length; i++) {
            System.out.println((i + 1) + ". " + assegurances[i]);
        }
        do {
            try {
                asegurança = sc.nextInt();
                if (asegurança < 1 || asegurança > assegurances.length) throw new IllegalArgumentException();
                OK = true;
            } catch (Exception e) {
                System.err.println("Opció no vàlida, introdueix un nombre d'entre les opcions de la llista.");
            } finally {
                sc.nextLine();
            }
        } while (!OK);
        return assegurances[asegurança-1];
    }

    private float demanaPreuAssegurança(Scanner sc) throws ExcepcioClub{
        float preu = -1;
        System.out.println("Introdueix el preu de la assegurança:");
        do{
            try{
                preu = sc.nextFloat();
                if(preu<=0) System.out.println("Introdueix un valor numèric major que 0.");
                sc.nextLine();
            }
            catch(Exception e){
                sc.nextLine();
                preu=-1;
                if (ExcepcioClub.class.isInstance(e))
                  System.out.println(e.getMessage());
                else
                    System.out.println("Introdueix un valor numèric.");
            }
        }while(preu==-1);
        return preu;
    }

    public int[] demanaDataNaixement(Scanner sc) {
        int[] data = new int[3];
        boolean correcte = false;
        do {
            try {
                sc.nextLine();
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
                sc.nextLine();
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
                sc.nextLine();
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

    private void crearSoci(Scanner sc, int tipus) {
        String nom, dni;
        System.out.println("Nom del nou soci:");
        nom = sc.nextLine();
        System.out.println("DNI del nou soci:");
        dni = entrarDNI(sc);
        String asegurança = "";
        String nomFed ="";
        float preu=0;
        int[] data = {0,0,0};
        try {
            switch (tipus){
                case 1:
                    System.out.println("Nom de la federacio:");
                    nomFed = sc.nextLine();
                    preu = demanaPreuFed(sc);
                    club.crearSoci(sc, tipus, dni, nom, asegurança, 0, preu, nomFed,data);
                break;

                case 2:
                    asegurança = demanaTipusAssegurança(sc);
                    preu = demanaPreuAssegurança(sc);
                    club.crearSoci(sc, tipus, dni, nom, asegurança, preu, 0, nomFed,data);
                break;

                case 3:
                    asegurança = demanaTipusAssegurança(sc);                    
                    preu = demanaPreuAssegurança(sc);
                    data = demanaDataNaixement(sc);
                    club.crearSoci(sc, tipus, dni, nom, asegurança, preu, 0, nomFed, data);
                break;
            }
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }

    public void gestioMenu(Scanner sc) {
        System.out.println("Vols buscar si existeix una llista amb dades dels socis i carregar-la? (Y/N)");
        if (sc.nextLine().equalsIgnoreCase("Y")){
            club.carregarLlista();
        }
        Menu menu_principal = new Menu<>("Menu Principal", Opcions.values());
        menu_principal.setDescripcions(descripcions);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        Opcions opcionMenu;

        // Lançar el bucle principal de la aplicación
        do {
            menu_principal.mostrarMenu();
            opcionMenu = (Opcions) menu_principal.getOpcio(sc);

            switch (opcionMenu) {
                case M_Opcion_1_DonarDalta:
                    
                    Menu menu_afegir = new Menu<>("Donar d'alta un nou soci", Opcions_afegir.values());
                    menu_afegir.setDescripcions(descripcions_afegir);

                    Opcions_afegir opcionMenu_afegir;

                    menu_afegir.mostrarMenu();
                    opcionMenu_afegir = (Opcions_afegir) menu_afegir.getOpcio(sc);

                    switch (opcionMenu_afegir) {
                        case M_Opcion_1_AfegirFederat:
                            crearSoci(sc, 1);
                            break;
                        case M_Opcion_2_AfegirEstandar:
                            crearSoci(sc, 2);
                            break;
                        case M_Opcion_3_AfegirJunior:
                            crearSoci(sc, 3);
                            break;
                        case M_Opcion_4_Tornar:
                            break;
                    }

                    break;
                case M_Opcion_2_MostrarLlista:
                    club.printLlistaSocis("tots");
                    break;
                case M_Opcion_3_MostrarLlistaFederats:
                    club.printLlistaSocis("federat");
                    break;
                case M_Opcion_4_MostrarLlistaEstandard:
                    club.printLlistaSocis("estandar");
                    break;
                case M_Opcion_5_MostrarLlistaJunior:
                    club.printLlistaSocis("junior");
                    break;
                case M_Opcion_6_EliminarSoci:
                    System.out.println("Entra el DNI del soci que vols eliminar.");
                    String DNI = sc.nextLine();
                    try {
                        club.eliminaSoci(DNI);
                        System.out.println("Soci amb DNI " + DNI + " eliminat amb èxit.");
                    }
                    catch(ExcepcioClub e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case M_Opcion_7_VerificarSocis:
                    try{
                        club.comprova();
                        System.out.println("Tota la informació dels socis és correcta.");
                    }
                    catch(ExcepcioClub e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case M_Opcion_8_MostrarTotalFactura:
                    System.out.println("Entra el DNI del soci.");
                    DNI = sc.nextLine();
                    int num=0;
                    do{
                        System.out.println("Entra el nombre d'excursions realitzades aquest mes.");
                        num = sc.nextInt();
                        if (num>=0)
                            try{
                            System.out.println(club.calculQuota(num, DNI));
                            }
                            catch(ExcepcioClub e){
                                System.out.println(e.getMessage());
                            }
                    }while (num<0);
                    break;
                case M_Opcion_9_ModificarNom:
                    System.out.println("Entra el DNI del soci a qui vols canviar el nom:");
                    DNI = sc.nextLine();
                    System.out.println("Entra el nou nom del soci:");
                    String nouNom = sc.nextLine();
                    try{
                        club.canviaNom(DNI, nouNom);
                        System.out.println("Nom del soci amb DNI " + DNI + "canviat amb èxit.");
                    }
                    catch(ExcepcioClub e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case M_Opcion_10_ModificarAsseguranca:
                    System.out.println("Entra el DNI del soci a qui vols canviar l'assegurança");
                    DNI = sc.nextLine();
                    try{
                        String tipus = club.getTipusAssegurança(DNI);
                        if (tipus.equals("Bàsica")){
                            System.out.println("El soci amb DNI " + DNI + " té una assegurança bàsica. Vols canviar-la a completa? (Y/N)");
                            if (sc.nextLine().equalsIgnoreCase("Y")){
                                club.setTipusAssegurança(DNI, "Completa", demanaPreuAssegurança(sc));
                            }
                        }
                        if (tipus.equals("Completa")){
                            System.out.println("El soci amb DNI " + DNI + " té una assegurança completa. Vols canviar-la a bàsica? (Y/N)");
                            if (sc.nextLine().equalsIgnoreCase("Y")){
                                club.setTipusAssegurança(DNI, "Bàsica", demanaPreuAssegurança(sc));
                        }                            
                        }
                    }
                    catch(ExcepcioClub e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case M_Opcion_11_GuardarLlista:
                System.out.println("Vols guardar la llista de socis? Aixo substituirà la llista actual guardada (Y/N).");
                String temp = sc.nextLine();
                if (temp.equalsIgnoreCase("Y")){
                    System.out.println("Guardant la llista de socis actual al fitxer ClubUB.dat ...");
                    club.guardarLlista();
                }
                    break;
                case M_Opcion_12_RecuperarLlista:
                System.out.println("Vols recuperar la llista guardada? Aixo substituirà la llista actual del programa (Y/N).");
                temp = sc.nextLine();
                if (temp.equalsIgnoreCase("Y")){
                    club.carregarLlista();
                }
                    break;
                case M_Opcion_13_Sortir:
                    break;
            }

        } while (opcionMenu != Opcions.M_Opcion_13_Sortir);
    }
}
