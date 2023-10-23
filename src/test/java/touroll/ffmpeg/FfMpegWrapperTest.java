package touroll.ffmpeg;

import com.github.manevolent.ffmpeg4j.FFmpegException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class FfMpegWrapperTest {

    @Test
    void generateVideo() throws FFmpegException, IOException {
        // given
        FfMpegWrapper ffMpegWrapper = new FfMpegWrapper();

        // when
        ffMpegWrapper.generateVideo();

        // then
    }
}