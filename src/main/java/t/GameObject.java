package t;

import java.awt.*;

public abstract class GameObject {
    public int x,y;

    public abstract void paint(Graphics g);
    public abstract int getwidth();
    public abstract int getheight();
}
