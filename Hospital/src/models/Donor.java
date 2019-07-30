package models;

public class Donor {

    private String name;
    private BloodType bloodType;
    private int quantity;

    public Donor(String name, BloodType bloodType, int quantity) {
        this.name = name;
        this.bloodType = bloodType;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public int getQuantity() {
        return quantity;
    }
}