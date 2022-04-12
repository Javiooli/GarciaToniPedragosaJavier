package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;

import prog2.model.abstracts.InSociList;
import prog2.model.abstracts.Soci;
import prog2.vista.ExcepcioClub;

public class LlistaSocis implements InSociList {
    private ArrayList<Soci> socis;

    public LlistaSocis(int mida) {
        this.socis = new ArrayList<Soci>(mida);
    }

    public void comprovarRepDNI(Soci soci) throws ExcepcioClub {
        for (Soci s : socis) {
            if (s.getDNI().equals(soci.getDNI())) throw new ExcepcioClub("Ja existeix un soci amb el mateix DNI.");
        }
    }

    public void afegirSoci(Soci soci) throws ExcepcioClub {


    }

    public String toString(String tipus){
        String llista = "Socis: "+"\n";
        for (Soci s : socis) {
            if (tipus.equalsIgnoreCase("tots") || s.tipus().equalsIgnoreCase(tipus))
            llista = llista + s.toString() + "\n";
        }
        return llista;
    }

    public void eliminaSoci(String dni) throws ExcepcioClub{
        boolean trobat = false;
        for(Soci s: socis){
            if(s.getDNI().equalsIgnoreCase(dni)){
                socis.remove(s);
                trobat = true;
                break;
            }
        }
        if(!trobat)
        throw new ExcepcioClub("Soci no trobat.");
    }

    public Soci buscarSoci (String DNI) throws ExcepcioClub{
        for (Soci s: socis){
            if (DNI==s.getDNI()){
                return s;
            }
        }
        throw new ExcepcioClub("Soci no trobat");
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        if(isFull()) throw new ExcepcioClub("La llista està plena.");
        soci.comprova();
        comprovarRepDNI(soci);
        socis.add(soci);
        
    }

    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Soci getSoci(String dni) throws ExcepcioClub {
        if (isEmpty()) throw new ExcepcioClub("La llista no contè cap soci.");
        for (Soci s: socis){
            if (dni==s.getDNI()){
                return s;
            }
        }
        throw new ExcepcioClub("Soci no trobat");
    }

    @Override
    public void clear() throws ExcepcioClub {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isFull() throws ExcepcioClub {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEmpty() throws ExcepcioClub {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void verificarSocis() throws ExcepcioClub {
        // TODO Auto-generated method stub
        
    }

}
