package touroll.image;

import touroll.VideoElement;

import java.io.File;
import java.io.IOException;

public class ImageElement implements VideoElement {

    private File source;
    private File output;
    private ImageRenderer render;

    public ImageElement(File source, ImageRenderer render) {
        this.source = source;
        this.render = render;
    }

    @Override
    public void prepare() throws IOException {
        output = render.prepare(source);
    }

    @Override
    public File getOutputFile() {
        return output;
    }
}
