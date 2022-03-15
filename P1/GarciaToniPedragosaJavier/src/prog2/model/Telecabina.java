package prog2.model;

public class Telecabina extends Remuntador {

    Telecabina(String nom, float limitVent, boolean estat, boolean susceptibleVisib) {
        super(nom, limitVent, estat, susceptibleVisib);
    }

    @Override
    public String tipus() {
        return "Telecabina";
    }
    
}
