package assignment3;
import java.time.LocalDate;
public class Vehicle{
	String vin;
    LocalDate dateOfMfg;
    String make;
    String model;
    String color;
    int numberOfDoors;

    Vehicle(String vin, LocalDate dateOfMfg, String make, String model, String color, int numberOfDoors) {
        this.vin = vin;
        this.dateOfMfg = dateOfMfg;
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", dateOfMfg=" + dateOfMfg +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
	

}
