/*
 * Universitat de Barcelona
 * Programaci√≥ 2
 * Curs 2021-2022
 */
package prog2.vista;
/**
 * 
 */
public class ExcepcioClub extends Throwable {
    private String missatge_error;

    public ExcepcioClub() {
        super();
    }
    public ExcepcioClub(String missatge) {
        super(missatge);
    }
}
