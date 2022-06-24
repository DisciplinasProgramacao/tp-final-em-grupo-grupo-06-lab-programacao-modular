package utils;

import java.util.Random;
import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Utilitario {

    public static int NAME = 27;
    public static String[] nomes = {
            "Costello",
            "Kid Richards",
            "Party Poison",
            "Morrison",
            "Matt Davu",
            "Mumford",
            "Jimmy",
            "Bowie",
            "Monkey",
            "Manson",
            "Dianury",
            "John Beacon",
            "Korne",
            "Blood Sandwich",
            "Alice",
            "Blackout",
            "Ramone",
            "Cohen",
            "Iggy",
            "Primal Scream",
            "Monolith",
            "Gojira",
            "Smoke and Mirrors",
            "Ringo",
            "Rile Nodger",
            "Springstone",
            "Turner",
            "Bowie",
            "Metalic"
    };

    public static String gerarNome() {
        if( NAME == 0 ){
            NAME = 28;
        }
        return nomes[NAME--];
    }

    public static String gerarCPF() {

        String str = "";
        int min_val = 100;
        int max_val = 999;
        int a, b, c, d = 0;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        a = tlr.nextInt(min_val, max_val + 1);
        b = tlr.nextInt(min_val, max_val + 1);
        c = tlr.nextInt(min_val, max_val + 1);
        d = tlr.nextInt(0, 99 + 1);

        str = String.format("%d.%d.%d-%d", a, b, c, d);
        return str;

    }

    public static String gerarCodigo(int length) {
        char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }
}
