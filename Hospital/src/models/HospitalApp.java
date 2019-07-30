package models;

import java.util.ArrayList;

public class HospitalApp {

    public static final int REFRIGERATION_TEMPERATURE = 2;
    public static final int NORMAL_STATUS = 10;
    public static final int ALERT_STATUS = 30;
    public static final int MAX_CAPACITY = 100;
    public static final String NORMAL_STATUS_STRING = "NORMAL";
    public static final String ALERT_STATUS_STRING = "ALERTA";
    public static final String CRITICAL_STATUS = "CRITICO";

    private ArrayList<User> users;
    private ArrayList<Donor> donors;
    private static int totalBloodInWarehouse;

    public HospitalApp(ArrayList<User> users, ArrayList<Donor> donors) {
        this.users = users;
        this.donors = donors;
    }

    public static User createUser(String name, String password) {
        return new User(name, password);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean isUserAndPasword(String user, String password) {
        boolean isUserAndPassword = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(user) && users.get(i).getPassword().equals(password)) {
                isUserAndPassword = true;
            }
        }
        return isUserAndPassword;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public static Donor createDonor(String name, BloodType bloodType, int quantity) {
        int quantityInWarehouse = bloodType.getQuantity();
        bloodType.setQuantity(quantityInWarehouse += quantity);
        totalBloodInWarehouse += bloodType.getQuantity();
        return new Donor(name, bloodType, quantity);
    }

    public void addDonor(Donor donor) {
        donors.add(donor);
    }

    public String getStatus() {
        String status = "";
        int percentageStatus = ((MAX_CAPACITY - totalBloodInWarehouse) * 100) / MAX_CAPACITY;
        if (percentageStatus < NORMAL_STATUS) {
            status = CRITICAL_STATUS;
        } else if (percentageStatus >= NORMAL_STATUS && percentageStatus <= ALERT_STATUS) {
            status = ALERT_STATUS_STRING;
        } else if (percentageStatus > ALERT_STATUS && percentageStatus <= MAX_CAPACITY) {
            status = CRITICAL_STATUS;
        }
        return status;
    }

    public boolean removeBlood(BloodType bloodType, int quantity) {
        boolean isPossibleRemove = false;
        if (quantity < bloodType.getQuantity()) {
            isPossibleRemove = true;
            totalBloodInWarehouse -= quantity;
        }
        return isPossibleRemove;
    }

    public ArrayList<Donor> getDonors() {
        return donors;
    }

    public int consultRestantAmount(BloodType category) {
        return category.getQuantity();
    }

}
