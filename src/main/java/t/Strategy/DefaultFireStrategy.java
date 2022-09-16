package t.Strategy;

import decorator.Rectdecorator;
import decorator.Taildecorator;
import t.GameModel;
import t.bullet;
import t.tank;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(tank t){
        int bx=t.x+tank.WIDTH/2- bullet.WIDTH/2;
        int by=t.y+tank.HEIGHT/2-bullet.HEIGHT/2;
        GameModel.getInstance().add(new Rectdecorator(new Taildecorator(new bullet(bx,by,t.dir1,t.group))));

    }
}
