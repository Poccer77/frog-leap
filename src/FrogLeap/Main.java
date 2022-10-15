package FrogLeap;

import FrogLeap.FrogLeap;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {

        try {

            HashMap<String, Double> contributors = FileEditor.readFile();

            if (args[0].equalsIgnoreCase("init")) addContributor.add(contributors, Arrays.copyOfRange(args, 1, args.length));
            else {
                contributor payer = FrogLeap.frogLeap(contributors, args[0], Double.parseDouble(args[1]));
                contributors.put(payer.name, payer.account);
            }

            FileEditor.writeBack(contributors);
        }

        catch (IOException exc) {System.out.println("Error occurred while interacting with textfile");}
    }
}
