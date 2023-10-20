package Projects.JavaGUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class _Lesson_2_Labels {

    public static void main(String[] args) {

        // JLabel = a GUI display area for a string of text, an image, or both

        ImageIcon image = new ImageIcon("D:\\Programming\\Java\\Projects\\JavaGUI\\TimetableIcon.png");
        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);

        JLabel label = new JLabel(); // Creates a label
        label.setText("Bro, do you even code?"); // Set text of Label
        label.setIcon(image); // Set icon of Label

        // The default for a label is for the label to be horizontally left and centered vertically on the frame,
        // and for any text to be displayed to be on the right of any images

        label.setHorizontalTextPosition(JLabel.CENTER); // Changes the arrangement between the image and the text
                                                        // of the icon horizontally
        label.setVerticalTextPosition(JLabel.TOP); // Changes the arrangement between the image and the text of
                                                   // of the icon vertically
        label.setForeground(new Color(0x00FF00)); // Sets colour of text of label
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // Sets font of text of label
        label.setIconTextGap(100); // Sets gap between the text and image of label
        label.setBackground(Color.GRAY); // Sets background colour of label
        label.setOpaque(true); // Displays background colour
        label.setBorder(border); // Gives border to label
        label.setVerticalAlignment(JLabel.CENTER); // Sets vertical position of icon and text within label
        label.setHorizontalAlignment(JLabel.CENTER); // Sets horizontal position of icon and text within label

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label);

        /*
        // The Label, under the default settings, will always take up as much space as possible on the Frame
        // Below are methods to change that

        frame.setLayout(null); // Removes the default layout manager
        label.setBounds(0, 0, 250, 250); // Creating a fixed boundary for the Label
        */

        frame.pack(); // Minimises the window based on the minimum display size of the Labels

    }
}
