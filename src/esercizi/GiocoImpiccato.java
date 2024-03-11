package esercizi;

import java.util.Scanner;

public class GiocoImpiccato {
    private static final String[] PAROLE = {"ciao", "mondo", "java", "programmazione", "computer", "intelligenza"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parolaDaIndovinare = scegliParola();
        StringBuilder parolaCorrente = new StringBuilder();
        int tentativiRimasti = 6;
        boolean indovinato = false;

        // Inizializza la parola corrente con trattini per ogni lettera della parola da indovinare
        for (int i = 0; i < parolaDaIndovinare.length(); i++) {
            parolaCorrente.append("-");
        }

        while (tentativiRimasti > 0 && !indovinato) {
            System.out.println("Parola da indovinare: " + parolaCorrente);
            System.out.println("Tentativi rimasti: " + tentativiRimasti);
            System.out.print("Inserisci una lettera: ");
            char lettera = scanner.next().charAt(0);

            if (parolaDaIndovinare.indexOf(lettera) == -1) {
                System.out.println("La lettera " + lettera + " non è presente nella parola.");
                tentativiRimasti--;
            } else {
                for (int i = 0; i < parolaDaIndovinare.length(); i++) {
                    if (parolaDaIndovinare.charAt(i) == lettera) {
                        parolaCorrente.setCharAt(i, lettera);
                    }
                }

                if (parolaCorrente.toString().equals(parolaDaIndovinare)) {
                    indovinato = true;
                }
            }
        }

        if (indovinato) {
            System.out.println("Hai indovinato! La parola era: " + parolaDaIndovinare);
        } else {
            System.out.println("Hai perso! La parola era: " + parolaDaIndovinare);
        }

        scanner.close();
    }

    private static String scegliParola() {
        int indice = (int) (Math.random() * PAROLE.length);
        return PAROLE[indice];
    }
}

