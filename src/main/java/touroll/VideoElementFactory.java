package touroll;

import touroll.image.ImageRenderer;
import touroll.markdown.MarkdownRenderer;
import touroll.speech.SpeechRenderer;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generates a List of VideoElement objects from a List of File objects.
 */
public class VideoElementFactory {

    private List<Renderer> renderers;

    public VideoElementFactory(
            ImageRenderer imageRenderer,
            SpeechRenderer speechRenderer,
            MarkdownRenderer markdownRenderer
    ) {
        this(List.of(imageRenderer, markdownRenderer, speechRenderer));
    }

    public VideoElementFactory(
            List<Renderer> renderers
    ) {
        this.renderers = renderers;
    }

    public List<VideoElement> fromFiles(List<File> files) {
        // map each File to a VideoElement
        return files.stream().map(file -> {
                    // .md markdown file
                    // .txt file text to speech
                    // .jpg, .png, .jpeg ... image

                    for (Renderer renderer : renderers) {
                        if (renderer.isFileType(file)) {
                            return renderer.fromFile(file);
                        }
                    }

                    throw new IllegalStateException(file + " is not recognized");
                })
                .collect(Collectors.toList());
    }

}
