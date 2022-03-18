/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.vista;

import java.util.Scanner;

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

    private static String[] descripcions = {"Donar d'alta un nou soci", "Mostrar llista de socis", "Mostrar llista de socis federats",
    "Mostrar llista de socis estàndard", "Mostrar llista de socis junior", "Eliminar soci", "Verificar socis", "Mostrar total factura",
    "Modificar nom soci", "Modificar tipus assegurança soci", "Guardar llista", "Recuperar llista", "Sortir"};

    public void gestioClubUB() {

        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);

        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }

    public void gestioMenu(Scanner sc) {
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
                    club.afegirSoci(sc);
                    break;
                case M_Opcion_2_MostrarLlista:
                    break;
                case M_Opcion_3_MostrarLlistaFederats:
                    break;
                case M_Opcion_4_MostrarLlistaEstandard:
                    break;
                case M_Opcion_5_MostrarLlistaJunior:
                    break;
                case M_Opcion_6_EliminarSoci:
                    break;
                case M_Opcion_7_VerificarSocis:
                    break;
                case M_Opcion_8_MostrarTotalFactura:
                    break;
                case M_Opcion_9_ModificarNom:
                    break;
                case M_Opcion_10_ModificarAsseguranca:
                    break;
                case M_Opcion_11_GuardarLlista:
                    break;
                case M_Opcion_12_RecuperarLlista:
                    break;
                case M_Opcion_13_Sortir:
                    break;
            }

        } while (opcionMenu != Opcions.M_Opcion_13_Sortir);
    }
}
