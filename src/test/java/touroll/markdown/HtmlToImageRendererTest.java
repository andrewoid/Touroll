package touroll.markdown;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HtmlToImageRendererTest
{

    @Test
    public void createImageFileFromHtmlString() throws IOException
    {
        //given
        String html = "<p>What is <em>this</em>?</p>\n";
        HtmlToImageRenderer htmlToImageRenderer = new HtmlToImageRenderer();

        //when
        Image image = htmlToImageRenderer.createImageFileFromHtmlString(html);

        //then
        assertNotNull(image);
    }
}