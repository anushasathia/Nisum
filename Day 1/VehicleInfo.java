class Vehicle {
    String brand;
    int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    int seats;

    Car(String brand, int year, int seats) {
        super(brand, year);
        this.seats = seats;
    }

    void displayCar() {
        displayInfo();
        System.out.println("Seats: " + seats);
    }
}

class Bus extends Vehicle {
    int capacity;

    Bus(String brand, int year, int capacity) {
        super(brand, year);
        this.capacity = capacity;
    }

    void displayBus() {
        displayInfo();
        System.out.println("Capacity: " + capacity);
    }
}

public class VehicleInfo {
    public static void main(String[] args) {
        Car c = new Car("Toyota", 2020, 5);
        Bus b = new Bus("Volvo", 2018, 40);
        c.displayCar();
        b.displayBus();
    }
}
