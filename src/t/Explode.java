package t;

import java.awt.*;


public class Explode {

    private int x,y;
    public static int WIDTH= ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT= ResourceMgr.explodes[0].getHeight();
    private boolean living =true;
    private int step=0;
    tankframe tf=null;
    public Explode(int x, int y, tankframe tf) {
        this.x = x;
        this.y = y;
        this.tf=tf;
    }
    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length) {
            tf.e.remove(this);
        }
    }
}
