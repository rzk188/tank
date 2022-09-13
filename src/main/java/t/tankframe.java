package t;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class tankframe extends Frame {
    GameModel gm=new GameModel();
    static final int GAME_WIDTH=800;
    static final int GAME_HEIGHT=600;

    public tankframe(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new Mykeylistener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }
    @Override
    public void paint(Graphics g) {
        gm.paint(g);

    }
    class Mykeylistener extends KeyAdapter{
        boolean bl=false;
        boolean bu=false;
        boolean br=false;
        boolean bd=false;
        @Override
        public void keyPressed(KeyEvent e) {
            //x+=100;
            //repaint();
            int key=e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT -> bl = true;
                case KeyEvent.VK_UP -> bu = true;
                case KeyEvent.VK_RIGHT -> br = true;
                case KeyEvent.VK_DOWN -> bd = true;
                default -> {
                }
            }
            setMainTankdir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //y+=100;
            //repaint();
            int key=e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT -> bl = false;
                case KeyEvent.VK_UP -> bu = false;
                case KeyEvent.VK_RIGHT -> br = false;
                case KeyEvent.VK_DOWN -> bd = false;
                case KeyEvent.VK_CONTROL -> gm.getmainTank().fire();
                default -> {
                }
            }
            setMainTankdir();
        }
        private void setMainTankdir(){
            tank mytank=gm.getmainTank();
            if (!bl && !bd && !br && !bu) mytank.setMoving(false);
            else {
                mytank.setMoving(true);
            if(bl) mytank.setDir1(dir.LEFT);
            if(br) mytank.setDir1(dir.RIGHT);
            if(bd) mytank.setDir1(dir.DOWN);
            if(bu) mytank.setDir1(dir.UP);
            }
        }
    }

}
