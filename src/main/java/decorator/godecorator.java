package decorator;

import t.GameObject;

import java.awt.*;

public abstract class godecorator extends GameObject {
    GameObject go;
    public godecorator(GameObject go){
        this.go=go;
    };

    @Override
    public abstract void paint(Graphics g);
}
