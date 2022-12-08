import java.awt.*;
public class ball extends entity implements Runnable {
    keyInput keyinput; player Player;
    public final int r = 20; long FPS = 5;
    public int speedX = 1; public int speedY = -1;
    Thread ballThread = new Thread(this);
    ball(keyInput keyinput,player Player){
        this.keyinput = keyinput;
        this.Player = Player;
        setDefault();
    }
    private void setDefault(){
        x = 200;
        y = 200;
    }
    public void update() {
        ballThread.start();
    }
    public void move() throws InterruptedException {
        Thread.sleep(FPS);
        if(keyinput.move == true) {
            x += speedX;
            y += speedY;
        }
    }
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x,y,r,r);
    }

    private void restrain(){
        if(x + 2*r >= 400 || x<= 0){
            speedX *= -1;
        }else if(y<= 0){
            speedY *= -1;
        }
    }

    private boolean lost(){
        if(y+20 >= 400){
            return true;
        }
        return false;
    }


    private void bouncePlayer(){
        if(library.Collide(x,Player.x,y,Player.y,r,Player.width,r,Player.height)== true){
            speedY *= -1;
        }
    }

    @Override
    public void run() {
       while(ballThread != null){
           try {
               restrain();
               bouncePlayer();
               move();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }
}
