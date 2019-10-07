package Mygame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;



public class GameFrame extends Frame {
    //创建需要的变量
    boolean hit = false;//碰撞变量
    double surviveTime;//存活时间
    Date startTime;
    Date endTime;
    long start;
    long end;
    //加载背景图片,素材
    Image bg = GameUtil.getImage("images/background1.png");
    myplane MainPlane = new myplane("images/lingmengsmall.png",Constant.My_Plane_X,Constant.My_Plane_Y);
    Bullets bullets = new Bullets();
    //Explode explode = new Explode();
    //框架，gui初始化
    public void launchFrame(){
        setSize(Constant.Frame_Width,Constant.Frame_Height);
        setVisible(true);
        setLocation(Constant.Frame_X,Constant.Frame_Y);
        //播放音乐
        MusicThread m = new MusicThread();
        m.start();

        //开始计时
        startTime = new Date();

        //启动线程
        new PaintThread().start();

        //键盘监听
        addKeyListener(new KeyMonitor());

        //窗口监听（关闭有效）
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }


    public void paint(Graphics g){
        //基本设置：颜色，字体，大小
        //Font f = new Font("宋体",Font.BOLD,100);
        //g.setFont(f);
        //g.drawString("Content",200,200);
        //g.setColor(Color.red);
        //g.fillOval();
        //加载背景(载入图片，素材)
        g.drawImage(bg,0,0,null);
        MainPlane.draw(g);
        bullets.draw(g);
        //碰撞检测
        if(MainPlane.islive()) {
            hit = GameUtil.checkhit(bullets, MainPlane);
            if (hit) {
                //结束计时
                endTime = new Date();
                MainPlane.die();
                double endtime = endTime.getTime();
                double starttime = startTime.getTime();
                surviveTime = (endtime - starttime) / 1000;//得到秒数
            }
        }
            if (!MainPlane.islive()) {
                GameUtil.printmessage(g, "GAME OVER", Constant.Frame_Width / 4, Constant.Frame_Height / 3, 80, Color.white);
                GameUtil.printmessage(g, "Survive Time: " + surviveTime + "s", Constant.Frame_Width / 4, Constant.Frame_Height / 3 + 50, 40, Color.white);
            }
    }
    //使图片动（线程开启）
    class PaintThread extends Thread{
        @Override
        public void run(){
            while(true){
                repaint();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class MusicThread extends Thread{
        private int i = 1;
        public void run(){
            Music mp3 = new Music("C:\\Users\\Mu Yi Zhu\\Desktop\\MyJAVAGame\\src\\music\\bgm ("+i+").mp3");
            mp3.play();
        }
        public void seti(int i){
            this.i = i;
        }
    }

    //键盘控制
    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            MainPlane.move(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            MainPlane.stop(e);
        }
    }
    //消除闪烁
    private Image offScreenImage = null;
    public void update(Graphics g){
        if(offScreenImage == null){
            offScreenImage = this.createImage(Constant.Frame_Width,Constant.Frame_Height);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }


    public static void main(String[] args){
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }
}
