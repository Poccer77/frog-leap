package FrogLeap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class addContributor {

    public static void add(HashMap<String, Double> contributors, String[] usersToAdd) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("balance.txt", true));

        for (String name : usersToAdd){

            if (contributors.containsKey(name)) System.out.println("contributor is already included");

            else {
                bw.write(name.substring(0, 1).toUpperCase() + name.substring(1));
                bw.newLine();
                bw.write("0");
                bw.newLine();
            }
        }

        bw.close();
    }

}
