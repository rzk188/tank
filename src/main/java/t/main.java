package t;

public class main {
    public static void main(String[] args) throws InterruptedException {
        tankframe t=new tankframe();
        while (true){
            Thread.sleep(50);
            t.repaint();
        }
    }
}

