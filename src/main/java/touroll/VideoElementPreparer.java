package touroll;

import java.io.IOException;
import java.util.List;

/**
 * Take a VideoElement and "prepare it for use" with FFMPEG on the command line.
 */
public class VideoElementPreparer {
    public VideoElementPreparer() {
    }

    public void prepare(List<VideoElement> list) {
        for (VideoElement element : list) {
            try {
                element.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
