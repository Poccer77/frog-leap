package FrogLeap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class FrogLeap {

    public ArrayList<Contributor> addNewContributor(ArrayList<Contributor> contributors, String[] names) {

        for (String name : names) {
            Contributor newContributor = new Contributor(Main.SDDH(name), 0);
            boolean userAlreadyExists = false;
            for (Contributor user : contributors) {
                if (Objects.equals(user.name, newContributor.name)) {
                    System.out.println("User already exists");
                    userAlreadyExists = true;
                    break;
                }
            }
            if (!userAlreadyExists) {
                contributors.add(newContributor);
            }
        }

        return contributors;
    }

    public ArrayList<Contributor> frogLeap(ArrayList<Contributor> contributors, String name, double amount) throws IOException {

        Contributor bottom = null;

        for (Contributor user : contributors){
            if (Objects.equals(user.name, Main.SDDH(name))){
                user.account = Math.ceil((user.account + amount) * 100) / 100;
            }
            if (bottom == null || bottom.account > user.account) {
                bottom = user;
            }
            System.out.println(user.name +  ", " + user.account);
        }

        System.out.println(bottom.name + " zahlt als naechstes");
        return contributors;
    }
}
