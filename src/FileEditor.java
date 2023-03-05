import java.io.*;
import java.util.ArrayList;

public class FileEditor {

    private final File workFile;
    private final File backLog;

    public FileEditor(String path, String path2) throws IOException {

        workFile = new File(path);
        backLog = new File(path2);
        System.out.println(workFile.getAbsolutePath());
    }

    public ArrayList<Contributor> readFile() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(workFile));

        ArrayList<Contributor> contributors = new ArrayList<>();
        String user = br.readLine();

        for (; user != null; user = br.readLine()) {
            contributors.add(new Contributor(Main.SDDH(user), Double.parseDouble(br.readLine())));
        }

        br.close();
        return contributors;
    }

    public void writeBack(ArrayList<Contributor> contributors) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(workFile));

        for (Contributor user : contributors){
            bw.write(user.name);
            bw.newLine();
            bw.write(Double.toString(user.account));
            bw.newLine();
        }

        bw.close();
    }

    public void log(String entry) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(backLog, true));

        bw.write(entry);
        bw.newLine();

        bw.close();
    }
}
