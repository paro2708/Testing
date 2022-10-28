package org.urinal;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Paromita Roy
 */
public class Urinals {

    public static void main(String[] args) throws IOException {
        int maxUrinals = -1;
        ArrayList<String> fileContent = getString();
        ArrayList<Integer> resultUrinals = new ArrayList<>();
        for(String input : fileContent) {
            boolean res = validateInput(input);
            if (res == true) {
                maxUrinals = countUrinals(input);
            } else {
                maxUrinals = -1;
            }
            resultUrinals.add(maxUrinals);
            System.out.println("Maximum number of urinals is " + maxUrinals);
        }
        writeToOutputFile(resultUrinals);
    }

    public static void writeToOutputFile(ArrayList<Integer> result) throws IOException {
        File file = new File("rule.txt");
        int i = 1;
        FileWriter writer = null;
        if(file.exists() == true) {
            String currFile = "rule" + i + ".txt";
            File f = new File(currFile);
            while(f.exists() == true) {
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

        return inputs;
    }
}
