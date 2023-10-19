package touroll.tts;

import org.junit.jupiter.api.Test;

import javax.speech.AudioException;
import javax.speech.EngineException;

public class TtoSTest
{

    @Test
    public void speakAudioOfText() throws EngineException, AudioException, InterruptedException {
        //given
        TtoS tts = new TtoS();

        //when
        tts.speakAudioOfText("Hey michal how are you doing today");

        //then

    }
}
