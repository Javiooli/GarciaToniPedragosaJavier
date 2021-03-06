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
        if (comanda.getQuantitat()<=0) throw new MercatException("No es pot afegir una comanda una quantitat menor a 1.");
            
        llista.add(comanda);
    }
    
    public String toStringWIndex(){
        String result = "";
        int index = 1;
        for (Comanda comanda : llista) {
            result = result + index +". "+ comanda.toString() +"\n";
            index++;
        }
        return result;
    }
    public String printUrgents(){
        String result = "";
        for (Comanda com: llista){
            if (ComandaUrgent.class.isInstance(com)) result = result + com.toString();
        }
        return result;
    }

    public String toString(){
        String result = "";
        for (Comanda comanda : llista) {
            result = result + comanda.toString() +"\n";
        }
        return result;
    }

    @Override
    public void esborrar(int posicio) throws MercatException{
        if(llista.get(posicio).comandaEnviada()) throw new MercatException("Aquesta comanda ja ha estat enviada.");
        else llista.remove(posicio);
    }
}