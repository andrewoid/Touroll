package touroll.markdown;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MarkdownRenderer {
    private final Parser parser;
    private final HtmlRenderer renderer;
    private final HtmlToImageRenderer htmlToImageRenderer;

    public MarkdownRenderer() throws IOException {
        parser = Parser.builder().build();
        renderer = HtmlRenderer.builder().build();
        htmlToImageRenderer = new HtmlToImageRenderer();
    }

    public BufferedImage getImageFromFile(File file) {
        return null;
    }

    public String getHtmlRendering(String toRender) {
        Node document = parser.parse(toRender);
        return renderer.render(document);
    }

    public Image getImageFromMarkdown(String toRender) throws IOException {
        return htmlToImageRenderer.createImageFileFromHtmlString(getHtmlRendering(toRender));
    }
}
