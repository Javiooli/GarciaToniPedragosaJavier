package prog2.adaptador;

import prog2.vista.MercatException;
import prog2.model.Dades;

public class Adaptador {
    Dades dades;
    public Adaptador() {
        dades = new Dades();
    }
    
    public void afegirArticle(String id, String nom, float preu, int temps, boolean urgent) throws MercatException{
        dades.afegirArticle(id, nom, preu, temps, urgent);
    }
    public void afegirClient(String correu, String nom, String adreca, boolean premium) throws MercatException {
        dades.afegirClient(correu, nom, adreca, premium);
    }
    public void afegirComanda (int articlePos, int clientPos, int qty, boolean urgent) throws MercatException{
        dades.afegirComanda(articlePos, clientPos, qty, urgent);
    }

    public void guardaDades(String camiDesti) throws MercatException {
        
    }
    public void carregaDades(String camiOrigen) throws MercatException {

    }
    public String printLlistaArticles() throws MercatException{
        return dades.printLlistaArticles();
    }
    public String printLlistaClients() throws MercatException{
        return dades.printLlistaClients();
    }

}
