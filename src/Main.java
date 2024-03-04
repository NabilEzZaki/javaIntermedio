import static esercizi.PalindromeCheck.isPalindrome;
import static esercizi.TwoSum.twoSum;

public class Main {
    public static void main(String[] args) {
        //PALINDROME
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@----PALINDROME----@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        int x = 121;
        boolean result = isPalindrome(x);
        System.out.println("Is " + x + " a palindrome? " + result);

        //TWO SUM
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@---TWOSUM---@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("\n" +
                "Dato un array di numeri interi e un target intero, restituisce gli indici dei due numeri in modo tale che la loro somma dia target.");
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] risultato = twoSum(nums, target);

        if (risultato != null) {
            System.out.println("Indices: " + risultato[0] + ", " + risultato[1]);
        } else {
            System.out.println("No solution found.");
        }
    }
}