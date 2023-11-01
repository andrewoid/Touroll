package touroll.image;

import touroll.VideoElement;

import java.io.File;
import java.io.IOException;

public class ImageElement implements VideoElement {

    File source;
    File output;
    ImageRenderer render;

    public ImageElement(File source, ImageRenderer render) {
        this.source = source;
        this.render = render;
    }

    @Override
    public void prepare() throws IOException {
        output = render.prepare(source);
    }
}
