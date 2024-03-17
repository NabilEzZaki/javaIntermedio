package esercizi;

import java.util.Scanner;

public class CifrarioDiCesare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input del testo e del numero di spostamenti
        System.out.print("Inserisci il testo: ");
        String testo = scanner.nextLine();
        System.out.print("Inserisci il numero di spostamenti: ");
        int spostamenti = scanner.nextInt();

        // Scelta tra cifrare o decifrare
        System.out.println("Vuoi cifrare (C) o decifrare (D)?");
        char scelta = scanner.next().toUpperCase().charAt(0);

        String risultato = "";
        if (scelta == 'C') {
            risultato = cifraCesare(testo, spostamenti);
        } else if (scelta == 'D') {
            risultato = decifraCesare(testo, spostamenti);
        } else {
            System.out.println("Scelta non valida.");
            return;
        }

        System.out.println("Risultato: " + risultato);
    }

    public static String cifraCesare(String testo, int spostamenti) {
        return trasforma(testo, spostamenti);
    }

    public static String decifraCesare(String testo, int spostamenti) {
        return trasforma(testo, -spostamenti);
    }

    private static String trasforma(String testo, int spostamenti) {
        StringBuilder risultato = new StringBuilder();

        // Itera attraverso ogni carattere nel testo
        for (int i = 0; i < testo.length(); i++) {
            char carattere = testo.charAt(i);

            // Controlla se il carattere è una lettera dell'alfabeto
            if (Character.isLetter(carattere)) {
                // Calcola la nuova posizione del carattere dopo lo spostamento
                char nuovoCarattere = (char) ('A' + (Character.toUpperCase(carattere) - 'A' + spostamenti) % 26);

                // Aggiungi il carattere cifrato al risultato
                risultato.append(Character.isLowerCase(testo.charAt(i)) ? Character.toLowerCase(nuovoCarattere) : nuovoCarattere);
            } else {
                // Se non è una lettera, aggiungi il carattere senza modificarlo
                risultato.append(carattere);
            }
        }

        return risultato.toString();
    }
}
