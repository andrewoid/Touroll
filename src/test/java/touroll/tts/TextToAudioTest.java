package touroll.tts;

import org.junit.jupiter.api.Test;

import javax.speech.AudioException;
import javax.speech.EngineException;
import java.io.File;
import java.io.IOException;

public class TextToAudioTest
{

    @Test
    public void textFileToAudioFile() throws IOException, AudioException, EngineException, InterruptedException {
        //given
        TextToAudio tts = new TextToAudio();
        File file = new File("/Users/michalrunge/IdeaProjects/Touroll/src/main/java/touroll/tts/allStarLyrics.txt");

        //when
        tts.fileToString(file);

        //then

    }
}
