package org.urinal;

import java.util.Scanner;

/**
 * @author Paromita Roy
 */
public class Urinals {

    public static void main(String[] args) {
        int maxUrinals = 0;
        String input = getString();
        boolean res = validateInput(input);
        maxUrinals = countUrinals(input);
//        if(res == true) {
//            maxUrinals = countUrinals(input);
//        } else {
//            maxUrinals = -1;
//            System.out.println("Bad input.");
//            System.exit(0);
//        }
        System.out.println("Maximum number of urinals is " + maxUrinals);
    }

    public static boolean validateInput(String input) {
        boolean res = true;

        if(input.length() > 20) {
            res = false;
            return res;
        } else {
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) != '0' || input.charAt(i) != '1') {
                    res = false;
                    return res;
                }
            }
        }
        return res;
    }
    public static int countUrinals(String input) {
        int count = 0;
        int i = 0;

        for(i=1; i<input.length()-1; i++) {
            if(input.charAt(i-1) == '0' && input.charAt(i) == '0' && input.charAt(i+1) == '0') {
                count++;
                input.replace(input.charAt(i), '1');
            }
        }
        System.out.println("Count is " + count);
        return count;
    }

    // Fetches the string from the console and validates it.
    public static String getString() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string consisting of 1s and 0s. Do not enter spaces.");

        String input = sc.nextLine();

        return input;
    }
}
