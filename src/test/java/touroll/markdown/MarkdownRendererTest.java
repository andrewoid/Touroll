package touroll.markdown;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownRendererTest
{
    String toRender = "What is *this*?";

    @Test
    public void getHtmlRendering() throws IOException
    {

        MarkdownRenderer markdownRenderer = new MarkdownRenderer();
        String actual = markdownRenderer.getHtmlRendering(toRender);
        String expected = "<p>What is <em>this</em>?</p>\n";
        assertEquals(expected, actual);
    }

    @Test
    public void getImageFromMarkdownString() throws IOException
    {
        MarkdownRenderer markdownRenderer = new MarkdownRenderer();
        BufferedImage result = markdownRenderer.getImageFromMarkdownString(toRender);
        int imageHeight = result.getHeight();
        assertNotEquals(0, imageHeight);
        int imageWidth = result.getWidth();
        assertNotEquals(0, imageWidth);
    }

    @Test
    public void getImageFromMarkdownFile() throws IOException
    {
        File md = new File("src/test/resources/test.md");
        MarkdownRenderer markdownRenderer = new MarkdownRenderer();
        BufferedImage image = markdownRenderer.getImageFromMarkdownFile(md);
        int imageHeight = image.getHeight();
        assertNotEquals(0, imageHeight);
        int imageWidth = image.getWidth();
        assertNotEquals(0, imageWidth);
    }

    @Test
    public void getImageFromNonMarkdownFile() throws IOException
    {
        File md = new File("src/test/resources/not_md.txt");
        MarkdownRenderer markdownRenderer = new MarkdownRenderer();
        BufferedImage image = markdownRenderer.getImageFromMarkdownFile(md);
        assertNull(image);
    }
}