package touroll.markdown;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HtmlToImageRenderer
{
    private final int width;
    private final int height;
    private final BufferedImage image;
    private final Graphics graphics;
    private final JEditorPane jep;

    public HtmlToImageRenderer() throws IOException
    {
        width = 600;
        height = 600;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //https://stackoverflow.com/questions/10391778/create-a-bufferedimage-from-file-and-make-it-type-int-argb
        graphics = image.createGraphics();
        jep = new JEditorPane("text/html", "");
        //Used https://stackoverflow.com/questions/59160419/java-convert-html-to-image
    }

    public Image createImageFileFromHtmlString(String html)
    {
        jep.setText(html);
        jep.setSize(width, height);
        jep.print(graphics);
        return image;
    }
}