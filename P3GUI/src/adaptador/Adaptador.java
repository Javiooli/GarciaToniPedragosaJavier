package prog2.adaptador;

import prog2.vista.MercatException;
import prog2.model.*;
import prog2.model.abstracts.Client;
import prog2.model.abstracts.Comanda;

import java.io.*;
import java.util.ArrayList;

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

    public ArrayList<String> printLlistaArticles() throws MercatException{
        ArrayList<String> result = new ArrayList<>();
        for (Article a: dades.recuperaArticles()){
            result.add(a.toString());
        }
        return result;
    }

    public ArrayList<String> printLlistaClients() throws MercatException{
        ArrayList<String> result = new ArrayList<>();
        for (Client c: dades.recuperaClients()){
            result.add(c.toString());
        }
        return result;
    }

    public ArrayList<String> printLlistaComandes(boolean urgent) throws MercatException{
        ArrayList<String> result = new ArrayList<>();
        if (urgent){
            for (Comanda c: dades.recuperaComandesUrgents()){
                result.add(c.toString());
            }
        }
        else {
            for (Comanda c: dades.recuperaComandes()){
                result.add(c.toString());
            }
        }
        return result;
    }

    public void esborrarComanda(int index) throws MercatException{
        dades.esborrarComanda(index);
    }

}
