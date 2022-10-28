package org.urinal;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Paromita Roy
 */
public class Urinals {

    // Driver code
    public static void main(String[] args) throws IOException {
        int maxUrinals;
        String file = "urinals.dat";
        ArrayList<String> fileContent = getString(file);
        ArrayList<Integer> resultUrinals = new ArrayList<>();
        for(String input : fileContent) {
            boolean res = validateInput(input);
            if (res) {
                maxUrinals = countUrinals(input);
            } else {
                maxUrinals = -1;
            }
            resultUrinals.add(maxUrinals);
            System.out.println("Maximum number of urinals is " + maxUrinals);
        }
        writeToOutputFile(resultUrinals);
    }

    // This method is responsible for writing the results to a file.
    // If rule.txt exists, it creates a new file- rule1.txt and writes to it.
    // If rule'x'.txt exists, it creates a new file- rule'x'.txt and writes to it.
    public static void writeToOutputFile(ArrayList<Integer> result) throws IOException {
        File file = new File("rule.txt");
        int i = 1;
        FileWriter writer;
        if(file.exists()) {
            String currFile = "rule" + i + ".txt";
            File f = new File(currFile);
            while(f.exists()) {
                i++;
                currFile = "rule" + i + ".txt";
                f = new File(currFile);
            }
            writer = new FileWriter(currFile);
        } else {
            writer = new FileWriter("rule.txt");
        }
        for(Integer res : result) {
            writer.write(res.toString());
            writer.write("\n");
        }
        writer.close();
    }

    // This method validates the input strings to check whether they consist
    // purely of 0s and 1s, and also checks that there no two consecutive
    // urinals that are occupied.
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

    // This function calculates the maximum count of urinals that can be used
    // according to the rule.
    public static int countUrinals(String input) {
        int count = 0;
        int i;

        for(i=1; i<input.length()-1; i++) {
            if(input.charAt(i-1) == '0' && input.charAt(i) == '0' && input.charAt(i+1) == '0') {
                count++;
                input.replace(input.charAt(i), '1');
            }
        }
        return count;
    }

    // Fetches the string from urinal.dat and stores the inputs into an arraylist.
    public static ArrayList<String> getString(String file) throws FileNotFoundException {
        BufferedReader r;
        ArrayList<String> inputs = new ArrayList<>();
        try {
            r = new BufferedReader(new FileReader(file));
            String line = r.readLine();

            while(line != null) {
                inputs.add(line);
                line = r.readLine();
            }
            r.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return inputs;
    }
}
