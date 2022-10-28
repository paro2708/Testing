package org.urinal;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Paromita Roy
 */
public class Urinals {

    public static void main(String[] args) {
        int maxUrinals = -1;
        ArrayList<String> fileContent = getString();
        for(String input : fileContent) {
            boolean res = validateInput(input);
            if (res == true) {
                maxUrinals = countUrinals(input);
            } else {
                maxUrinals = -1;
            }
            writeToOutputFile(maxUrinals);
            System.out.println("Maximum number of urinals is " + maxUrinals);
        }
//        System.out.println("Maximum number of urinals is " + maxUrinals);
    }

    public static void writeToOutputFile(int result) {

    }

    public static boolean validateInput(String input) {
        boolean res = true;

        if(input.length() > 20) {
            res = false;
            return res;
        } else {
            for (int i = 0; i < input.length(); i++) {
                if(i==0) {
                    if(input.charAt(0) == '1' && input.charAt(1) == '1') {
                        res = false;
                    }
                } else if(input.charAt(i) == '1' && input.charAt(i-1) == '1') {
                    res = false;
                }
                if(!(input.charAt(i) == '0' || input.charAt(i) == '1')) {
                    res = false;
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
        return count;
    }

    // Fetches the string from the console and validates it.
    public static ArrayList<String> getString() {
        BufferedReader r;
        ArrayList<String> inputs = new ArrayList<>();
        try {
            r = new BufferedReader(new FileReader("C:\\Users\\Paromita Roy\\Documents\\Fall22\\SER515\\Assignments\\Testing\\Urinal\\src\\main\\java\\org\\urinal\\urinals.dat"));
            String line = r.readLine();

            while(line != null) {
                inputs.add(line);
                line = r.readLine();
            }
            r.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter string consisting of 1s and 0s. Do not enter spaces.");
//
//        String input = sc.nextLine();

        return inputs;
    }
}
