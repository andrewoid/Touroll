package touroll.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class GuiFrame extends JFrame {

    private final JList<File> list;
    private final DefaultListModel<File> listModel;
    private final GuiController controller;
    private final JFileChooser fileChooser = new JFileChooser();

    public GuiFrame() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);

        //add the list to the main panel
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        controller = new GuiController(listModel, fileChooser, this);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        //panel to add length and width labels and buttons
        JPanel buttonPanel = new JPanel(new BorderLayout());
        //north button to add element
        JButton element = new JButton("Add Element");
        element.setPreferredSize(new Dimension(200, 65));
        buttonPanel.add(element, BorderLayout.NORTH);

        //add the action listener to the add element button
        element.addActionListener(e -> {
            controller.addElement();
        });

        //south button to generate video
        JButton generate = new JButton("Generate video");
        generate.setPreferredSize(new Dimension(200, 65));
        buttonPanel.add(generate, BorderLayout.SOUTH);

        //panel to set the width and height
        JPanel sizingPanel = new JPanel();
        sizingPanel.setLayout(new BoxLayout(sizingPanel, BoxLayout.Y_AXIS));

        JLabel width = new JLabel("Width");
        JTextField widthText = new JTextField();

        JLabel height = new JLabel("Height");
        JTextField heightText = new JTextField();

        sizingPanel.add(width);
        sizingPanel.add(widthText);
        sizingPanel.add(height);
        sizingPanel.add(heightText);
        buttonPanel.add(sizingPanel, BorderLayout.CENTER);

        mainPanel.add(buttonPanel, BorderLayout.EAST);
        setSize(700, 500);
        setTitle("Touroll");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
