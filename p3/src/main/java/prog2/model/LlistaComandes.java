package prog2.model;

import java.io.Serializable;

import prog2.model.abstracts.Comanda;
import prog2.model.abstracts.Llista;
import prog2.vista.MercatException;

public class LlistaComandes extends Llista<Comanda> implements Serializable {
    @Override
    public void afegir(Comanda comanda) throws MercatException {
        if (comanda.tipusComanda().equalsIgnoreCase("Urgent") && !comanda.getArticle().isUrgent())
            throw new MercatException("Aquest article no admet enviament urgent.");
            
        llista.add(comanda);
    }
}
