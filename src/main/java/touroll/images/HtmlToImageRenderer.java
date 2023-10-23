package touroll.images;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HtmlToImageRenderer
{
    private final int width;
    private final int height;
    private final BufferedImage image;
    private final Graphics graphics;

    public HtmlToImageRenderer()
    {
        width = 600;
        height = 600;
        image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration()
                .createCompatibleImage(width, height);
        graphics = image.createGraphics();
    }

    public void createImageFileFromHtmlString(String html, String filePath) throws IOException
    {
        JEditorPane jep = new JEditorPane("text/html", html);
        jep.setSize(width, height);
        jep.print(graphics);
        ImageIO.write(image, "png", new File(filePath));
    }
}