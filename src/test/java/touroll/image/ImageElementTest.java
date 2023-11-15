package touroll.image;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ImageElementTest {
    @Test
    void getOutputFile() throws IOException {
        //given
        File source = new File("src/test/resources/IHaveADream/img1.jpg");
        ImageRenderer render = mock();
        doReturn(source).when(render).prepare(source);
        ImageElement element = new ImageElement(source, render);



        //when
        element.prepare();

        //then
        File output = element.getOutputFile();
        assertEquals(output, source);
    }
}