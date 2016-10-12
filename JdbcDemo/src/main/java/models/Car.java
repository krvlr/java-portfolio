package models;

public class Car {

    private int id;
    private int mileage;
    private String colour;

    public Car(int id, int mileage, String colour) {
        this.id = id;
        this.mileage = mileage;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public int getMileage() {
        return mileage;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return this.id + " " + this.mileage + " " + this.colour;
    }
}
