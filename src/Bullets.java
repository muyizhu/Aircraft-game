package Mygame;

import java.awt.*;
import java.util.ArrayList;

public class Bullets {
    public ArrayList<Bullet> bullets = new ArrayList<>();
    public void loadbullets(int n){
        for(int i = 0;i< n;i++){
            Bullet b = new Bullet();
            bullets.add(b);
        }
    }
    public Bullets(int n){
        loadbullets(n);
    }
    public Bullets(){
        this(Constant.Default_Bullet_Number);
    }
    public void draw(Graphics g){
        for(Bullet b:bullets){
            b.draw(g);
        }
    }
}
