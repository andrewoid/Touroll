package touroll.tts;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TextToAudioTest
{

    @Test
    public void textFileToAudioFile() throws IOException {
        //given
        TextToAudio tts = new TextToAudio();
        File file = new File("src/main/java/touroll/tts/allStarLyrics.txt");

        //when
        tts.fileToString(file);

        //then

    }
}
