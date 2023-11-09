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
        String audioFileName = "allStarAudio";
        File file = new File("src/test/resources/allStarLyrics.txt");

        //when
        tts.fileToString(file, audioFileName);

        //then

    }
}
