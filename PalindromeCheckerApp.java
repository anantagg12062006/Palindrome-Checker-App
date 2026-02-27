import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String input) {

        LinkedList<Character> list = new LinkedList<>();

        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        while (list.size() > 1) {
            char first = list.removeFirst();
            char last = list.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        scanner.close();
    }
}