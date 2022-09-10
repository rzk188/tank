package abstractfactory;

import factorymethod.Carfactory;
import factorymethod.Moveable;

public class Main {
    public static void main(String[] args) {
        AbstractFactory f=new ModenFactory();
        Vehicle c=f.createVehicle();
        c.go();
        Food b=f.createFood();
        b.printname();
        Weapon w=f.createWeapon();
        w.shoot();
        //Plane p=new Plane();
        //p.go();
        //Moveable m=new Broom();
        //m.go();

    }
}
