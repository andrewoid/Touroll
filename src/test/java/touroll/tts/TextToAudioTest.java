package touroll.tts;

import org.junit.jupiter.api.Test;

import javax.speech.AudioException;
import javax.speech.EngineException;

public class TextToAudioTest
{

    @Test
    public void speakAudioOfText() throws EngineException,
            AudioException, InterruptedException {
        //given
        TextToAudio tts = new TextToAudio();

        //when
        tts.speakAudioOfText("Scooby Dooby Doo, where are you?\n"
                + "We got some work to do now\n"
                + "Scooby Dooby Doo, where are you?");
        //then

    }
}
