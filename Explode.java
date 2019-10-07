package Mygame;

import Mygame.GameUtil;

import java.awt.*;

public class Explode {
    int x,y;
    static Image[] imgs = new Image[16];
    //初始化静态变量
    static{
        for(int i = 0;i<16;i++){
            imgs[i] = GameUtil.getImage("images/");
            //防止懒加载
            imgs[i].getWidth(null);
        }
    }
    int count;
    public void draw(Graphics g){
        if(count<=15){
            g.drawImage(imgs[count],x,y,null);
            count++;
        }
    }

    public Explode(int x,int y){
        this.x = x;
        this.y = y;
    }
}
