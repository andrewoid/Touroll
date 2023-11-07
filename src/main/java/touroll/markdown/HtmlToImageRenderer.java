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
    //private final Graphics graphics;
    private final Graphics2D graphics2D;
    private final JEditorPane jep;

    public HtmlToImageRenderer() throws IOException
    {
        width = 600;
        height = 600;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //https://stackoverflow.com/questions/10391778/create-a-bufferedimage-from-file-and-make-it-type-int-argb
        //graphics = image.createGraphics();
        graphics2D = image.createGraphics();
        graphics2D.setComposite(AlphaComposite.Clear);
        graphics2D.fillRect(0, 0, width, height);
        //For above 3 lines used:
        // https://stackoverflow.com/questions/17271812/save-buffered-image-with-transparent-background
        jep = new JEditorPane("text/html", "");
        //Used https://stackoverflow.com/questions/59160419/java-convert-html-to-image
    }

    //IMPORTANT: When this method is used, the Image should be output in a png format
    //Why? To maintain transparent background
    //For example: ImageIO.write(bufferedImage, "png", file);

    public Image createImageFileFromHtmlString(String html)
    {
        jep.setText(html);
        jep.setSize(width, height);
        jep.print(graphics2D);
        return image;
    }
}