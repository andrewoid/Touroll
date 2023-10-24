package touroll.tts;

import org.junit.jupiter.api.Test;

import javax.sound.sampled.LineUnavailableException;
import javax.speech.AudioException;
import javax.speech.EngineException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TtoStest
{

    @Test
    public void speakAudioOfText() throws EngineException,
            AudioException, InterruptedException, LineUnavailableException, IOException {
        //given
        TtoS tts = new TtoS();

        //when
        tts.speakAudioOfText("Scooby Dooby Doo, where are you?\n"
                + "We got some work to do now\n"
                + "Scooby Dooby Doo, where are you?");
        //then

    }

    @Test
    public void checkForFile() {
        //given
        String wavFileName = "textToFile.wav";

        //when
        File wavFile = new File("textToFile.wav", wavFileName);

        //then
        //check for existing file
        assertTrue(wavFile.exists(), "Hey down here: the .wav file was not created");

    }
}
