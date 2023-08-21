package week01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> vehicles = new ArrayList<>();

        Car car = new Car(4);
        Truck truck = new Truck(6);

        vehicles.add(car);
        vehicles.add(truck);

        for (Object vehicle : vehicles) {
            if (vehicle instanceof Car) {
                System.out.println("Car wheels: " + ((Car) vehicle).getNumberOfWheels());
            } else if (vehicle instanceof Truck) {
                System.out.println("Truck wheels: " + ((Truck) vehicle).getNumberOfWheels());
            }
        }
    }
}
