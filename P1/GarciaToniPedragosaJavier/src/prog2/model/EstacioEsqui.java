package prog2.model;

import java.util.ArrayList;
import java.util.Scanner;

public class EstacioEsqui {
    
    private String nom;
    private ArrayList<Sector> sectors;
    Scanner sc = new Scanner(System.in);

    //Default constructor
    public EstacioEsqui() {
        this.nom = "Sense nom";
        this.sectors = new ArrayList<>();
    }

    /**
     * @param nom name of this station
     */
    public EstacioEsqui(String nom) {
        this.nom = nom;
        this.sectors = new ArrayList<>();
    }

    /**
     * @param nomEstacio name of this station
     * @param velocitatVentNord wind speed in north sector
     * @param visibilitatNord visibility conditions in north sector
     * @param velocitatVentSud wind speed in south sector
     * @param visibilitatSud visibility conditions in south sector
     */
    public EstacioEsqui(String nomEstacio, int velocitatVentNord,
    String visibilitatNord, int velocitatVentSud, String visibilitatSud) {
        this.nom = nomEstacio;
        this.sectors = new ArrayList<>();
        this.sectors.add(new Sector("Nord", visibilitatNord, velocitatVentNord));
        this.sectors.add(new Sector("Sud", visibilitatSud, velocitatVentSud));
    }

    /**
     * @return String with the name of this EstacioEsqui
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * @param nomSector name of a new sector to add to this EstacioEsqui
     */
    public void crearSector(String nomSector) {
        this.sectors.add(new Sector(nomSector));
    }

    /**
     * @param estat state of the trails we want to list
     */
    public void llistarPistes(String estat) {
        StringBuilder msg = new StringBuilder();
        for (Sector sector : this.sectors) {
            msg.append("\n    Sector " + sector.getNom() + ":\n");
            msg.append(sector.llistarPistes(estat));
        }
        System.out.println(msg);
    }

    /**
     * @param estat state of the lifters we want to list
     */
    public void llistarRemuntadors(String estat) {
        StringBuilder msg = new StringBuilder();
        for (Sector sector : this.sectors) {
            msg.append("\n    Sector " + sector.getNom() + ":\n");
            msg.append(sector.llistarRemuntadors(estat));
        }
        System.out.println(msg);
    }

    /**
     * Calculates and prints the length of all the trails and the open ones
     */
    public void calcularKms() {
        float total = 0;
        float obertes = 0;
        StringBuilder msg = new StringBuilder("Longitud de pistes total: ");
        for (Sector sector : this.sectors) {
            total += sector.getLlistaPistes().calculaKmsPistes("Tots");
            total = (float)Math.round(total*100f) / 100f;
            obertes += sector.getLlistaPistes().calculaKmsPistes("Oberta");
            obertes = (float)Math.round(obertes*100f) / 100f;
        }
        msg.append(total + " Km\nLongitud de pistes obertes: " + obertes + " Km");
        System.out.println(msg);
    }

    /**
     * Manages the wind speed modification via keyboard
     */
    public void modificaVent(){
        System.out.println("A quin sector vols modificar el vent?");
        for (Sector sector : this.sectors) {
            System.out.println(sector.getNom());
        }
        String entrada = sc.next();
        sc.nextLine();

        boolean trobat = false;
        int iterator = 0;
        do {
            Sector s = sectors.get(iterator);
            trobat = (entrada.equalsIgnoreCase(s.getNom()));
            if (trobat) {
                System.out.println("Quina es la velocitat del vent en aquest sector?");
                boolean entradaOK = false;
                float f = 0f;
                do{
                    String velocitat = sc.nextLine();
                    if(!velocitat.isEmpty()){
                        try {
                            f = Float.parseFloat(velocitat);
                            entradaOK = true;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Introdueix un valor numèric.");                        
                        }
                    }
                } while (!entradaOK);
                s.setVelocitatVent(f);
            }
            if (!trobat)
                iterator++;
        } while (!trobat && iterator < sectors.size());

        if (!trobat)
            System.out.println("Sector no trobat.");
        else
            System.out.println("Vent al sector " + sectors.get(iterator).getNom() + " actualitzat a " + sectors.get(iterator).getMeteo().getVelocitatVent() + "Km/h.");
    }

