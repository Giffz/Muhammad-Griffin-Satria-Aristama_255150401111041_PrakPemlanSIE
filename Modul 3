// Vehicle.java
// class vehicle di deklarasi final sesuai soal no. 12 pada 
public final class Vehicle {
    Vehicle() {
        System.out.println("Vehicle is created");
    }

    protected void drive() {
        System.out.println("Vehicle is driving");
    }

    public void stop() {
        System.out.println("Vehicle is stopping");
    }
}

// Car.java
public class Car extends Vehicle {
// nanti di soal Hubungan Uses-A dan Has-A modifier akan di ganti ke public
private int numWheel = 4;

    Car() {
    System.out.println("Car is created");
    }

    public void drift() {
    System.out.println("Car is drifting");
    }

    public void honk() {
    System.out.println("Car is honking");
    }

    public int getNumWheel() {
        return this.numWheel;
    }
}

//Sedan.java
public class Sedan extends Car {
    public int numDoors = 3;
    
    public void trunk() {
        System.out.println("Sedan is opening trunk");
    }

    public void honk() {
        super.honk();
        System.out.println("Sedan is honking");
    }

    public void getNumWheels() {
        System.out.println("Sedan has " + getNumWheel() + " wheels");
    }
}

//AutomotiveApp.java
public class AutomotiveApp {
public static void main(String[] args) {
  Vehicle vehicle = new Vehicle();
  Car car = new Car();
  Sedan sedan = new Sedan();

  vehicle.drive();
  car.drive();
  sedan.drive();

  System.out.println("-----------------");
  car.drift();
  sedan.drift();

  System.out.println("-----------------");
  car.honk();
  sedan.honk();

  System.out.println("-----------------");
  sedan.getNumWheels();
  }
}

//Hubungan Uses-A dan Has-A
// Driver.java
public class Driver {
    private Car coupe; 

    public Driver() {
        System.out.println("Driver is created.");
    }

    public void driving() {
        System.out.println("Driver is driving.");
        
        this.coupe = new Car(); 
        
        System.out.println("Using a car that has " + this.coupe.numWheel + " wheels.");
    }
}

//Car.java
public class Car extends Vehicle {
public int numWheel = 4;

    Car() {
    System.out.println("Car is created");
    }

    public void drift() {
    System.out.println("Car is drifting");
    }

    public void honk() {
    System.out.println("Car is honking");
    }
}

//DrivingApp.java
public class DrivingApp {
public static void main(String[] args) {
    Driver miki = new Driver();
    miki.driving();
    }
}
