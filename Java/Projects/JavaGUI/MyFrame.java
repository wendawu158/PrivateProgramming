package Projects.JavaGUI;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    MyFrame(){
        this.setTitle("JFrame title goes here"); // Sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits out of application on window close
        this.setResizable(false); // Prevents resizing of frame
        this.setSize(420, 420); // Sets the width and height
        this.setVisible(true); // Makes frame visible

        ImageIcon icon = new ImageIcon("D:\\Programming\\Java\\Projects\\JavaGUI\\TimetableIcon.png");
        // Creates an ImageIcon
        // For some reason this refuses to work with a relative path
        this.setIconImage(icon.getImage()); // Changes the icon of the window
        this.getContentPane().setBackground(Color.BLACK); // Changes the colour of the background
    }
}
