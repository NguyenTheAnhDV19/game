import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pannel extends JPanel implements Runnable {
    keyInput keyinput = new keyInput();
    player Player = new player(keyinput);
    ball Ball = new ball(keyinput,Player);
    brick Brick = new brick(Ball) ;
    Thread thread = new Thread(this);
    long FPS = 2;

    Pannel() {
        thread.start();
        Ball.update();
        this.addKeyListener(keyinput);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        super.setBackground(Color.green);
        Ball.draw(g);
        Player.draw(g);
        Brick.draw(g);
    }
    public void update() throws InterruptedException  {
        Thread.sleep(FPS);
        Player.update();
        Brick.update();
    }

    public void new_game(){
        Brick.List_.clear();
        Ball.x = 200; Ball.y = 200;
        Ball.speedY = 0; Ball.speedX = 0;
        Brick.setUp();
    }

    @Override
    public void run() {
        while (thread != null){
            try {
                update();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            repaint();
        }
    }
}