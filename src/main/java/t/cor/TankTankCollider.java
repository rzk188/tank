package t.cor;

import t.GameObject;
import t.bullet;
import t.tank;

public class TankTankCollider implements collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof tank && o2 instanceof tank){
            tank t1=(tank) o1;
            tank t2=(tank) o2;
            if (t1.getRect().intersects(t2.getRect())){
                t1.x=t1.prex;
                t1.y=t1.prey;
                t2.x=t2.prex;
                t2.y=t2.prey;
            }
        }
        return true;
    }
}
