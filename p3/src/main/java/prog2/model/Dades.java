package prog2.model;

import java.util.ArrayList;
import java.io.Serializable;
import prog2.model.abstracts.Client;
import prog2.model.abstracts.Comanda;
import prog2.model.abstracts.interfaces.InDades;
import prog2.vista.MercatException;

public class Dades implements InDades, Serializable{

    private LlistaArticles articles;
    private LlistaClients clients;
    private LlistaComandes comandes;

    public Dades() {
        articles = new LlistaArticles();
        clients = new LlistaClients();
        comandes = new LlistaComandes();
    }

    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent)
            throws MercatException {
        articles.afegir(new Article(id, nom, preu, temps, admetUrgent));
        
    }

    @Override
    public ArrayList<Article> recuperaArticles() {        
        return articles.getArrayList();
    }

    @Override
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        clients.afegir(esPremium ? new ClientPremium(email, nom, adreca) : new ClientEstandard(email, nom, adreca));
    }

    @Override
    public ArrayList<Client> recuperaClients() {
        return clients.getArrayList();
    }

    @Override
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        comandes.afegir(esUrgent ? new ComandaUrgent(articles.getAt(articlePos), clients.getAt(clientPos), quantitat) :
                                   new ComandaNormal(articles.getAt(articlePos), clients.getAt(clientPos), quantitat));
    }

    @Override
    public void esborrarComanda(int position) throws MercatException {
        comandes.esborrar(comandes.getAt(position));
    }

    @Override
    public ArrayList<Comanda> recuperaComandes(){
        return comandes.getArrayList();
    }

    @Override
    public ArrayList<Comanda> recuperaComandesUrgents() {
        ArrayList<Comanda> comandesUrgents = new ArrayList<Comanda>();
        for (Comanda c : comandes.getArrayList()) {
            if (c.tipusComanda().equalsIgnoreCase("Urgent")) comandesUrgents.add(c);
        }
        return comandesUrgents;
    }
    
}
