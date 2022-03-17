package prog2.model;

import java.util.Scanner;

public class TusMuertos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el número de personas: ");
        int tamanoDePoblacion = (entrada.nextInt());
        System.out.println(cumple(tamanoDePoblacion));
        entrada.next();
    }

    /**
     * @param num Tamaño de la poblacion usada para calcular la probabilidad.
     * @return Probabilidad entre la poblacion haya 2 personas que tengan el
     * mismo cumpleaños.
     */

    public static double cumple(int num) {
        double probabilidad = 1.0;

        for (int i = 1; i <= num; i++) {
            probabilidad = probabilidad * (366 - i) / 365;
        }

        return (100 * ((1 - probabilidad)));
    }
}