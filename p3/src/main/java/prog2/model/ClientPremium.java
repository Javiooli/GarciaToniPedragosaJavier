package main.java.prog2.model;

public class ClientPremium extends Client {
    
    public ClientPremium(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    public String tipusClient() {return "Premium";}
    public float calcMensual() {return -1;} //TODO
    public float descompteEnv() {return -1;} //TODO

}
