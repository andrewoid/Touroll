package touroll.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class GuiController {
    private final JButton elementButton;
    private final JFileChooser fc;
    private final JFrame gui;

    public GuiController(JButton elementButton, JFileChooser fc, GuiFrame guiFrame) {
        this.elementButton = elementButton;
        this.fc = fc;
        this.gui = guiFrame;
    }

    public void addElement() {
        // Allow multiple files to be selected
        // Limit what can be selected to be txt files, md files, images
        int returnVal = fc.showOpenDialog(gui);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //Add file to the video
        }
    }

    public String generateVideo() {
        return null;
    }
}
