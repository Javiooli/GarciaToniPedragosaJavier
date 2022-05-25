package prog2.adaptador;

import prog2.vista.MercatException;
import prog2.model.Dades;
import java.io.*;

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
        File fitxer = new File(camiDesti);
        fitxer.delete();
        try{ 
            FileOutputStream fout = new FileOutputStream(fitxer);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(dades);
            oos.close();
            fout.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
    public void carregaDades(String camiOrigen) throws MercatException {
        File fitxer = new File(camiOrigen);
        try{
            FileInputStream fin = new FileInputStream(fitxer);
            ObjectInputStream ois = new ObjectInputStream(fin);
            dades = (Dades) ois.readObject();
            fin.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public String printLlistaArticles(boolean index) throws MercatException{
        return dades.printLlistaArticles(index);
    }
    public String printLlistaClients(boolean index) throws MercatException{
        return dades.printLlistaClients(index);
    }
    public String printLlistaComandes(boolean index,boolean urgent) throws MercatException{
        return dades.printLlistaComandes(index, urgent);
    }
    public void esborrarComanda(int index) throws MercatException{
        dades.esborrarComanda(index);
    }

}
