package Mygame;

import java.awt.*;

public class Bullet {
    double x,y;
    int speed = Constant.Bullet_Speed;
    double degree;
    int width=5;
    int height=5;
    boolean hit;

    public Bullet(){
        x = Constant.Frame_Width/2;
        y = Constant.Frame_Height/2;
        degree = Math.random()*(Math.PI*2);
    }

    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillOval((int)x,(int)y,width,height);
        x+=speed*Math.cos(degree);
        y+=speed*Math.sin(degree);
        if(y>Constant.Frame_Height-5-height||y<30+height){
            degree = -degree;
        }
        if(x<width||x>Constant.Frame_Width-5-width){
            degree = Math.PI-degree;
        }
        g.setColor(c);
    }
}
