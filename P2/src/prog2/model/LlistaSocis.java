package prog2.model;

import java.util.ArrayList;

import prog2.model.abstracts.Soci;
import prog2.vista.ExcepcioClub;

public class LlistaSocis {
    private ArrayList<Soci> socis;

    public LlistaSocis(int mida) {
        this.socis = new ArrayList<Soci>(mida);
    }

    public void afegirSoci(Soci soci) {
        try {
            soci.comprova();
        } catch (ExcepcioClub e) {
            System.out.println();
        }
        for (Soci s : socis) {

        }
    }
}
