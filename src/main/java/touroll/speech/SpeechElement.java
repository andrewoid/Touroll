package touroll.speech;

import touroll.VideoElement;

import java.io.File;
import java.io.IOException;

public class SpeechElement implements VideoElement
{
    private SpeechRenderer renderer;
    private File source;
    private File output;

    public SpeechElement(SpeechRenderer renderer, File source, File output) {
        this.renderer = renderer;
        this.source = source;
        this.output = output;
    }

    @Override
    public void prepare() throws IOException {
        renderer.SpeechRenderer(source, output + ".wav");
    }

    @Override
    public File getOutputFile() {
        return output;
    }
}
