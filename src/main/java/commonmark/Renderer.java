package commonmark;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.Extension.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Renderer
{
    Parser parser;
    HtmlRenderer renderer;
    public Renderer()
    {
        parser = Parser.builder().build();
        renderer = HtmlRenderer.builder().build();
    }

    public String getHtmlRendering(String toRender)
    {
        Node document = parser.parse(toRender);
        return renderer.render(document);
    }

    public boolean getHtmlFile(String rendered) throws IOException
    {
        File newHtmlFile = new File("rendered.html");
        FileUtils.writeStringToFile(newHtmlFile, rendered);
        return true;
    }
}
