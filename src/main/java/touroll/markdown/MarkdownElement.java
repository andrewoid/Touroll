package touroll.markdown;

import touroll.VideoElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MarkdownElement implements VideoElement
{

    private final MarkdownRenderer renderer;
    private final File source;
    private File output;

    public MarkdownElement(MarkdownRenderer renderer,
                           File source)
    {
        this.renderer = renderer;
        this.source = source;
    }

    //test
    @Override
    public void prepare() throws IOException
    {
        BufferedImage image = renderer.getImageFromMarkdownFile(source);
        output = new File(source.getPath() + ".png");
        ImageIO.write(image, "png", output);
    }

    @Override
    public File getOutputFile()
    {
        return output;
    }
}
