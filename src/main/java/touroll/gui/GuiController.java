package touroll.gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class GuiController {
    private final JFileChooser fileChooser;
    private final JFrame gui;
    private final DefaultListModel<File> defaultListModel;

    public GuiController(DefaultListModel<File> defaultListModel,
                         JFileChooser fileChooser,
                         GuiFrame guiFrame) {
        this.defaultListModel = defaultListModel;
        this.fileChooser = fileChooser;
        this.gui = guiFrame;
    }

    public void addElement() {
        // Allow multiple files to be selected
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);

        // Limit what can be selected to be txt files, md files, images
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(
                "Text Files (.txt, .md), " + "Images", "txt", "md", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(fileFilter);

        int returnVal = fileChooser.showOpenDialog(gui);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            //Add file to the video
            defaultListModel.addElement(file);
        }
    }

    public String generateVideo() {
        return null;
    }
}
