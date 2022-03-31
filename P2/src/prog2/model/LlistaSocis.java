package prog2.model;

import java.util.ArrayList;

import prog2.model.abstracts.Soci;
import prog2.vista.ExcepcioClub;

public class LlistaSocis {
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
        soci.comprova();
        comprovarRepDNI(soci);
        socis.add(soci);
        System.out.println("Soci afegit:\n" + soci.toString());

    }

    public String toString(String tipus){
        String llista = "Socis: "+"\n";
        for (Soci s : socis) {
            if (tipus.equalsIgnoreCase("tots") || s.tipus().equalsIgnoreCase(tipus))
            llista = llista + s.toString() + "\n";
        }
        return llista;
    }

    public boolean eliminaSoci(String dni){
        boolean eliminacioOK = false;
        for(Soci s: socis){
            if(s.getDNI().equalsIgnoreCase(dni)){
                eliminacioOK = true;
                socis.remove(s);
                break;
            }
        }
    
        return eliminacioOK;
    }

    public Soci buscarSoci (String DNI){
        for (Soci s: socis){
            if (DNI==s.getDNI()){
                return s;
            }
        }
        //TODO
        return null;
    }

}
