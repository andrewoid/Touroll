package touroll.gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class GuiController {
    private final JFileChooser fc;
    private final JFrame gui;
    private final JList<File> fileList;
    private final DefaultListModel<File> defaultListModel;

    public GuiController(DefaultListModel<File> defaultListModel, JList<File> fileList, JFileChooser fc, GuiFrame guiFrame) {
        this.defaultListModel = defaultListModel;
        this.fileList = fileList;
        this.fc = fc;
        this.gui = guiFrame;
    }

    public void addElement() {
        // Allow multiple files to be selected
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);

        // Limit what can be selected to be txt files, md files, images
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Text Files (.txt, .md), Images", "txt", "md", "jpg", "jpeg", "png", "gif");
        fc.setFileFilter(fileFilter);

        int returnVal = fc.showOpenDialog(gui);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //Add file to the video
            defaultListModel.addElement(file);
        }
    }

    public String generateVideo() {
        return null;
    }
}
