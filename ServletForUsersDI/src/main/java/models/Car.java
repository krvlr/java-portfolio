package models;

import com.google.common.base.MoreObjects;

public class Car {

    private int id;
    private String brand;
    private String model;
    private int mileage;
    private String colour;

    public Car(int id, String brand, String model, int mileage, String colour){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", this.id)
                .add("brand", this.brand)
                .add("model", this.model)
                .add("mileage", this.mileage)
                .add("colour", this.colour)
                .toString();
    }
}


