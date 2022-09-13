package factorymethod;

public class Carfactory {
    public Car create(){
        System.out.println("a car created");
        return new Car();
    }
}
