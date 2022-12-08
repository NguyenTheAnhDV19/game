import java.awt.*;

public class player extends entity implements Runnable {
    private int speed = 1;
    public final int width = 100;
    public final int height = 20;
    ball Ball;
    keyInput keyinput;

    player(keyInput keyinput) {
        this.setDefault();
        this.keyinput = keyinput;
    }

    private void setDefault(){
        x = 150;
        y = 350;
    }

    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

    public void update() {move();}

    public boolean restrainLeft(){
        if(x<= 0 ){
            return true;
        }
        return false;
    }
    public boolean restrainRight(){
        if(x>= 300 ){
            return true;
        }
        return false;
    }

    public void move() {
       if(keyinput.left == true && restrainLeft()== false){
           x-= speed;
       }else if(keyinput.right == true && restrainRight()== false){
           x+=speed;
       }
    }

    @Override
    public void run() {
        move();
    }
}
