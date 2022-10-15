package FrogLeap;

import java.io.*;
import java.util.HashMap;

public class FileEditor {

    public FileEditor() throws IOException {
    }

    public static HashMap<String, Double> readFile () throws IOException {

        BufferedReader br;

        try {br = new BufferedReader(new FileReader("balance.txt"));}
        catch (IOException exc) {
            File newFile = new File("balance.txt");
            newFile.createNewFile();
            br = new BufferedReader(new FileReader("balance.txt"));
        }

        HashMap<String, Double> contributors = new HashMap<>();

        String user;

        while ((user = br.readLine()) != null) {
            contributors.put(user.substring(0, 1).toUpperCase() + user.substring(1), Double.parseDouble(br.readLine()));
        }

        br.close();

        return contributors;
    }

    public static void writeBack(HashMap<String, Double> contributors) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("balance.txt"));

        for (String User : contributors.keySet()){
            bw.write(User);
            bw.newLine();
            bw.write(contributors.get(User).toString());
            bw.newLine();
        }
        bw.close();
    }

}
