package touroll.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class GuiController {
    JButton elementButton;
    JFileChooser fc;

    public GuiController(JButton elementButton,
                         JFileChooser fc) {
        this.elementButton = elementButton;
        this.fc = fc;
    }

    public void addElement() {
        //Allow multiple files to be selected
        //Limit what can be selected to be txt files, md files, images
        //            int returnVal = fc.showOpenDialog(GuiFrame.this);
        //
        //            if (returnVal == JFileChooser.APPROVE_OPTION) {
        //                File file = fc.getSelectedFile();
        //                //Add file to the video
        //            }
    }

    public String generateVideo() {
        return null;
    }
}
