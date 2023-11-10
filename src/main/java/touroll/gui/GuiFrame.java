package touroll.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.newline;

public class GuiFrame extends JFrame {
    private JButton element = new JButton();
    final JFileChooser fc = new JFileChooser();


    final ListModel<String> listModel = new DefaultListModel<>();


    public GuiFrame() {
        final JScrollPane scrollPane;
        final JList<String> list;

        //main GUI frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        setSize(700, 500);
        setTitle("Touroll");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //add the list to the main panel
        list = new JList<>(listModel);
        scrollPane = new JScrollPane(list);


        mainPanel.add(scrollPane, BorderLayout.CENTER);

        //panel to add length and width labels and buttons
        JPanel buttonPanel = new JPanel(new BorderLayout());

        //north button to add element
        element = new JButton("Add Element");
        element.setPreferredSize(new Dimension(200, 65));
        buttonPanel.add(element, BorderLayout.NORTH);
        element.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Allow multiple files to be selected
                //Limit what can be selected to be txt files, md files, images
                int returnVal = fc.showOpenDialog(GuiFrame.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //Add file to the video
                }

            }
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


    }

}
