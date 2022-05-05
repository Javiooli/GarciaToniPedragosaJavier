package prog2.vista;

import java.util.Scanner;

import prog2.vista.Menu;

public class MercatUB {

    private static enum enumMain {
        M_Opcio_1_GestioArticles,
        M_Opcio_2_GestioClients,
        M_Opcio_3_GestioComandes,
        M_Opcio_4_GuardarDades,
        M_Opcio_5_CarregaDades,
        M_Opcio_6_Sortir
    };

    private static enum enumArticles {
        M_Opcio_1_AfegirArticle,
        M_Opcio_2_VisualitzarArticle,
        M_Opcio_3_Tornar
    };

    private static enum enumClients {
        M_Opcio_1_AfegirClient,
        M_Opcio_2_VisualitzarClients,
        M_Opcio_3_Tornar
    };

    private static enum enumComandes {
        M_Opcio_1_AfegirComanda,
        M_Opcio_2_EsborrarComanda,
        M_Opcio_3_VisualitzarComandes,
        M_Opcio_4_VisualitzarUrgents,
        M_Opcio_5_Tornar
    };
    
    private static String[] descripcionsMain = {"Gestió Articles", "Gestió Clients", "Gestió Comandes",
                                                "Guardar Dades", "Carregar Dades", "Sortir"};

    private static String[] descripcionsArticles = {"Afegir Article", "Visualitzar Articles", "Menú Principal"};

    private static String[] descripcionsClients = {"Afegir Client", "Visualitzar Clients", "Menú Principal"};

    private static String[] descripcionsComandes = {"Afegir Comanda", "Esborrar Comanda", "Visualitzar Comandes",
                                                    "Visualitzar Comandes Urgents", "Menú Principal"};

    public void gestioMercatUB() {
        Scanner sc = new Scanner(System.in);

        gestioMenuMain(sc);
    }
    
    private void gestioMenuMain(Scanner sc) {
        Menu menuMain = new Menu<>("MercatUB", enumMain.values());
        menuMain.setDescripcions(descripcionsMain);
        Menu menuArticles = new Menu<>("Gestió Articles", enumArticles.values());
        menuArticles.setDescripcions(descripcionsArticles);
        Menu menuClients = new Menu<>("Gestió Clients", enumClients.values());
        menuClients.setDescripcions(descripcionsClients);
        Menu menuComandes = new Menu<>("Gestió Comandes", enumComandes.values());
        menuComandes.setDescripcions(descripcionsComandes);

        enumMain opcioMain;
        enumArticles opcioArticles;
        enumClients opcioClients;
        enumComandes opcioComandes;

        do {
            menuMain.mostrarMenu();
            opcioMain = (enumMain) menuMain.getOpcio(sc);

        } while (opcioMain != enumMain.M_Opcio_6_Sortir);
    }

}
