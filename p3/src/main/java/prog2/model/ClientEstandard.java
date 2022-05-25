package prog2.model;

import prog2.model.abstracts.Client;

public class ClientEstandard extends Client {

    public ClientEstandard(String email, String nom, String adreca) {
        super(email, nom, adreca);
    }

    public String tipusClient() {return "Estandard";}
    public float calcMensual() {return 0;}
    public float descompteEnv() {return 0;}
}
