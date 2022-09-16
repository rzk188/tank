package t.cor;

import t.*;

public class BulletWallCollider implements collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof bullet b && o2 instanceof Wall t){
            if (b.rect.intersects(t.rect)){
                b.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof bullet) {
            return collide(o2,o1);
        }
        return true;
    }
}
