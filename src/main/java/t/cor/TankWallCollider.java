package t.cor;

import t.GameObject;
import t.Wall;
import t.bullet;
import t.tank;

public class TankWallCollider implements collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof tank b && o2 instanceof Wall t){
            if (b.rect.intersects(t.rect)){
                b.x=b.prex;
                b.y=b.prey;
            }
        } else if (o1 instanceof Wall && o2 instanceof tank) {
            return collide(o2,o1);
        }
        return true;
    }
}
