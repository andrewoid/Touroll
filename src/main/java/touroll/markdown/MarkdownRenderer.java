package touroll.markdown;

import org.apache.commons.io.IOUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jetbrains.annotations.Nullable;
import touroll.Renderer;
import touroll.VideoElement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MarkdownRenderer implements Renderer {
    private final Parser parser;
    private final HtmlRenderer renderer;
    private final HtmlToImageRenderer htmlToImageRenderer;

    public MarkdownRenderer() throws IOException {
        parser = Parser.builder().build();
        renderer = HtmlRenderer.builder().build();
        htmlToImageRenderer = new HtmlToImageRenderer();
    }

    public BufferedImage getImageFromMarkdownFile(File file) throws IOException {
        String path = file.getAbsolutePath();
        BufferedImage image = null;

        if (path.endsWith("md")) {
            FileReader reader = new FileReader(file);
            String markdown = IOUtils.toString(reader);
            image = getImageFromMarkdownString(markdown);
        }
        //instead throw exception if wrong file type?
        return image;
    }

    public BufferedImage getImageFromMarkdownString(String toRender) throws IOException {
        return htmlToImageRenderer.createImageFileFromHtmlString(getHtmlRendering(toRender));
    }

    public String getHtmlRendering(String toRender) {
        Node document = parser.parse(toRender);
        return renderer.render(document);
    }

    @Override
    public boolean isFileType(File file) {
        return file.getName().endsWith(".md");
    }

    @Override
    public @Nullable VideoElement fromFile(File file) {
        return new MarkdownElement(this, file);
    }
}
