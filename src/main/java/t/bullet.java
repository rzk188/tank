package t;

import t.abstractfactory.BaseBullet;
import t.abstractfactory.BaseTank;

import java.awt.*;


public class bullet extends BaseBullet{
    private static final int SPEED=10;
    private int x,y;
    private dir dir1;
    public static int WIDTH= ResourceMgr.bulletd.getWidth();
    public static int HEIGHT= ResourceMgr.bulletd.getHeight();
    private boolean living =true;
    tankframe tf=null;
    private Group group=Group.BAD;
    Rectangle rect=new Rectangle();

    public bullet(int x, int y, dir dir1,tankframe tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir1 = dir1;
        this.tf=tf;
        this.group=group;
        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
        tf.bullets.add(this);
    }
    public void paint(Graphics g){
        if(!living){
            tf.bullets.remove(this);
        }
        switch (dir1) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletl, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletu, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletd, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletr, x, y, null);
                break;
        }
        move();
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

    public void collidewith(BaseTank tank1) {
        if(this.group==tank1.getGroup()) return;
        //Rectangle rect1=new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        //Rectangle rect2=new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);
        if (rect.intersects(tank1.rect)){
            tank1.die();
            this.die();
            int ex=tank1.getX()+tank.WIDTH/2-Explode.WIDTH/2;
            int ey=tank1.getY()+tank.HEIGHT/2-Explode.HEIGHT/2;
            tf.e.add(tf.gf.createExplode(ex,ey,this.tf));
        }

    }

    private void die() {
        this.living =false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
