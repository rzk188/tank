package t;

import singleton.Mgr01;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    private static final ResourceMgr INSTANCE=new ResourceMgr();
    private ResourceMgr(){};
    public static ResourceMgr getInstance(){
        return INSTANCE;
    }
    public static BufferedImage goodtankl,goodtankr,goodtanku,goodtankd;
    public static BufferedImage badtankl,badtankr,badtanku,badtankd;
    public static BufferedImage bulletl,bulletr,bulletd,bulletu;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
            goodtanku= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodtankr= ImageUtil.rotateImage(goodtanku,90);
            goodtankl= ImageUtil.rotateImage(goodtanku,-90);
            goodtankd= ImageUtil.rotateImage(goodtanku,180);
            badtanku= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badtankr= ImageUtil.rotateImage(badtanku,90);
            badtankl= ImageUtil.rotateImage(badtanku,-90);
            badtankd= ImageUtil.rotateImage(badtanku,180);
            bulletl= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletr= ImageUtil.rotateImage(bulletl,180);
            bulletu= ImageUtil.rotateImage(bulletl,90);
            bulletd= ImageUtil.rotateImage(bulletl,-90);
            for(int i=0;i<16;i++){
                explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
