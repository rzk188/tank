package t.abstractfactory;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collidewith(BaseTank tank);
}
