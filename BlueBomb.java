


package javagame;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.net.URL;

public class BlueBomb {
    Image img;
    public int y= (int)(Math.random()*300)+20;
    public int x=(int)(Math.random()*900)+20;
    BlueBomb(){
        String imageLocation = "img/BlueBomb.png";
        URL imageURL = this.getClass().getResource(imageLocation);
        img = Toolkit.getDefaultToolkit().getImage(imageURL);
        runner.start();
    }
    Thread runner = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true){
                y+=2;
                if(y>=1000){
                    img = null;
                    runner = null;
                    x = -500;
                    y = -500;
                }
                try{
                    runner.sleep(10);
                }catch(InterruptedException e){}
            }
        }
    });

    public Image getImage(){
        return img;
    }

    public int getX(){

        return x;
    }
    public int getY(){

        return  y;
    }
    public Rectangle2D HitBox(){
        return (new Rectangle2D.Double(x,y,30,30));
    }
}


