package t;

import java.awt.*;


public class bullet extends GameObject{
    private static final int SPEED=10;
    private dir dir1;
    public static int WIDTH= ResourceMgr.bulletd.getWidth();
    public static int HEIGHT= ResourceMgr.bulletd.getHeight();
    private boolean living =true;
    private Group group=Group.BAD;
    public Rectangle rect=new Rectangle();

    public bullet(int x, int y, dir dir1,Group group) {
        this.x = x;
        this.y = y;
        this.dir1 = dir1;
        this.group=group;
        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
        GameModel.getInstance().add(this);
    }
    public void paint(Graphics g){
        /*Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量：" + gm.size(), 10, 60);
        g.setColor(c);*/
        if(!living){
            GameModel.getInstance().remove(this);
        }
        switch (dir1) {
            case LEFT -> g.drawImage(ResourceMgr.bulletl, x, y, null);
            case UP -> g.drawImage(ResourceMgr.bulletu, x, y, null);
            case DOWN -> g.drawImage(ResourceMgr.bulletd, x, y, null);
            case RIGHT -> g.drawImage(ResourceMgr.bulletr, x, y, null);
        }
        move();
    }

    @Override
    public int getwidth() {
        return WIDTH;
    }

    @Override
    public int getheight() {
        return HEIGHT;
    }

    private void move() {
        switch (dir1){
            case LEFT -> x-=SPEED;
            case RIGHT -> x+=SPEED;
            case UP -> y-=SPEED;
            case DOWN -> y+=SPEED;

        }
        if(x<0 || y<0 ||x>tankframe.GAME_WIDTH||y>tankframe.GAME_HEIGHT) living =false;
        rect.x=this.x;
        rect.y=this.y;
    }

    /*public boolean collidewith(tank tank) {
        if(this.group==tank.getGroup()) return false;
        //Rectangle rect1=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        //Rectangle rect2=new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);
        if (rect.intersects(tank.rect)){
            tank.die();
            this.die();
            int ex=tank.getX()+tank.WIDTH/2-Explode.WIDTH/2;
            int ey=tank.getY()+tank.HEIGHT/2-Explode.HEIGHT/2;
            gm.add(new Explode(ex,ey,this.gm));
            return true;
        }
        return false;

    }*/

    public void die() {
        this.living =false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
