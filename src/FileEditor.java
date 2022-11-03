import java.io.*;
import java.util.ArrayList;

public class FileEditor {

    private File file;

    public FileEditor(String path) throws IOException {

        file = new File(path);
        System.out.println(file.getAbsolutePath());
    }

    public ArrayList<Contributor> readFile() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));

        ArrayList<Contributor> contributors = new ArrayList<>();
        String user = br.readLine();

        for (; user != null; user = br.readLine()) {
            contributors.add(new Contributor(Main.SDDH(user), Double.parseDouble(br.readLine())));
        }

        br.close();
        return contributors;
    }

    public void writeBack(ArrayList<Contributor> contributors) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (Contributor user : contributors){
            bw.write(user.name);
            bw.newLine();
            bw.write(Double.toString(user.account));
            bw.newLine();
        }

        bw.close();
    }
}
