package touroll.image;

import java.io.File;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import javax.imageio.ImageIO;

/**
 * Return original image - a potential copy
 */
public class ImageRenderer {

    // resize (must be even)
    // - maybe switch to png
    //      if all good don't touch the file
    public File prepare(File file) {
        return file;
    }
    //return original file now (late potential copy)

}
