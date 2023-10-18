package touroll.video;

import com.github.manevolent.ffmpeg4j.AudioFormat;
import com.github.manevolent.ffmpeg4j.FFmpegIO;
import com.github.manevolent.ffmpeg4j.source.AudioSourceSubstream;
import com.github.manevolent.ffmpeg4j.stream.output.FFmpegTargetStream;
import com.github.manevolent.ffmpeg4j.stream.source.FFmpegSourceStream;
import com.github.manevolent.ffmpeg4j.transcoder.Transcoder;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class FFmpegj4UnitTest {
    @Test
    public void transcodeTestFFmpeg() throws Exception {
        Map<String, String> options = new HashMap<>();
        options.put("strict", "experimental");
        Path tempFile = Files.createTempFile("temp-audio", null);
        FFmpegTargetStream targetStream = FFmpegIO.openChannel(Files.newByteChannel(tempFile, StandardOpenOption.WRITE)).asOutput().open("mp3");
        try (FFmpegSourceStream sourceStream = FFmpegIO.openInputStream(FFmpegj4UnitTest.class.getResourceAsStream("/testAudio.ogg")).open("ogg")) {
            sourceStream.registerStreams();

            AudioSourceSubstream mediaSourceSubstream = (AudioSourceSubstream) sourceStream.getSubstreams().get(0);
            AudioFormat audioFormat = mediaSourceSubstream.getFormat();

            targetStream.registerAudioSubstream("libmp3lame", audioFormat, options);

            Transcoder.convert(sourceStream, targetStream, Double.MAX_VALUE);
        }
    }
}

