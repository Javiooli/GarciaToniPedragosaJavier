package prog2.model;

import java.io.Serializable;
import java.util.ArrayList;

import prog2.model.abstracts.InSociList;
import prog2.model.abstracts.Soci;
import prog2.vista.ExcepcioClub;

public class LlistaSocis implements InSociList {
    private ArrayList<Soci> socis;
    private int _size;
    private int _maxSize;

    public LlistaSocis(int mida) {
        this.socis = new ArrayList<Soci>(mida);
        this._maxSize=mida;
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
        return _size;
    }

    @Override
    public void addSoci(Soci soci) throws ExcepcioClub {
        if(isFull()) throw new ExcepcioClub("La llista està plena.");
        soci.comprova();
        comprovarRepDNI(soci);
        socis.add(soci);
        _size++;
    }

    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub {
        try{
            socis.remove(soci);
            _size--;
        }
        catch(Exception e){
            throw new ExcepcioClub("No s'ha pogut eliminar el soci.");
        }
    }

    @Override
    public Soci getAt(int position) throws ExcepcioClub {
        try{
            return socis.get(position);
        }
        catch(Exception e){
            throw new ExcepcioClub("No s'ha pogut trobar un soci a la possicio designada");
        }
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
        try{
            socis.clear();
        }
        catch(Exception e){
            throw new ExcepcioClub("No s'ha pogut esborrar la llista.");
        }
    }

    @Override
    public boolean isFull() throws ExcepcioClub {
        return _size==_maxSize;
    }

    @Override
    public boolean isEmpty() throws ExcepcioClub {
        return _size==0;
    }

    @Override
    public void verificarSocis() throws ExcepcioClub {
        for (Soci s: socis){
        s.comprova();
        }    
    }

}
