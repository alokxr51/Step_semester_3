package week1.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();

        for (int i = 0, j = characters.length - 1; i < j; i++, j--) {
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}
