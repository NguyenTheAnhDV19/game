import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class Pannel extends JPanel implements Runnable {
    button Button_ = new button();
    keyInput keyinput = new keyInput();
    player Player = new player(keyinput);
    ball Ball = new ball(keyinput,Player);
    brick Brick = new brick(Ball) ;
    Thread thread = new Thread(this);
    long FPS = 2;

    Pannel() {
        thread.start();
        Ball.update();
        this.add(Button_);
        this.setBounds(0,0,400,400);
        this.addKeyListener(keyinput);
        this.setFocusable(true);
        Button_.addActionListener(e -> press());
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
        displayButton();
    }

    public void displayButton(){
        if(Ball.lost() == true){
            Button_.setVisible(true);
            Button_.setFocusable(true);
        }else{
            Button_.setVisible(false);
            Button_.setFocusable(false);
        }
    }

    public void press(){
        Brick.List_.clear();
        Collections.addAll(Brick.List_,0,0,0,20,0,40,0,60,100,0,100,20,100,40,100,60,200,0,200,20,200,40,200,60,300,0,300,20,300,40,300,60);
        Ball.setDefault();
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
