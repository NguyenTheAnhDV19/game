import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window
{
    private final int width = 400; private final int height = 400;
    final JFrame frame; Button button;
    public Window(Pannel pannel)
    {
        frame = new JFrame();
        frame.setSize(width,height);
        frame.setTitle("Game");
        frame.add(pannel);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
