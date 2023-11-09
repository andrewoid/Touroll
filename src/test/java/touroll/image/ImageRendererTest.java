package touroll.image;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ImageRendererTest {

    @Test
    void prepare() {

        //given
        File file = new File("src/test/resources/IHaveADream/img1.jpg");

        //when
        ImageRenderer renderer = new ImageRenderer();
        File output = renderer.prepare(file);

        //then
        assertEquals(output, file);
    }
}