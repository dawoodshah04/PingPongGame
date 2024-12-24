package PingPong;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH*(0.555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    Thread gameThread;
    Graphics graphics;
    Image image;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    private volatile boolean running = true;
    int timeLeft = 60; // Timer for 30 seconds
    javax.swing.Timer timer; // Swing timer
    public GamePanel(){
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        // Initialize the game timer
        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeLeft > 0) {
                    timeLeft--;
                } else {
                    timer.stop(); // Stop the timer when it reaches 0
                    //
                    //gameThread.interrupt(); // Stop the game loop thread
                    running = false;
                    if(score.player1 > score.player2){
                        JOptionPane.showMessageDialog(null, "Time's up! \n Palyer 1 Wins!! \nFinal Score:\nPlayer 1: " + score.player1 + "\nPlayer 2: " + score.player2);
                    }
                    else if(score.player1<score.player2){
                        JOptionPane.showMessageDialog(null, "Time's up! \n Palyer 2 Wins!! \nFinal Score:\nPlayer 1: " + score.player1 + "\nPlayer 2: " + score.player2);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Time's up! \n TIE!! \nFinal Score:\nPlayer 1: " + score.player1 + "\nPlayer 2: " + score.player2);
                    }


                    System.exit(0);
                }
            }
        });
        timer.start();

        gameThread = new Thread(this);
        gameThread.start();
    }


    public void newBall(){
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt((GAME_HEIGHT/2)-(BALL_DIAMETER/2)),BALL_DIAMETER,BALL_DIAMETER); //We have the same width and height of the ball thats why we passes balldiameter twice
    }
    public void newPaddles(){
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);  //why paddleheight/2?
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public void paint (Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);


    }
    public void draw (Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    public void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public void checkCollision(){

        //bounce ball off top and bottom window edges
        if(ball.y<=0){
            ball.setYDirection(-ball.yVelocity); //reverses direction of ball
        }
        if(ball.y>= GAME_HEIGHT-BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
        // Method to play sound

        //ball bounce of paddles , intersects is a built in class in rectangle
        if(ball.intersects(paddle1)){

            playSound(""); // Play sound

            ball.xVelocity = Math.abs(ball.xVelocity); //will reverse the direction, we can also simply multiply by a negative no
            ball.xVelocity++; //will increase speed of ball after each collsion, more difficult, optional
            if(ball.yVelocity>0){
                ball.yVelocity++;//will increase speed of ball after each collsion, more difficult, optional

            }
            else {
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

        }
        if(ball.intersects(paddle2)){
            playSound("F:\\audio.wav"); // Play sound

            ball.xVelocity = Math.abs(ball.xVelocity); //will reverse the direction, we can also simply multiply by a negative no
            ball.xVelocity++; //will increase speed of ball after each collsion, more difficult, optional
            if(ball.yVelocity>0){
                ball.yVelocity++;//will increase speed of ball after each collsion, more difficult, optional

            }
            else {
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

        }


        //this stops paddles at window edges
        if(paddle1.y <= 0){
            paddle1.y=0;
        }
        if(paddle1.y >= (GAME_HEIGHT)-(PADDLE_HEIGHT)){
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }
        if(paddle2.y <= 0){
            paddle2.y=0;
        }
        if(paddle2.y >= (GAME_HEIGHT)-(PADDLE_HEIGHT)){
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }

        //give a player  1 point and creates newball
        if(ball.x<=0){ // means if ball hit the left boundary, give player 2 a point
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2:  "+score.player2);
        }
        if(ball.x>= GAME_WIDTH-BALL_DIAMETER){
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1:  "+score.player1);
        }


    }
    public void run(){
//gameloop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (running){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta>=1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }


    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
