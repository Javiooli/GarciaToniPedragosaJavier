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
}
