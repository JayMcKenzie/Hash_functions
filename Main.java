import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    private static byte[] text_bytes;

    private static void hash(String type) throws NoSuchAlgorithmException {         //funkcja skrótu (type) definiowana jest w funkcji głównej
        MessageDigest md = MessageDigest.getInstance(type);
        long startTime = System.nanoTime();                 //uruchomienie licznika czasu   (wymagane do zad. 2)
        byte[] text_bytes_hash = md.digest(text_bytes);     //proces szyfrowania podanego tekstu zapisanego w postaci tablicy bajtów
        long stopTime = System.nanoTime();                  //zatrzymanie licznika  (wymagane do zad. 2)
        long calculatedTime = stopTime - startTime;         //kalkulacja czasu      (wymagane do zad. 2)
        BigInteger bigInt = new BigInteger(1, text_bytes_hash);
        String hashtext = bigInt.toString(16);        //zamiana tablicy bajtów na String
        while(hashtext.length() < 32 ) {
            hashtext = "0" + hashtext;
        }
        int length = hashtext.length();                     //zapisanie długości zaszyfrowanego tekstu  (wymagane do zad. 2)
        System.out.println("["+type+"] Zaszyfrowana wiadomosc: " + hashtext + "\nCzas zaszyfrowania: " + calculatedTime +"ns"
                            + "\nDlugosc szyfru: " + length);
    }

    public static void main(String[] args) throws  NoSuchAlgorithmException {
        System.out.println("Podaj tekst do zaszyfrowania: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        text_bytes = text.getBytes(StandardCharsets.UTF_8);   //konwersja podanego wejścia na tablicę bajtów
        String type = "MD5";                                  //definicja funkcji skrótu
        hash(type);
        type = "SHA-1";
        hash(type);
        type = "SHA-224";
        hash(type);
        type = "SHA-256";
        hash(type);
        type = "SHA-384";
        hash(type);
        type = "SHA-512";
        hash(type);
        type = "SHA3-224";
        hash(type);
        type = "SHA3-256";
        hash(type);
        type = "SHA3-384";
        hash(type);
        type = "SHA3-512";
        hash(type);
    }
}
