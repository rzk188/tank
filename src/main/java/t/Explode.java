package t;

import java.awt.*;


public class Explode extends GameObject{
    public static int WIDTH= ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT= ResourceMgr.explodes[0].getHeight();
    private boolean living =true;
    private int step=0;
    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        GameModel.getInstance().add(this);
    }
    public void paint(Graphics g){
        /*Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("爆炸的数量：" + gm.size(), 10, 100);
        g.setColor(c);*/
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length) {
            GameModel.getInstance().remove(this);
        }
    }
    @Override
    public int getwidth() {
        return WIDTH;
    }

    @Override
    public int getheight() {
        return HEIGHT;
    }
}
