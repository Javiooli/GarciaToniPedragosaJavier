package main.java.prog2.model;

public class ComandaUrgent extends Comanda {
    
    public ComandaUrgent() {}
    public ComandaUrgent(Article article, Client client, int quantitat) {
        super(article, client, quantitat);
    }

    public String tipusComanda() {
        return "Urgent";
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
