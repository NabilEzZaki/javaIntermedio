package esercizi;

import java.util.Scanner;

public class GiocoImpiccato {
    private static final String[] PAROLE = {"cane", "gatto", "casa", "albero", "computer", "banana"}; // Lista di parole
    private static final int MAX_TENTATIVI = 6; // Numero massimo di tentativi

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parolaDaIndovinare = scegliParola(); // Sceglie una parola a caso dalla lista
        StringBuilder parolaAttuale = inizializzaParolaAttuale(parolaDaIndovinare); // Inizializza la parola attuale con caratteri visibili
        int tentativiRimasti = MAX_TENTATIVI;

        System.out.println("Benvenuto al Gioco dell'Impiccato!");
        System.out.println("Indovina la parola: " + parolaAttuale);

        while (tentativiRimasti > 0 && parolaAttuale.indexOf("_") != -1) {
            System.out.println("Tentativi rimasti: " + tentativiRimasti);
            System.out.println("Indovina una lettera o la parola intera: ");
            String input = scanner.nextLine();

            if (input.length() == 1) { // L'utente ha inserito una singola lettera
                char lettera = input.charAt(0);
                if (!aggiornaParola(parolaDaIndovinare, parolaAttuale, lettera)) {
                    tentativiRimasti--;
                    System.out.println("La lettera non è presente nella parola.");
                }
            } else if (input.length() == parolaDaIndovinare.length()) { // L'utente ha inserito l'intera parola
                if (input.equalsIgnoreCase(parolaDaIndovinare)) {
                    parolaAttuale = new StringBuilder(parolaDaIndovinare);
                } else {
                    tentativiRimasti--;
                    System.out.println("La parola inserita non è corretta.");
                }
            } else {
                System.out.println("Input non valido. Inserisci una singola lettera o la parola intera.");
            }

            System.out.println("Parola: " + parolaAttuale);
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

    private static StringBuilder inizializzaParolaAttuale(String parolaDaIndovinare) {
        StringBuilder parolaAttuale = new StringBuilder(parolaDaIndovinare.length());
        int numeroDiLettereVisibili = calcolaNumeroLettereVisibili(parolaDaIndovinare.length());
        for (int i = 0; i < parolaDaIndovinare.length(); i++) {
            if (i < numeroDiLettereVisibili) {
                parolaAttuale.append(parolaDaIndovinare.charAt(i));
            } else {
                parolaAttuale.append('_');
            }
        }
        return parolaAttuale;
    }

    private static int calcolaNumeroLettereVisibili(int lunghezzaParola) {
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
            if (Character.toLowerCase(parolaDaIndovinare.charAt(i)) == Character.toLowerCase(lettera)) {
                parolaAttuale.setCharAt(i, parolaDaIndovinare.charAt(i));
                trovata = true;
            }
        }
        return trovata;
    }
}
