package FrogLeap;

import java.io.*;
import java.util.ArrayList;

public class FileEditor {

    private BufferedReader br;
    private BufferedWriter bw;

    public FileEditor() throws IOException {

        File newFile = new File("balance.txt");
        newFile.createNewFile();
        br = new BufferedReader(new FileReader("balance.txt"));
        bw = new BufferedWriter(new FileWriter("balance.txt"));
    }

    public ArrayList<Contributor> readFile() throws IOException {

        ArrayList<Contributor> contributors = new ArrayList<>();
        String user = br.readLine();

        for (; user != null; user = br.readLine()) {
            contributors.add(new Contributor(Main.SDDH(user), Double.parseDouble(br.readLine())));
        }

        br.close();
        return contributors;
    }

    public void writeBack(ArrayList<Contributor> contributors) throws IOException {

        for (Contributor user : contributors){
            bw.write(user.name);
            bw.newLine();
            bw.write(Double.toString(user.account));
            bw.newLine();
        }

        bw.close();
    }
}
