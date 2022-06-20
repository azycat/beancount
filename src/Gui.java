import javax.swing.*;
import java.awt.*;

// Counts beans
public class Gui {
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        //frame.setSize(300,300);
        JButton button = new JButton("Press");
        JButton button2 = new JButton("Button 2");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30, 10, 30));
        panel.setLayout((new GridLayout(0, 1)));
        panel.add(button); // adds Button to content pane of frame
        panel.add(button2);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Goeey");
        frame.pack();


        frame.setVisible(true);
    }
}
