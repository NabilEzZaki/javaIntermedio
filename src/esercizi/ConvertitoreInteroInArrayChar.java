package esercizi;

public class ConvertitoreInteroInArrayChar {
    public static void main(String[] args) {
        int numero = 12345;
        String numeroStringa = Integer.toString(numero); // Converti l'intero in una stringa
        char[] arrayCaratteri = numeroStringa.toCharArray(); // Converti la stringa in un array di caratteri

        // Stampa l'array di caratteri
        System.out.println("Array di caratteri:");
        for (char c : arrayCaratteri) {
            System.out.print(c + " ");
        }
    }
}

