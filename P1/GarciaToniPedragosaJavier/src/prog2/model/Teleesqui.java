package prog2.model;

public class Teleesqui extends Remuntador {

    Teleesqui(String nom, float limitVent, boolean estat, boolean susceptibleVisib) {
        super(nom, limitVent, estat, susceptibleVisib);
    }

    @Override
    public String tipus() {
        return "Teleesquí";
    }
    
}