    /**
     * Manages the visibility condition modification via keyboard
     */
    public void modificaVisibilitat(){
        System.out.println("A quin sector vols modificar la visibilitat?");
        for (Sector sector : this.sectors) {
            System.out.println(sector.getNom());
        }
        String entrada = sc.nextLine();

        boolean trobat = false;
        int iterator = 0;
        do {
            Sector s = sectors.get(iterator);
            trobat = (entrada.equalsIgnoreCase(s.getNom()));
            if (trobat) {
                System.out.println("Quina es la visibilitat en aquest sector? (Bona/Dolenta)");
                boolean entradaOK = false;
                do{
                    String temp = sc.nextLine().toLowerCase();
                    if(temp.equalsIgnoreCase("bona") || temp.equalsIgnoreCase("dolenta")){
                        s.setVisibilitat(temp);
                        entradaOK = true;
                    }
                    else{
                        System.out.println("Entrada invàlida. Entra 'Bona' o 'Dolenta'");
                    }
                }while (!entradaOK);
            }
            if (!trobat)
                iterator++;
        } while (!trobat && iterator < sectors.size());

        if (!trobat)
            System.out.println("Sector no trobat.");
        else
            System.out.println("Visibilitat al sector " + sectors.get(iterator).getNom() + " actualitzada a " + sectors.get(iterator).getMeteo().getVisibilitat() + ".");
    }


    /**
     * Calls reportMeteo() inside Sector class.
     */
    public void reportMeteo(){
        for (Sector sector : this.sectors) {
            sector.reportMeteo();
        }
    }

    /**
     * Inits this EstacioEsqui with its sectors and each sector with its trails and lifters.
     */
    public void inicialitzaDadesVall2000() {
        for (Sector sector : sectors) {
            sector.getLlistaRemuntadors().buidar();
            sector.getLlistaPistes().buidar();
            
            if(sector.getNom().equals("Nord")) {
                Telecadira RM1 = new Telecadira("RM1", 35, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM1);
                Teleesqui  RM2 = new Teleesqui ("RM2", 35, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM2);
                Telecadira RM3 = new Telecadira("RM3", 35, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM3);
                Teleesqui  RM4 = new Teleesqui ("RM4", 60, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM4);
                Telecabina RM5 = new Telecabina("RM5", 60, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM5);
                CintaTransportadora RM6 = new CintaTransportadora("RM6", 60, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM6);
            
                Pista P1  = new Pista("P1", "Negra", 0.8f, "Dura", "Oberta");
                sector.getLlistaPistes().afegirPista(P1);
                Pista P2  = new Pista("P2", "Vermella", 1.1f, "Dura", "Oberta");
                sector.getLlistaPistes().afegirPista(P2);
                Pista P3  = new Pista("P3", "Blava", 1.8f, "Pols", "Oberta");
                sector.getLlistaPistes().afegirPista(P3);
                Pista P4  = new Pista("P4", "Vermella", 1.2f, "Dura", "Oberta");
                sector.getLlistaPistes().afegirPista(P4);
                Pista P5  = new Pista("P5", "Blava", 2.1f, "Primavera", "Oberta");
                sector.getLlistaPistes().afegirPista(P5);
                Pista P6  = new Pista("P6", "Blava", 2.9f, "Pols", "Oberta");
                sector.getLlistaPistes().afegirPista(P6);
                Pista P7  = new Pista("P7", "Verda", 1.2f, "Primavera", "Oberta");
                sector.getLlistaPistes().afegirPista(P7);
                Pista P8  = new Pista("P8", "Verda", 0.9f, "Pols", "Oberta");
                sector.getLlistaPistes().afegirPista(P8);

                P1.afegirDependencia(RM1);
                P2.afegirDependencia(RM2);
                P2.afegirDependencia(RM3);
                P3.afegirDependencia(RM5);
                P4.afegirDependencia(RM5);
                P5.afegirDependencia(RM5);
                P6.afegirDependencia(RM4);
                P7.afegirDependencia(RM5);
                P8.afegirDependencia(RM5);
                P8.afegirDependencia(RM6);
                
            } else if (sector.getNom().equals("Sud")) {
                Teleesqui  RM7 = new Teleesqui ("RM7", 60, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM7);
                Telecadira RM8 = new Telecadira("RM8", 60, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM8);
                Telecabina RM9 = new Telecabina("RM9", 60, false, true);
                sector.getLlistaRemuntadors().afegirRemuntador(RM9);
                Teleferic RM10 = new Teleferic ("RM10", 60, true, false);
                sector.getLlistaRemuntadors().afegirRemuntador(RM10);
            
                Pista P9  = new Pista("P9", "Vermella", 2.1f, "Dura", "Tancada");
                sector.getLlistaPistes().afegirPista(P9);
                Pista P10 = new Pista("P10", "Negra", 0.6f, "Primavera", "Tancada");
                sector.getLlistaPistes().afegirPista(P10);
                Pista P11 = new Pista("P11", "Vermella", 1.3f, "Primavera", "Oberta");
                sector.getLlistaPistes().afegirPista(P11);
                Pista P12 = new Pista("P12", "Blava", 1.9f, "Pols", "Oberta");
                sector.getLlistaPistes().afegirPista(P12);
                
                P9.afegirDependencia(RM9);
                P10.afegirDependencia(RM9);
                P11.afegirDependencia(RM7);
                P11.afegirDependencia(RM9);
                P12.afegirDependencia(RM8);
            }
        }
        
    }
}
