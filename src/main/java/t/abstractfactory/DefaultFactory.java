package t.abstractfactory;
import t.*;

public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, dir dir1,tankframe tf,Group group){
        return new tank(x,y,dir1,tf,group);
    }
    @Override
    public BaseExplode createExplode(int x, int y,tankframe tf){
        return new Explode(x,y,tf);
    }
    @Override
    public BaseBullet createBullet(int x, int y, dir dir1,tankframe tf,Group group){
        return new bullet(x,y,dir1,tf,group);
    }

}
