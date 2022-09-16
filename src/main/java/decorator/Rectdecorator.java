package decorator;

import t.GameObject;

import java.awt.*;

public class Rectdecorator extends godecorator{

    public Rectdecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x= go.x;
        this.y=go.y;
        go.paint(g);
        Color c=g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(super.go.x,super.go.y,super.go.getwidth(),super.go.getheight());
        g.setColor(c);
    }
    @Override
    public int getwidth() {
        return super.go.getwidth();
    }

    @Override
    public int getheight() {
        return super.go.getheight();
    }
}
