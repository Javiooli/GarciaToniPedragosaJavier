package prog2.vista;

import prog2.model.*;

/**
 *
 * @author ricardo.marques
 */
public class IniciadorEstacioEsqui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definim el nom i les condicions meteorologiques inicials a l'estació
        String nomEstacio      = "Vall2000";
        int velocitatVentNord  = 10;
        String visibilitatNord = "Dolenta";
        int velocitatVentSud   = 10;
        String visibilitatSud  = "Dolenta";

        // Creem un objecte de la vista i li passem el nom i condicions meteorologiques inicials a l'estació
        VistaEstacioEsqui vistaEstacioVall2000 = new VistaEstacioEsqui(nomEstacio,
            velocitatVentNord, visibilitatNord, velocitatVentSud, visibilitatSud);
     
        // Inicialitzem l'execució de la vista
        vistaEstacioVall2000.gestioEstacio();
    }
    
}
