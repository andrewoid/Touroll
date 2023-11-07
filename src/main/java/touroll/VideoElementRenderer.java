package touroll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class VideoElementRenderer {

    public void render(List<VideoElement> list) throws IOException {
        // > ffmpeg -r FPS -i input.txt -pix_fmt yuv420p output.mp4

        PrintWriter writer = new PrintWriter(new File("input.txt"));

        list.forEach(element -> {
            writer.print("file '");
            writer.print(element.getOutputFile());
            writer.println("'");
        });

        writer.close();
    }


}
