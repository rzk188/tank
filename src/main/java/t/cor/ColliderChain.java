package t.cor;

import t.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements collider{
    private List<collider> colliders=new LinkedList<>();
    public ColliderChain() {
        add(new TankTankCollider());
        add(new BulletTankCollider());
    }
    public void add(collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1,o2)){
                return false;
            };
        }
        return true;
    }
}