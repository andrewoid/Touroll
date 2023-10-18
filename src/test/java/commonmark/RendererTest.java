package commonmark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RendererTest
{

    @Test
    public void getHtmlRendering()
    {
        Renderer renderer = new Renderer();
        String actual = renderer.getHtmlRendering("What is *this*?");
        String expected = "<p>What is <em>this</em>?</p>\n";
        assertEquals(expected, actual);
    }
}