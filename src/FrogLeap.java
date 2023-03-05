import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrogLeap {

    FileEditor fileEditor;

    public FrogLeap(FileEditor fileEditor) {
        this.fileEditor = fileEditor;
    }

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
                System.out.println("Added " + name);
            }
        }

        return contributors;
    }

    public ArrayList<Contributor> frogLeap(ArrayList<Contributor> contributors, String name, double amount) throws IOException {

        Contributor bottom = null;

        if (contributors.isEmpty()) {
            throw new IllegalStateException("List of contributors is empty");
        }

        for (Contributor user : contributors){
            if (Objects.equals(user.name, Main.SDDH(name))){
                user.account = Math.ceil((user.account + amount) * 100) / 100; //eliminates rounding errors
            }
            if (bottom == null || bottom.account > user.account) {
                bottom = user;
            }
            System.out.println(user.name +  ", " + user.account);
        }

        String currentDate = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        fileEditor.log(name + ", " + amount + " | " + currentDate);

        System.out.println(bottom.name + " zahlt als naechstes");
        return contributors;
    }
}
