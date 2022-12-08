import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class brick extends entity{

    private final int width = 100; private final int height = 20; private final int arcWidth = 20; private final int arcHeight = 20;
    List<Integer> List_= new ArrayList<Integer>();
    ball Ball;
    brick(ball Ball){
        this.Ball = Ball;
        this.setUp();
    }

    public void setUp(){
        Collections.addAll(List_,0,0,0,20,0,40,0,60,100,0,100,20,100,40,100,60,200,0,200,20,200,40,200,60,300,0,300,20,300,40,300,60);
    }
    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for(int i =0; i< List_.size()-1 ;i++){
            if(i== 0 || i%2 ==0) {
                g.fillRoundRect(List_.get(i), List_.get(i + 1), width, height, arcWidth, arcHeight);
            }
        }
    }
    public void collide(){
        List<Integer>Remove = new ArrayList<Integer>();
        for(int i =0;i< List_.size()-1 ;i++) {
           if (i == 0 || i % 2 == 0) {
               if (library.Collide(Ball.x, List_.get(i), Ball.y, List_.get(i + 1), Ball.r, width, Ball.r, height) == true ) {
                   Collections.addAll(Remove, i, i);
                   if (library.collideX(Ball.x, List_.get(i), Ball.y, List_.get(i + 1), Ball.r, width, Ball.r, height) == true && Remove.size() == 2 ) {
                       Ball.speedX *= -1;
                   } else if(Remove.size() == 2) {
                       Ball.speedY *= -1;
                   }
               }
           }
       }
       remove(Remove);
    }

    private boolean checkList(List<Integer>Remove){
        if(Remove.isEmpty() == true){
            return true;
        }
        return false;
    }

    private void remove(List<Integer> Remove){
        if(checkList(Remove) == false){
            Collections.reverse(Remove);
            for(Integer index : Remove) {
                List_.remove((int) index);
            }
        }
    }
    public void update(){
        collide();
    }
}
