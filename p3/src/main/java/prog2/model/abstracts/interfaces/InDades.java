package prog2.model.abstracts.interfaces;

import java.util.ArrayList;

import prog2.model.Article;
import prog2.model.abstracts.Client;
import prog2.model.abstracts.Comanda;
import prog2.vista.MercatException;

/**
 *
 * @author dortiz
 */
public interface InDades {

    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException;

    public ArrayList<Article> recuperaArticles();

    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException;

    public ArrayList<Client> recuperaClients();

    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException;

    public void esborrarComanda(int position) throws MercatException;

    public ArrayList<Comanda> recuperaComandes();

    public ArrayList<Comanda> recuperaComandesUrgents();
}
