package factorymethod;

public class simpleVehicleFactory {
    public Car createCar(){
        return  new Car();
    }
    public Broom createbroom(){
        return  new Broom();
    }
}
