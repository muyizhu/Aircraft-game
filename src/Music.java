package Mygame;


import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends JFrame {

    private String filename;
    private Player player;

    public Music(String filename) {
        this.filename = filename;
    }

    public void play() {
        try {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
            player = new Player(buffer);
                player.play();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        Music mp3 = new Music("C:\\Users\\Mu Yi Zhu\\Desktop\\MyJAVAGame\\src\\music\\bgm (5).mp3");
        mp3.play();
    }
}
