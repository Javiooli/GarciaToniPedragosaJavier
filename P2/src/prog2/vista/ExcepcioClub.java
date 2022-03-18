/*
 * Universitat de Barcelona
 * Programació 2
 * Curs 2021-2022
 */
package prog2.vista;
/**
 * 
 */
public class ExcepcioClub extends Throwable {
    private String missatge_error;

    public ExcepcioClub() {
        this.missatge_error = "Error desconegut.";
    }
    public ExcepcioClub(String missatge) {
        this.missatge_error = missatge;
    }

    public String what() {
        return this.missatge_error;
    }
}
