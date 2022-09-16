package decorator;

import t.GameObject;

import java.awt.*;

public class Taildecorator extends godecorator{

    public Taildecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x= go.x;
        this.y=go.y;
        go.paint(g);
        Color c=g.getColor();
        g.setColor(Color.RED);
        g.drawLine(go.x,go.y,go.x+getwidth(),go.y+getheight());
        g.setColor(c);
    }
    @Override
    public int getwidth() {
        return go.getwidth();
    }

    @Override
    public int getheight() {
        return super.go.getheight();
    }
}
