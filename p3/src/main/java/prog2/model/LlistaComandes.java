package main.java.prog2.model;

import main.java.prog2.model.abstracts.Comanda;

public class LlistaComandes extends Llista<Comanda> implements Serializable {
    @Override
    public void afegir(Comanda comanda) throws MercatException {
        if (comanda.tipusComanda().equalsIgnoreCase("Urgent") && !comanda.getArticle().isUrgent())
            throw MercatException("Aquest article no admet enviament urgent.");
            
        llista.add(comanda);
    }
}
