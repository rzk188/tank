package t;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    tank mytank=new tank(200,400,dir.UP,this,Group.GOOD);
    java.util.List<bullet> bullets=new ArrayList<bullet>();
    java.util.List<tank> tanks=new ArrayList<>();
    //Explode e=new Explode(100,100,this);
    List<Explode> e=new ArrayList<>();
    public GameModel() {
        int initTankCount=Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        for(int i=0;i<initTankCount;i++){
            tanks.add(new tank(50+i*80,200,dir.DOWN,this,Group.BAD));
        }
    }
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + e.size(), 10, 100);
        g.setColor(c);
        mytank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        for (int i=0; i<e.size();i++){
            e.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collidewith(tanks.get(j));

            }
        }
    }

    public tank getmainTank() {
        return mytank;
    }
}
