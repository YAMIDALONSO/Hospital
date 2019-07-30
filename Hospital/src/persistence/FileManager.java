package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import models.BloodType;
import models.Donor;
import models.HospitalApp;
import models.User;

public class FileManager {

    private static final File FILE_USER = new File("./Files/Users.txt");
    private static final File FILE_DONOR = new File("./Files/Donors.txt");
    private static final String SEPARATOR = ":";

    public ArrayList<User> readUsers() throws FileNotFoundException, IOException {
        ArrayList<User> users = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_USER));
        String data = "";
        while ((data = bufferedReader.readLine()) != null) {
            String[] user = data.split(SEPARATOR);
            users.add(HospitalApp.createUser(user[0], user[1]));
        }
        bufferedReader.close();
        return users;
    }

    public ArrayList<Donor> readDonors() throws FileNotFoundException, IOException {
        ArrayList<Donor> donors = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_DONOR));
        String data = "";
        while ((data = bufferedReader.readLine()) != null) {
            String[] donor = data.split(SEPARATOR);
            donors.add(HospitalApp.createDonor(donor[0], BloodType.valueOf(donor[1]), Integer.parseInt(donor[2])));
        }
        bufferedReader.close();
        return donors;
    }

    public void writeUser(ArrayList<User> users) throws IOException {
        PrintWriter printWriter = new PrintWriter(FILE_USER);
        for (User user : users) {
            printWriter.write(user.getName() + SEPARATOR + user.getPassword());
            printWriter.println();
        }
        printWriter.close();
    }

    public void writeDonor(ArrayList<Donor> donors) throws IOException {
        PrintWriter printWriter = new PrintWriter(FILE_DONOR);
        for (Donor donor : donors) {
            printWriter.write(donor.getName() + SEPARATOR + donor.getBloodType() + SEPARATOR + donor.getQuantity());
            printWriter.println();
        }
        printWriter.close();
    }
}