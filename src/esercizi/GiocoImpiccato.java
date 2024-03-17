package esercizi;

import java.util.Scanner;

public class GiocoImpiccato {
    private static final String[] PAROLE = {"cane", "recipiente", "casa", "albero", "computer", "banana"}; // Lista di parole
    private static final int MAX_TENTATIVI = 6; // Numero massimo di tentativi

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parolaDaIndovinare = scegliParola(); // Sceglie una parola a caso dalla lista
        StringBuilder parolaAttuale = new StringBuilder(parolaDaIndovinare.length());

        int numCaratteriVisibili = determinaNumeroCaratteriVisibili(parolaDaIndovinare.length());
        for (int i = 0; i < parolaDaIndovinare.length(); i++) {
            if (i < numCaratteriVisibili) {
                parolaAttuale.append(parolaDaIndovinare.charAt(i));
            } else {
                parolaAttuale.append('_');
            }
        }

        int tentativiRimasti = MAX_TENTATIVI;

        System.out.println("Benvenuto al Gioco dell'Impiccato!");
        System.out.println("Indovina la parola: " + parolaAttuale);

        while (tentativiRimasti > 0 && parolaAttuale.indexOf("_") != -1) {
            System.out.println("Tentativi rimasti: " + tentativiRimasti);
            System.out.print("Inserisci una lettera: ");
            char lettera = scanner.next().charAt(0);

            if (!aggiornaParola(parolaDaIndovinare, parolaAttuale, lettera)) {
                tentativiRimasti--;
                System.out.println("La lettera non è presente nella parola.");
            }
        }

        if (parolaAttuale.indexOf("_") == -1) {
            System.out.println("Complimenti! Hai indovinato la parola: " + parolaDaIndovinare);
        } else {
            System.out.println("Hai esaurito tutti i tentativi. La parola da indovinare era: " + parolaDaIndovinare);
        }
    }

    private static String scegliParola() {
        return PAROLE[(int) (Math.random() * PAROLE.length)];
    }

    private static int determinaNumeroCaratteriVisibili(int lunghezzaParola) {
        if (lunghezzaParola <= 6) {
            return 1;
        } else if (lunghezzaParola <= 10) {
            return 2;
        } else {
            return 3;
        }
    }

    private static boolean aggiornaParola(String parolaDaIndovinare, StringBuilder parolaAttuale, char lettera) {
        boolean trovata = false;
        for (int i = 0; i < parolaDaIndovinare.length(); i++) {
            if (parolaDaIndovinare.charAt(i) == lettera) {
                parolaAttuale.setCharAt(i, lettera);
                trovata = true;
            }
        }
        return trovata;
    }
}

