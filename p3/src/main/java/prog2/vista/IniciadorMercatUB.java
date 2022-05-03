package prog2.vista;

import java.text.SimpleDateFormat;
import java.util.*;

public final class IniciadorMercatUB {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }
}
