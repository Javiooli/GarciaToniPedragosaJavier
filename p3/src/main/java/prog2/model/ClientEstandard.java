package main.java.prog2.model;

public class ClientEstandard extends Client {

    public ClientEstandard(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    public String tipusClient() {return "Estandard";}
    public float calcMensual() {return -1;} //TODO
    public float descompteEnv() {return -1;} //TODO
}
