package touroll.markdown;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkdownRendererTest
{

    @Test
    public void getHtmlRendering() throws IOException
    {
        MarkdownRenderer markdownRenderer = new MarkdownRenderer();
        String actual = markdownRenderer.getHtmlRendering("What is *this*?");
        String expected = "<p>What is <em>this</em>?</p>\n";
        assertEquals(expected, actual);
    }
}