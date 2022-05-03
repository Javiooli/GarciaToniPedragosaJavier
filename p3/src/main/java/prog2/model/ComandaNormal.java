package main.java.prog2.model;

public class ComandaNormal extends Comanda {
    
    public ComandaNormal() {}
    public ComandaNormal(Article article, Client client, int quantitat) {
        super(article, client, quantitat);
    }

    public String tipusComanda() {
        return "Normal";
    }
    public boolean comandaEnviada() {
        return this.enviat;
    }
    public boolean comandaRebuda() {
        return this.rebuda;
    }
    //TODO
    public float preuEnviament() {
        return -1;
    }

}
