package touroll.images;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HtmlToImageTest
{

    @Test
    public void createImageFileFromHtmlString() throws IOException
    {
        String html = "<p>What is <em>this</em>?</p>\n";
        String filePath = "imageFromHtml.png";
        HtmlToImageRenderer htmlToImage = mock();
        htmlToImage.createImageFileFromHtmlString(html, filePath);
        verify(htmlToImage).createImageFileFromHtmlString(html, filePath);
    }
}