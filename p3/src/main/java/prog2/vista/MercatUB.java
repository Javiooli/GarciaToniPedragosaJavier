package prog2.vista;

import java.util.Scanner;

import prog2.vista.Menu;
import prog2.adaptador.*;

public class MercatUB {
    
    Adaptador ad = new Adaptador();

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
            
            switch (opcioMain){
                case M_Opcio_1_GestioArticles:
                    menuArticles.mostrarMenu();
                    opcioArticles = (enumArticles) menuArticles.getOpcio(sc);
                    switch(opcioArticles){
                        case M_Opcio_1_AfegirArticle:
                            afegirArticle(sc);
                            break;
                        case M_Opcio_2_VisualitzarArticle:
                            visualitzarArticle(sc);
                            break;
                        default: break;
                    }
                    break;
                case M_Opcio_2_GestioClients:
                    menuClients.mostrarMenu();
                    opcioClients = (enumClients) menuClients.getOpcio(sc);
                    switch(opcioClients){
                        case M_Opcio_1_AfegirClient:
                            afegirClient(sc);
                            break;
                        case M_Opcio_2_VisualitzarClients:
                            visualitzarClient(sc);
                            break;
                        default: break;
                    }
                    break;
                case M_Opcio_3_GestioComandes:
                    menuComandes.mostrarMenu();
                    opcioComandes = (enumComandes) menuComandes.getOpcio(sc);
                    switch(opcioComandes){
                        case M_Opcio_1_AfegirComanda:
                            afegirComanda(sc);
                            break;
                        case M_Opcio_2_EsborrarComanda:
                            esborrarComanda(sc);
                            break;
                        case M_Opcio_3_VisualitzarComandes:
                            visualitzarComanda(sc);
                            break;
                        case M_Opcio_4_VisualitzarUrgents:
                            visualitzarUrgents(sc);
                            break;
                        default: break;
                    }
                    break;
                case M_Opcio_4_GuardarDades:
                    guardarDades();
                    break;
                case M_Opcio_5_CarregaDades:
                    carregarDades();
                    break;
            }
            
        } while (opcioMain != enumMain.M_Opcio_6_Sortir);
    }
    
    void afegirArticle (Scanner sc){
        System.out.println("Entra l'identificador de l'article: ");
        String id = sc.nextLine();
        System.out.println("Entra el nom de l'article: ");
        String nom = sc.nextLine();
        String temp ="h.5ñ9";
        float preu = -1;
        boolean ok=false;
        do{
            System.out.println("Entra el preu de l'article: ");
            temp = sc.nextLine();
            try{
                preu = Float.parseFloat(temp);
                ok=true;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(!ok);        
        ok=false;
        int temps = 0;
        do{
            System.out.println("Entra el temps fins l'enviament de l'article: ");
            temp = sc.nextLine();
            try{
            temps = Integer.parseInt(temp);
            ok=true;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(!ok);
        do{
            System.out.println("Entra si el article admet enviament urgent: (Y/N)");
            temp = sc.nextLine();
            
        }while(!temp.equalsIgnoreCase("Y") && !temp.equalsIgnoreCase("N"));
        boolean urgent = temp.equalsIgnoreCase("Y")? true: false;
        try{
        ad.afegirArticle(id,nom, preu, temps, urgent);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void visualitzarArticle (Scanner sc){
        
    }

    void afegirClient(Scanner sc){
        System.out.println("Entra l'adreça de correu electronic: ");
        String correu = sc.nextLine();
        System.out.println("Entra el nom del client: ");
        String nom = sc.nextLine();
        System.out.println("Entra l'adreça del client: ");
        String adreca = sc.nextLine();   
        String temp;
        do{
            System.out.println("Es client Premium? (Y/N)");
            temp = sc.nextLine();
            
        }while(!temp.equalsIgnoreCase("Y") && !temp.equalsIgnoreCase("N"));
        boolean premium = temp.equalsIgnoreCase("Y")? true: false;
        try{
        ad.afegirClient(correu, nom, adreca, premium);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void visualitzarClient(Scanner sc){
        
    }

    void afegirComanda(Scanner sc){
        try{
            System.out.println(ad.printLlistaArticles());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Entra l'index del article de la comanda: ");
        String temp;
        temp=sc.nextLine();
        int articlePos;
        boolean ok=false;
        do{
            try{
                articlePos=Integer.parseInt(temp);
                ok=true;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while(!ok);
        try{
            System.out.println(ad.printLlistaClients());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Entra l'index del client que fa comanda: ");
        temp=sc.nextLine();
        int clientPos;
        ok=false;
        do{
            try{
                clientPos=Integer.parseInt(temp);
                ok=true;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while(!ok);
    }

    void esborrarComanda(Scanner sc){
        
    }

    void visualitzarComanda(Scanner sc){
        
    }

    void visualitzarUrgents(Scanner sc){
        
    }

    void guardarDades(){
        
    }

    void carregarDades(){
        
    }

}
