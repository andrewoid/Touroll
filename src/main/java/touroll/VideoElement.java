package touroll;

import java.io.File;
import java.io.IOException;

/**
 * File that we wish to include in the Video.
 * Can be Image, Audio, TextToMarkdown, TextToSpeech
 */
public interface VideoElement {

    void prepare() throws IOException;

    File getOutputFile();

}
