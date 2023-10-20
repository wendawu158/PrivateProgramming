package Projects.JavaGUI;

import javax.swing.*;
import java.awt.*;

public class _Lesson_3_Panels {

    public static void main(String[] args) {

        // JPanel = a GUI component that functions as a container to hold other components

        ImageIcon icon = new ImageIcon("D:\\Programming\\Java\\Projects\\JavaGUI\\TimetableIcon.png");

        JPanel redPanel = new JPanel(); // Creates a panel
        redPanel.setBackground(Color.RED); // Sets background colour of Panel
        redPanel.setBounds(0, 0, 250, 250); // Sets dimensions of Panel

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setBounds(250, 0, 250, 250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setBounds(0, 250, 250, 250);
        greenPanel.setLayout(new BorderLayout()); // Sets Panel Layout to left and centre
                                                  // Layout default is centre top

        JLabel label = new JLabel();
        label.setText("Hi");
        label.setIcon(icon);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setVisible(true);

        greenPanel.add(label); // Adds label component to panel

        // Panels can be thought of as containers, such as divisors in HTML

        frame.add(redPanel); // Adds panel to frame
        frame.add(bluePanel);
        frame.add(greenPanel);
    }
}
