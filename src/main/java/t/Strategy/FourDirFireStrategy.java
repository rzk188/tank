package t.Strategy;

import t.bullet;
import t.dir;
import t.tank;

public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(tank t){
        int bx=t.x+tank.WIDTH/2- bullet.WIDTH/2;
        int by=t.y+tank.HEIGHT/2-bullet.HEIGHT/2;
        dir[] dirs=dir.values();
        for (dir dir2 : dirs) {
            new bullet(bx,by,dir2,t.group);
        }

    }
}
