package t;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frame {

    public static void main(String[] args) throws InterruptedException {
        int initTankCount=Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        tankframe t=new tankframe();
        for(int i=0;i<initTankCount;i++){
            t.tanks.add(new tank(50+i*80,200,dir.DOWN,t,Group.BAD));
        }
        while (true){
            Thread.sleep(50);
            t.repaint();

        }
    }
}

