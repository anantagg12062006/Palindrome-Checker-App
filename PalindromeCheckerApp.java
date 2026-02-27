import java.util.Scanner;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class TwoPointerPalindromeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PalindromeStrategy strategy = new TwoPointerPalindromeStrategy();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();


        long startTime = System.nanoTime();

        boolean result = strategy.isPalindrome(input);


        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        if (result) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        System.out.println("Execution Time: " + duration + " nanoseconds");

        scanner.close();
    }
}