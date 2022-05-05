package prog2.model;

import prog2.model.abstracts.Client;
import prog2.model.abstracts.Comanda;

public class ComandaNormal extends Comanda {
    
    public ComandaNormal() {}
    public ComandaNormal(Article article, Client client, int quantitat) {
        super(article, client, quantitat);
    }

    public String tipusComanda() {
        return "Normal";
    }
    public boolean comandaEnviada() {
        return isEnviat();
    }
    public boolean comandaRebuda() {
        return isRebuda();
    }
    //TODO
    public float preuEnviament() {
        return -1;
    }

}
