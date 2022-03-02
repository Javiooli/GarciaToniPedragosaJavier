package prog2.model;

import java.util.ArrayList;

public class EstacioEsqui {
    
    private String nom;
    private ArrayList<Sector> sectors;

    public EstacioEsqui() {
        this.nom = "Sense nom";
        this.sectors = new ArrayList<>();
    }

    public EstacioEsqui(String nom) {
        this.nom = nom;
        this.sectors = new ArrayList<>();
    }

    public EstacioEsqui(String nomEstacio, int velocitatVentNord,
    String visibilitatNord, int velocitatVentSud, String visibilitatSud) {
        this.nom = nomEstacio;
        this.sectors = new ArrayList<>();
        this.sectors.add(new Sector("Nord", visibilitatNord, velocitatVentNord));
        this.sectors.add(new Sector("Sud", visibilitatSud, velocitatVentSud));
    }

    public String getNom() {
        return this.nom;
    }

    public void crearSector(String nomSector) {
        this.sectors.add(new Sector(nomSector));
    }
    //TODO: Pulir msg cuando no hay ninguna pista abierta/cerrada en algun sector,
    //para replicar, escoger opcion 3 en el menu, pone Sector Nord: Sector Sud:.
    public void llistarPistes(String estat) {
        StringBuilder msg = new StringBuilder();
        for (Sector sector : this.sectors) {
            msg.append("Sector " + sector.getNom() + ":\n");
            msg.append(sector.llistarPistes(estat));
        }
        System.out.println(msg);
    }

    public void llistarRemuntadors(String estat) {
        StringBuilder msg = new StringBuilder();
        for (Sector sector : this.sectors) {
            msg.append("Sector " + sector.getNom() + ":\n");
            msg.append(sector.llistarRemuntadors(estat));
        }
        System.out.println(msg);
    }

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

    public void reportMeteo(){
        for (Sector sector : this.sectors) {
            sector.reportMeteo();
        }
    }




//TODO: Pulir el bucle for con un foreach para quitar todos los .get(i) del codigo.
    public void inicialitzaDadesVall2000() {
        for (int i = 0; i < this.sectors.size(); i++) {
            this.sectors.get(i).getLlistaRemuntadors().buidar();
            this.sectors.get(i).getLlistaPistes().buidar();
            
            if(this.sectors.get(i).getNom().equals("Nord")) {
                Telecadira RM1 = new Telecadira("RM1", 35, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM1);
                Teleesqui  RM2 = new Teleesqui ("RM2", 35, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM2);
                Telecadira RM3 = new Telecadira("RM3", 35, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM3);
                Teleesqui  RM4 = new Teleesqui ("RM4", 60, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM4);
                Telecabina RM5 = new Telecabina("RM5", 60, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM5);
                CintaTransportadora RM6 = new CintaTransportadora("RM6", 60, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM6);
            
                Pista P1  = new Pista("P1", "Negra", 0.8f, "Dura", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P1);
                Pista P2  = new Pista("P2", "Vermella", 1.1f, "Dura", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P2);
                Pista P3  = new Pista("P3", "Blava", 1.8f, "Pols", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P3);
                Pista P4  = new Pista("P4", "Vermella", 1.2f, "Dura", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P4);
                Pista P5  = new Pista("P5", "Blava", 2.1f, "Primavera", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P5);
                Pista P6  = new Pista("P6", "Blava", 2.9f, "Pols", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P6);
                Pista P7  = new Pista("P7", "Verda", 1.2f, "Primavera", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P7);
                Pista P8  = new Pista("P8", "Verda", 0.9f, "Pols", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P8);

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
                
            } else if(this.sectors.get(i).getNom().equals("Sud")) {
                Teleesqui  RM7 = new Teleesqui ("RM7", 60, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM7);
                Telecadira RM8 = new Telecadira("RM8", 60, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM8);
                Telecabina RM9 = new Telecabina("RM9", 60, false, true);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM9);
                Teleferic RM10 = new Teleferic ("RM10", 60, true, false);
                this.sectors.get(i).getLlistaRemuntadors().afegirRemuntador(RM10);
            
                Pista P9  = new Pista("P9", "Vermella", 2.1f, "Dura", "Tancada");
                this.sectors.get(i).getLlistaPistes().afegirPista(P9);
                Pista P10 = new Pista("P10", "Negra", 0.6f, "Primavera", "Tancada");
                this.sectors.get(i).getLlistaPistes().afegirPista(P10);
                Pista P11 = new Pista("P11", "Vermella", 1.3f, "Primavera", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P11);
                Pista P12 = new Pista("P12", "Blava", 1.9f, "Pols", "Oberta");
                this.sectors.get(i).getLlistaPistes().afegirPista(P12);
                
                P9.afegirDependencia(RM9);
                P10.afegirDependencia(RM9);
                P11.afegirDependencia(RM7);
                P11.afegirDependencia(RM9);
                P12.afegirDependencia(RM8);
            }
        }
        
    }
}
