package t.abstractfactory;

import t.Group;
import t.*;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, dir dir, tankframe tf ,Group group);

    public abstract BaseBullet createBullet(int x, int y, dir dir, tankframe tf ,Group group);

    public abstract BaseExplode createExplode(int x,int y,tankframe tf);
}
