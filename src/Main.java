import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        FileEditor fileEditor = new FileEditor("balance.txt", "Log.txt");
        FrogLeap frogLeap = new FrogLeap(fileEditor);

        ArrayList<Contributor> contributors = fileEditor.readFile();

        contributors = (Main.SDDH(args[0]).equals("Init")) ?
                frogLeap.addNewContributor(contributors, Arrays.copyOfRange(args, 1, args.length)) :
                frogLeap.frogLeap(contributors, Main.SDDH(args[0]), Double.parseDouble(args[1]));


        fileEditor.writeBack(contributors);
    }

    public static String SDDH (String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
}
