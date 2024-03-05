package esercizi;

public class SommaCifraStringa {
    public static void main(String[] args) {
        String numeri = "12345";
        int somma = sommaCifre(numeri);
        System.out.println("Somma delle cifre: " + somma);
    }

    public static int sommaCifre(String numeri) {
        int somma = 0;

        // Itera attraverso i caratteri della stringa
        for (int i = 0; i < numeri.length(); i++) {
            // Converte il carattere corrente in un numero intero e lo somma alla somma totale
            somma += Character.getNumericValue(numeri.charAt(i));
        }

        return somma;
    }
}
