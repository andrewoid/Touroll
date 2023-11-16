package touroll;

import touroll.image.ImageElement;
import touroll.image.ImageRenderer;
import touroll.markdown.MarkdownElement;
import touroll.markdown.MarkdownRenderer;
import touroll.speech.SpeechElement;
import touroll.speech.SpeechRenderer;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Generates a List of VideoElement objects from a List of File objects.
 */
public class VideoElementFactory {

    private final ImageRenderer imageRenderer;
    private final MarkdownRenderer markdownRenderer;
    private final SpeechRenderer speechRenderer;

    public VideoElementFactory(
            ImageRenderer imageRenderer,
            MarkdownRenderer markdownRenderer,
            SpeechRenderer speechRenderer
    ) {
        this.imageRenderer = imageRenderer;
        this.markdownRenderer = markdownRenderer;
        this.speechRenderer = speechRenderer;
    }

    public List<VideoElement> fromFiles(List<File> files) {
        // map each File to a VideoElement
        return files.stream().map(file -> {
                    // .md markdown file
                    // .txt file text to speech
                    // .jpg, .png, .jpeg ... image

                    String fileName = file.getName();
                    if (fileName.endsWith(".md")) {
                        return new MarkdownElement(markdownRenderer, file);
                    } else if (fileName.endsWith(".txt")) {
                        return new SpeechElement(speechRenderer, file);
                    } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")) {
                        return new ImageElement(file, imageRenderer);
                    } else {
                        throw new IllegalStateException(fileName + " is not recognized");
                    }
                })
                .collect(Collectors.toList());
    }

}
