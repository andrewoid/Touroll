package touroll.speech;

import touroll.VideoElement;

import java.io.File;
import java.io.IOException;

public class SpeechElement implements VideoElement
{
    private final SpeechRenderer render;
    private final File source;
    private File output;

    public SpeechElement(SpeechRenderer renderer, File source) {
        this.render = renderer;
        this.source = source;
    }

    @Override
    public void prepare() throws IOException {
        render.speechRenderer(source, output + ".wav");
        output = new File(source.getPath() + ".wav");
    }

    @Override
    public File getOutputFile() {
        return output;
    }
}
