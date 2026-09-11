package week1.class_problems;

import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    static String result(boolean value) {
        return value ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + result(isPalindromeIterative(text)));
        System.out.println("Recursive: " + result(isPalindromeRecursive(text)));
        System.out.println("Array Reversal: " + result(isPalindromeArrayReversal(text)));

        sc.close();
    }
}
