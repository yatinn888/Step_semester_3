package session_eight_topics.assignment_problems;

import java.util.Scanner;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getTypeName();
}

class BikeVehicle extends Vehicle {
    public BikeVehicle(int hours) { super(hours); }
    @Override public double calculateCharge() { return hours * 10.0; }
    @Override public String getTypeName() { return "BIKE"; }
}

class CarVehicle extends Vehicle {
    public CarVehicle(int hours) { super(hours); }
    @Override public double calculateCharge() {
        if (hours <= 1) return 30.0;
        return 30.0 + (hours - 1) * 20.0;
    }
    @Override public String getTypeName() { return "CAR"; }
}

class TruckVehicle extends Vehicle {
    public TruckVehicle(int hours) { super(hours); }
    @Override public double calculateCharge() {
        return Math.max(50.0 * hours, 100.0);
    }
    @Override public String getTypeName() { return "TRUCK"; }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hrs = scanner.nextInt();
            if (type.equals("BIKE")) {
                vehicles[i] = new BikeVehicle(hrs);
            } else if (type.equals("CAR")) {
                vehicles[i] = new CarVehicle(hrs);
            } else if (type.equals("TRUCK")) {
                vehicles[i] = new TruckVehicle(hrs);
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", v.getTypeName(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}