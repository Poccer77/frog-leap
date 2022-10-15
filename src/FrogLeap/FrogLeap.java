package FrogLeap;

import java.io.*;
import java.util.HashMap;

public class FrogLeap {

    public static contributor frogLeap(HashMap<String, Double> contributors, String name, double amount) throws IOException {

        name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        double newAmount = (Math.ceil((contributors.get(name) + amount) * 100)) / 100;

        contributors.put(name, newAmount);

        contributor bottom = null;

        for (String user : contributors.keySet()){
            if (bottom == null || bottom.account > contributors.get(user)) bottom = new contributor(user, contributors.get(user));
            System.out.println(user +  ", " + contributors.get(user));
        }

        System.out.println(bottom.name + " zahlt als naechstes");

        return new contributor(name, newAmount);
    }
}
