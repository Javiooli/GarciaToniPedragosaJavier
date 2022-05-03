package main.java.prog2.model;
import main.java.prog2.model.abstracts.Client;
import prog2.model.abstracts.Llista;

public class LlistaClients extends Llista<Client> implements Serializable {
    @Override
    public void afegir(Client client) throws MercatException {
        for (Client c : llista) {
            if (c.getEmail().equals(client.getEmail())) throw MercatException("Ja existeix un client amb aquesta direcció de correu electrònic.");
        }
        llista.add(client);
    }
}
