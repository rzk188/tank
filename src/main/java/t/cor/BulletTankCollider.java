package t.cor;

import t.*;

public class BulletTankCollider implements collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof bullet && o2 instanceof tank){
            bullet b=(bullet) o1;
            tank t=(tank) o2;
            if (b.getGroup()!=t.group && b.rect.intersects(t.rect)){
                t.die();
                b.die();
                int ex=t.getX()+t.WIDTH/2- Explode.WIDTH/2;
                int ey=t.getY()+t.HEIGHT/2-Explode.HEIGHT/2;
                b.gm.add(new Explode(ex,ey,b.gm));
                return false;
            }
        } else if (o1 instanceof tank && o2 instanceof bullet) {
            return collide(o2,o1);
        }
        return true;
    }
}
