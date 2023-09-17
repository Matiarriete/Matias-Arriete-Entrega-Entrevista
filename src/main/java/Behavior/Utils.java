package Behavior;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static String generateMail(int longitud) {
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, banco.length() - 1);
            char caracterAleatorio = banco.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }
}
