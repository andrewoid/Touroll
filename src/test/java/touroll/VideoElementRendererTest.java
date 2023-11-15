package touroll;

import org.junit.jupiter.api.Test;
import touroll.image.ImageElement;
import touroll.image.ImageRenderer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VideoElementRendererTest {

    @Test
    void render() throws IOException {
        //given
        File source = new File("src/test/resources/IHaveADream/img1.jpg");
        ImageElement element = mock();
        doReturn(source).when(element).getOutputFile();
        ArrayList<VideoElement> videoElements = new ArrayList<>();
        videoElements.add(element);
        VideoElementRenderer videoElementRenderer = new VideoElementRenderer();

        //when
        ArrayList<String> ffmpegCommands = (ArrayList<String>) videoElementRenderer.render(videoElements);

        //then

        assertTrue(Files.isRegularFile(Path.of("imageInput.txt")));
        assertTrue(Files.isRegularFile(Path.of("audioInput.txt")));

        assertEquals(ffmpegCommands.get(0), "ffmpeg -f concat -i imageInput.txt "
                + "-c:v libx264 -r 1/5 -pix_fmt yuv420p outputPart1.mp4");
    }
}