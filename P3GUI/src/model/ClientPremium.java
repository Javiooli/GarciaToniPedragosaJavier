package model;

import model.abstracts.Client;

public class ClientPremium extends Client {
    
    public ClientPremium(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    public String tipusClient() {return "Premium";}
    public float calcMensual() {return 4;} 
    public float descompteEnv() {return 20;} 

}
