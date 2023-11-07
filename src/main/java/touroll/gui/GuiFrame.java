package touroll.gui;

import javax.swing.*;
import java.awt.*;

public class GuiFrame extends JFrame {

    private final JScrollPane scrollPane;
    private final JList<String> list;
    final ListModel<String> listModel = new DefaultListModel<>();


    public GuiFrame() {
    //main GUI frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        setSize(700, 500);
        setTitle("Touroll");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //add the list to the main panel
        list = new JList<>(listModel);
        mainPanel.add(list);
        scrollPane = new JScrollPane(list);
        mainPanel.add(scrollPane, BorderLayout.WEST);

        //panel to add Frame length and width labels and buttons
        JPanel buttonPanel = new JPanel(new BorderLayout());

        //top button to add element
        JButton element = new JButton("Add element");
        buttonPanel.add(element, BorderLayout.NORTH);

        //panel to set the width and height
        JPanel dimensionPanel = new JPanel(new GridLayout(2,3));
        JLabel width = new JLabel("width");
        JTextField widthText = new JTextField();
        JButton submitWidth = new JButton("submit");
        JLabel height = new JLabel("height");
        JTextField heightText = new JTextField();
        JButton submitHeight = new JButton("submit");

        dimensionPanel.add(width);
        dimensionPanel.add(widthText);
        dimensionPanel.add(submitWidth);
        dimensionPanel.add(height);
        dimensionPanel.add(heightText);
        dimensionPanel.add(submitHeight);
        buttonPanel.add(dimensionPanel,BorderLayout.CENTER);

        //button to generate video
        JButton generate = new JButton("Generate video");
        buttonPanel.add(generate, BorderLayout.SOUTH);

        mainPanel.add(buttonPanel, BorderLayout.EAST);
    }

    //add dialouge box for adding a video element
}
