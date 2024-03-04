package esercizi;

public class PalindromeCheck {
        public static boolean isPalindrome(int x) {
            // Convert the integer to a string
            String strX = String.valueOf(x);

            // Use two pointers to compare characters from both ends
            int left = 0;
            int right = strX.length() - 1;

            while (left < right) {
                // If characters at the left and right pointers are not equal, it's not a palindrome
                if (strX.charAt(left) != strX.charAt(right)) {
                    return false;
                }

                // Move the pointers towards the center
                left++;
                right--;
            }

            // If the loop completes without returning false, it's a palindrome
            return true;
        }
}
