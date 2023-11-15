package touroll.speech;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SpeechElementTest
{
    @Test
    void getOutputFile() throws IOException {
        //given
        //given
        SpeechRenderer render = mock();
        File source = new File("src/test/java/touroll/tts/allStarLyrics.txt");
        SpeechElement element = new SpeechElement(render, source);


        //when
        element.prepare();

        //then
        File output = element.getOutputFile();
        verify(render).speechRenderer(source, output.toString());
        assertEquals(output.toString(), "src/test/java/touroll/tts/allStarLyrics.txt.wav");
    }
}
