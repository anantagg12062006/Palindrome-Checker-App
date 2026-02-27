import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackPalindromeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


class PalindromeContext {
    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean execute(String input) {
        return strategy.isPalindrome(input);
    }
}

// Main Application
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PalindromeStrategy strategy = new StackPalindromeStrategy();
        PalindromeContext context = new PalindromeContext(strategy);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (context.execute(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}