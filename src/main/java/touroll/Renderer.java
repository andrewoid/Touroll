package touroll;

import org.jetbrains.annotations.Nullable;

import java.io.File;

public interface Renderer {

    /**
     * @return true if this Renderer can manipulate this filetype, otherwise false
     */
    boolean isFileType(File file);

    /**
     * @param file
     * @return the file as a VideoElement of a specific type that this Renderer can manipulate
     */
    @Nullable
    VideoElement fromFile(File file);

}
