package OOPs_Practice;
//Practicing Concepts of OOPs here
//Encapsulation, Inheritance, Polymorphism, Abstraction
// 1. Encapsulation

public class vehicle {
    private String name;
    private String color;
    private int speed;
    private int price;

    public vehicle(String name, String color, int speed, int price) {
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
}

class car extends vehicle {
    private int noOfSeats;
    private String fuelType;

    public car(String name, String color, int speed, int price, int noOfSeats, String fuelType) {
        super(name, color, speed, price);
        this.noOfSeats = noOfSeats;
        this.fuelType = fuelType;
    }

    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Color: " + getColor());
        System.out.println("No of Seats: " + noOfSeats);
        System.out.println("Fuel Type: " + fuelType);
    }
}
class bike extends vehicle {
    private String type;

    public bike(String name, String color, int speed, int price, String type) {
        super(name, color, speed, price);
        this.type = type;
    }

    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Color: " + getColor());
        System.out.println("Type: " + type);
    }
}
class truck extends vehicle {
    private int loadCapacity;

    public truck(String name, String color, int speed, int price, int loadCapacity) {
        super(name, color, speed, price);
        this.loadCapacity = loadCapacity;
    }

    public void display() {
        System.out.println("Name: " + getName());
        System.out.println("Color: " + getColor());
        System.out.println("Load Capacity: " + loadCapacity);
    }
}
class vehicleMain {
    public static void main(String[] args) {
        car c = new car("BMW", "Black", 200, 5000000, 5, "Petrol");
        bike b = new bike("Yamaha", "Red", 150, 150000, "Sport");
        truck t = new truck("Volvo", "Blue", 80, 3000000, 10000);

        c.display();
        b.display();
        t.display();
    }
}
// 2. Inheritance

public class Animal {
    public void sound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal{
    @Override
    public void sound ()
    {
        System.out.println("Meow");
    }
}

// 3. Polymorphism
class Animal {
    public void sound() {
        System.out.println("Animal makes sound");
    }
}
//Runtime Polymorphism
class Dog extends Animal {
    // Method Overriding
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
    // Method Overloading
    public void sound(String name) {
        System.out.println(name + " barks");
    }
}
// Compile time Polymorphism
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
}

// 4. Abstraction
abstract class Animal {
    public abstract void sound();
    public void sleep() {
        System.out.println("Animal sleeps");
    }
}
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}
class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();

        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));
        System.out.println(calc.add(5.5, 10.5));
    }
}
// 5. Interface
interface Animal {
    void sound();
    void sleep();
}
class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }
}
class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
    @Override
    public void sleep() {
        System.out.println("Cat sleeps");
    }
}
class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
// 6. Abstract Class
abstract class Animal {
    public abstract void sound();
    public void sleep() {
        System.out.println("Animal sleeps");
    }
}
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}
class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
// 7. Interface vs Abstract Class
interface Animal {
    void sound();
    void sleep();
}
abstract class Mammal {
    public abstract void sound();
    public void sleep() {
        System.out.println("Mammal sleeps");
    }
}
class Dog extends Mammal implements Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Mammal implements Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}
class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
// 8. Multiple Inheritance
interface Animal {
    void sound();
}
interface Pet {
    void play();
}
class Dog implements Animal, Pet {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
    @Override
    public void play() {
        System.out.println("Dog plays");
    }
}
class Cat implements Animal, Pet {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
    @Override
    public void play() {
        System.out.println("Cat plays");
    }
}
class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        ((Pet) dog).play();

        Animal cat = new Cat();
        cat.sound();
        ((Pet) cat).play();
    }
}
