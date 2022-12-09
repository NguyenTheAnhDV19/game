import javax.swing.*;
import java.awt.*;

public class button extends JButton {
    button(){
        this.setUp();
    }

    public void setUp(){
        this.setText("again");
        this.setFocusable(false);
        this.setBackground(Color.MAGENTA);
        this.setVisible(false);
    }
}
