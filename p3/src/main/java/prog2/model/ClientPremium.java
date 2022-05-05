package prog2.model;

import prog2.model.abstracts.Client;

public class ClientPremium extends Client {
    
    public ClientPremium(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    public String tipusClient() {return "Premium";}
    public float calcMensual() {return -1;} //TODO
    public float descompteEnv() {return -1;} //TODO

}
