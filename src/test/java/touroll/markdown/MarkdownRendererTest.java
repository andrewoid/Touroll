package touroll.markdown;

import org.junit.jupiter.api.Test;
import touroll.markdown.MarkdownRenderer;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownRendererTest
{

    @Test
    public void getHtmlRendering()
    {
        MarkdownRenderer markdownRenderer = new MarkdownRenderer();
        String actual = markdownRenderer.getHtmlRendering("What is *this*?");
        String expected = "<p>What is <em>this</em>?</p>\n";
        assertEquals(expected, actual);
    }
}