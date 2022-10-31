package FrogLeap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileEditor {

    public FileEditor() throws IOException {
    }

    public ArrayList<Contributor> readFile () throws IOException {

        BufferedReader br;

        try {br = new BufferedReader(new FileReader("balance.txt"));}
        catch (IOException exc) {
            File newFile = new File("balance.txt");
            newFile.createNewFile();
            br = new BufferedReader(new FileReader("balance.txt"));
        } //Try-catch to account for missing logfile

        ArrayList<Contributor> contributors = new ArrayList<>();

        String user = br.readLine();

        for (; user != null; user = br.readLine()) {
            contributors.add(
                    new Contributor(
                    user.substring(0, 1).toUpperCase() + user.substring(1), //capitalizes the first letter for prettiness
                    Double.parseDouble(br.readLine())));
        }

        br.close();
        return contributors;
    }

    public void writeBack(ArrayList<Contributor> contributors) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("balance.txt"));

        for (Contributor user : contributors){
            bw.write(user.name);
            bw.newLine();
            bw.write(Double.toString(user.account));
            bw.newLine();
        }

        bw.close();
    }
}
