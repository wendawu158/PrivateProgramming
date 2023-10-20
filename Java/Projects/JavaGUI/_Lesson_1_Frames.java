package Projects.JavaGUI;

public class _Lesson_1_Frames {
    public static void main(String[] args) {

        // JFrame = a GUI window to add components to
        /*

        // Creates a JFrame procedurally, which is not really Java's strong suit

        JFrame frame = new JFrame(); // Creates a frame
        frame.setTitle("JFrame title goes here"); // Sets title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exits out of application on window close
        frame.setResizable(false); // Prevents resizing of frame
        frame.setSize(420, 420); // Sets the width and height
        frame.setVisible(true); // Makes frame visible

        ImageIcon icon = new ImageIcon("D:\\Programming\\Java\\Projects\\JavaGUI\\TimetableIcon.png");
        // Creates an ImageIcon
        // For some reason this refuses to work with a relative path
        frame.setIconImage(icon.getImage()); // Changes the icon of the window
        frame.getContentPane().setBackground(Color.BLACK); // Changes the colour of the background
        */

        // Creates a JFrame using an object, which is better in java
        // This code does the same thing as the above procedural code
        /*
        MyFrame myFrame = new MyFrame();
        */

        // Creates a frame without an address
        new MyFrame();


    }
}
