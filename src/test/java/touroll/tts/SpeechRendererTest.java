package touroll.tts;

import org.junit.jupiter.api.Test;
import touroll.speech.SpeechRenderer;

import java.io.File;
import java.io.IOException;

public class SpeechRendererTest
{

    @Test
    public void textFileToAudioFile() throws IOException {
        //given
        SpeechRenderer renderer = new SpeechRenderer();
        String audioFileName = "allStarAudio";
        File file = new File("src/test/java/touroll/tts/allStarLyrics.txt");

        //when
        renderer.SpeechRenderer(file, audioFileName);

        //then
    }
}
