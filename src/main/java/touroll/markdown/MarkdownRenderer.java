package touroll.markdown;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.apache.commons.io.FileUtils;
import java.io.File;
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

    public void writeHtmlStringIntoNewHtmlFile(String rendered) throws IOException
    {
        File newHtmlFile = new File("rendered.html");
        FileUtils.writeStringToFile(newHtmlFile, rendered);
    }
}
