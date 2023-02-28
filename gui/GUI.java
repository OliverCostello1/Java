package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    // Basic Graphical user interface

    // Button click counter
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private  JPanel panel;
    public GUI() {
        // Window frame
        frame = new JFrame();

        // Creating a clickable button
        JButton button = new JButton("Click me ");
        button.addActionListener(this);

        label = new JLabel("Number of Clicks: 0");

        // Layout panel
        panel = new JPanel();
        // Create border in panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        // set to the size
        frame.pack();
        frame.setVisible(true);
    }
    public static void  main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Increments count through this
        count++;
        label.setText("Number of Clicks: " + count);
    }
}
