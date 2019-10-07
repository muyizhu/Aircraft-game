package Mygame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GameUtil {
    public static Image getImage(String path){
        URL u = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
   public static boolean checkhit(Bullets bullets,myplane MainPlane){
        for(Bullet b:bullets.bullets){
            if(b.getRect().intersects(MainPlane.gethead())||b.getRect().intersects(MainPlane.getbody())){
                return true;
            }
        }
        return false;
    }
    public static void printmessage(Graphics g,String message,int x,int y,int size,Color c){
        Font f = new Font("宋体",Font.BOLD,size);
        g.setFont(f);
        g.setColor(c);
        g.drawString(message,x,y);
    }
    public static void printRank(){}
}
