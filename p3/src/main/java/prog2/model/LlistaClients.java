package prog2.model;
import java.io.Serializable;

import prog2.model.abstracts.Client;
import prog2.model.abstracts.Llista;
import prog2.vista.MercatException;

public class LlistaClients extends Llista<Client> implements Serializable {
    @Override
    public void afegir(Client client) throws MercatException {
        for (Client c : llista) {
            if (c.getEmail().equals(client.getEmail())) throw new MercatException("Ja existeix un client amb aquesta direcció de correu electrònic.");
        }
        llista.add(client);
    }

    public String toStringWIndex(){
        String result = "";
        int index = 1;
        for (Client client : llista) {
            result = result + index +". "+ client.toString() +"\n";
            index++;
        }
        return result;
    }
}
