package touroll.speech;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class SpeechRendererTest
{

    @Test
    public void textFileToAudioFile() throws IOException {
        //given
        SpeechRenderer render = new SpeechRenderer();
        String audioFileName = "allStarAudio";
        File file = new File("src/test/java/touroll/speech/allStarLyrics.txt");

        //when
        render.speechRenderer(file, audioFileName);

        //then
    }
}
