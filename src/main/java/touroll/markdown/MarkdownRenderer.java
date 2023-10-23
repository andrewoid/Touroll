package touroll.markdown;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.awt.*;
import java.io.IOException;

public class MarkdownRenderer
{
    private final Parser parser;
    private final HtmlRenderer renderer;

    public MarkdownRenderer()
    {
        parser = Parser.builder().build();
        renderer = HtmlRenderer.builder().build();
    }

    public String getHtmlRendering(String toRender)
    {
        Node document = parser.parse(toRender);
        return renderer.render(document);
    }

    public Image getImageFromMarkdown(String toRender) throws IOException
    {
        HtmlToImageRenderer htmlToImageRenderer = new HtmlToImageRenderer();
        return htmlToImageRenderer.createImageFileFromHtmlString(getHtmlRendering(toRender));
    }
}
