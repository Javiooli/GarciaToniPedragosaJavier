package prog2.model;

public class Telecadira extends Remuntador {

    Telecadira(String nom, float limitVent, boolean estat, boolean susceptibleVisib) {
        super(nom, limitVent, estat, susceptibleVisib);
    }

    @Override
    public String tipus() {
        return "Telecadira";
    }
    
}
