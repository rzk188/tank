package t;

import java.awt.*;
import java.util.Random;


public class tank {
    public Rectangle rect=new Rectangle();
    int x, y;
    private Random random=new Random();
    private boolean living=true;
    Group group=Group.BAD;
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    tankframe tf=null;
    private boolean moving=true;
    public dir getDir1() {
        return dir1;
    }
    public void setDir1(dir dir1) {
        this.dir1 = dir1;
    }
    dir dir1 = dir.DOWN;
    private static final int SPEED = 5;
    public static int WIDTH= ResourceMgr.goodtankl.getWidth();
    public static int HEIGHT= ResourceMgr.goodtankl.getHeight();
    FireStrategy fs=new FourDirFireStrategy();
    public tank(int x, int y ,dir dir1,tankframe tf,Group group) {
        super();
        this.x=x;
        this.y=y;
        this.dir1=dir1;
        this.tf=tf;
        this.group=group;
        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
        if(group==Group.GOOD)fs=new FourDirFireStrategy();
        else fs=new DefaultFireStrategy();
    }

    public void paint(Graphics g) {
        //g.fillRect(x,y,50,50);
        //x+=10;
        //y+=10;
        if(!living){
            tf.tanks.remove(this);
        }

        switch (dir1) {
            case LEFT:
                g.drawImage(this.group==Group.GOOD? ResourceMgr.goodtankl : ResourceMgr.badtankl, x, y, null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD? ResourceMgr.goodtanku : ResourceMgr.badtanku, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD? ResourceMgr.goodtankd : ResourceMgr.badtankd, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD? ResourceMgr.goodtankr : ResourceMgr.badtankr, x, y, null);
                break;
        }
        move();
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void move() {
        if(!moving) return;
        switch (dir1){
            case LEFT -> x-=SPEED;
            case RIGHT -> x+=SPEED;
            case UP -> y-=SPEED;
            case DOWN -> y+=SPEED;

        }
        if (this.group==Group.BAD && random.nextInt(10)>8) this.fire();
        if (this.group==Group.BAD&& random.nextInt(10)>8) randomDir();
        boundsCheck();
        rect.x=this.x;
        rect.y=this.y;
    }

    private void boundsCheck() {
        if(this.x<2) x=2;
        else if (this.y<28)y=28;
        else if (this.x>tankframe.GAME_WIDTH-tank.WIDTH-2) {
            x=tankframe.GAME_WIDTH-tank.WIDTH-2;
        } else if (this.y>tankframe.GAME_HEIGHT-tank.HEIGHT-2) {
            y=tankframe.GAME_HEIGHT-tank.HEIGHT-2;
        }

    }

    private void randomDir() {
        this.dir1=dir.values()[random.nextInt(4)];
    }


    public void fire() {
        fs.fire(this);
    }

    public void die() {
        this.living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
