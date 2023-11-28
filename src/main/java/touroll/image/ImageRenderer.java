package touroll.image;

import org.jetbrains.annotations.Nullable;
import touroll.Renderer;
import touroll.VideoElement;

import java.io.File;

/**
 * Return original image - a potential copy
 */
public class ImageRenderer implements Renderer {

    // resize (must be even)
    // - maybe switch to png
    //      if all good don't touch the file
    public File prepare(File file) {
        return file;
    }

    @Override
    public boolean isFileType(File file) {
        String fileName = file.getName();
        return fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".jpeg");
    }

    @Override
    public @Nullable VideoElement fromFile(File file) {
        return new ImageElement(file, this);
    }
    //return original file now (late potential copy)

}
