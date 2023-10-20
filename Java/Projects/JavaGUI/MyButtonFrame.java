package Projects.JavaGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButtonFrame extends JFrame implements ActionListener {

    JButton button;

    MyButtonFrame(){

        ImageIcon icon = new ImageIcon("D:\\Programming\\Java\\Projects\\JavaGUI\\TimetableIcon.png");

        button = new JButton();
        button.setBounds(100, 100, 250, 100);
        button.addActionListener(this);
        button.setText("I'm a button!");
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Helvetica", Font.BOLD, 20));
        button.setIconTextGap(-15);
        button.setForeground(Color.CYAN);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button) {
            System.out.println("Hello");
        }
    }
}
