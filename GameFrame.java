package PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GameFrame extends JFrame{
    GamePanel panel ;
    public GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("PONG GAME");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
