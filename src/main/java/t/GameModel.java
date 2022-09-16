package t;

import t.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }
    tank mytank;
    private GameModel() {

    }
    //List<bullet> bullets=new ArrayList<bullet>();
    //List<tank> tanks=new ArrayList<>();
    //Explode e=new Explode(100,100,this);
    //List<Explode> e=new ArrayList<>();
    List<GameObject> objects=new ArrayList<>();
    ColliderChain chain=new ColliderChain();
    public static GameModel getInstance(){
        return INSTANCE;
    }
    public void init() {
        mytank=new tank(200,400,dir.UP,Group.GOOD);
        int initTankCount=Integer.parseInt((String) Objects.requireNonNull(PropertyMgr.get("initTankCount")));
        for(int i=0;i<initTankCount;i++){
            new tank(50+i*80,200,dir.DOWN,Group.BAD);
        }
        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));
        add(new Wall(550,300,50,200));
    }
    public void add(GameObject go){
        this.objects.add(go);
    }
    public void remove(GameObject go){
        this.objects.remove(go);
    }
    public int size() {return this.objects.size();}
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
        g.setColor(c);
        mytank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        /*for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collidewith(tanks.get(j));

            }
        }*/
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject o1= objects.get(i);
                GameObject o2= objects.get(j);
                if(!chain.collide(o1,o2)){
                    break;
                };
            }
        }
    }

    public tank getmainTank() {
        return mytank;
    }
}
