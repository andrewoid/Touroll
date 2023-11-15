package touroll.speech;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class SpeechElementTest
{
    @Test
    void getOutputFile() throws IOException {
        //given
        SpeechRenderer render = mock();
        File source = new File("src/test/java/touroll/tts/allStarLyrics.txt");
        File output = new File(source.getPath() + ".wav");
        SpeechElement element = new SpeechElement(render, source);

        //when
        element.prepare();

        //then
        File result = element.getOutputFile();
        assertEquals(result, output);
    }
}
