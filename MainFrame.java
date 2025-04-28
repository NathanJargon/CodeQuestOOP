import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a label
        JLabel label = new JLabel("Hello, Swing!");
        label.setBounds(150, 50, 100, 30);
        frame.add(label);

        // Create a button
        JButton button = new JButton("Click Me");
        button.setBounds(150, 100, 100, 30);
        frame.add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}