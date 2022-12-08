import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyInput implements KeyListener {
    public boolean left = false ; public boolean right = false;
    public boolean move = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
          right = true; move = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
             {
               left = true; move = true;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = false;
        }
    }
}
