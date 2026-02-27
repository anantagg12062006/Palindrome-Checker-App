import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Input from user
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Create Deque
        Deque<Character> deque = new LinkedList<>();
        
        // Insert characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        
        boolean isPalindrome = true;
        
        // Compare characters from both ends
        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            
            if (first != last) {
                isPalindrome = false;
                break;
            }
        }
        
        // Display result
        if (isPalindrome) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        
        scanner.close();
    }
}