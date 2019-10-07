package Mygame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class myplane {
    private int speed = Constant.My_Plane_Speed;
    Image plane;
    //位置
    int x,y;
    int Face_Width = Constant.Face_Width;
    int Face_Height = Constant.Face_Height;
    int bodywidth = Constant.Body_Width;
    int bodyheight = Constant.Body_Height;
    boolean left,up,right,down;
    private boolean live = true;


    public void die(){
        live = false;
    }
    public void revive(){
        live = true;
    }
    public boolean islive(){
        return live;
    }
    public Rectangle gethead(){
        Rectangle h = new Rectangle(x+5,y+5,Face_Width,Face_Height);
        return h;
    }
    public Rectangle getbody(){
        Rectangle b = new Rectangle(x,y+17,bodywidth,bodyheight);
        return b;
    }

    public myplane(String path,int x,int y){
        this.x = x;
        this.y = y;
        //加载图片
        plane = GameUtil.getImage(path);
    }
    public void stop(KeyEvent e){
        switch(e.getKeyCode()){
            case 37:
                left = false;
                break;
            case 38:
                up = false;
                break;
            case 39:
                right = false;
                break;
            case 40:
                down = false;
                break;
        }
    }

    public void move(KeyEvent e){
        switch(e.getKeyCode()){
            case 37:
                left = true;
                break;
            case 38:
                up = true;
                break;
            case 39:
                right = true;
                break;
            case 40:
                down = true;
                break;
        }
    }

    private void move(){
       if(left){
           x-=speed;
       }
       if(right){
           x+=speed;
       }
       if(up){
           y-=speed;
       }
       if(down){
           y+=speed;
       }
    }

    public void draw(Graphics g) {
        if (live) {
            g.drawImage(plane, x, y, null);
            move();
        }
    }
}
