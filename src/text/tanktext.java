package text;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class tanktext {
    @Test
    public  void text1(){
        try {
            BufferedImage image=ImageIO.read(new File("F:/java/tank-main/src/images/bulletD.gif"));
            assertNotNull(image);
            BufferedImage image1=ImageIO.read(tanktext.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
