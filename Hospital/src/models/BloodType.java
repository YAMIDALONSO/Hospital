package models;

public enum BloodType {

    NEGATIVE_O("O-", 0), POSITIVE_O("O+", 0), NEGATIVE_A("A-", 0), POSITIVE_A("A+", 0),
    NEGATIVE_B("B-", 0), POSITIVE_B("B+", 0), NEGATIVE_AB("AB-", 0), POSITIVE_AB("AB+", 0);

    private String name;
    private int quantity;

    private BloodType(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}