package touroll.ffmpeg4j;

import com.github.manevolent.ffmpeg4j.AudioFrame;
import com.github.manevolent.ffmpeg4j.FFmpegException;
import com.github.manevolent.ffmpeg4j.FFmpegInput;
import com.github.manevolent.ffmpeg4j.MediaType;
import com.github.manevolent.ffmpeg4j.source.AudioSourceSubstream;
import com.github.manevolent.ffmpeg4j.source.MediaSourceSubstream;
import com.github.manevolent.ffmpeg4j.stream.source.FFmpegSourceStream;

import java.io.*;

public class FFmpegAudio {
    /*
    Step #1
    Followed these instructions to download ffmpeg
    https://amiaopensource.github.io/ffmpeg-artschool/#:~:text=Check%20if%20you%20have%20ffmpeg,will%20have%20to%20install%20ffmpeg.
    Confirmed download: *this is screenshot from my terminal*
        libakenigsberg@Libas-MBP-6 bin % ffmpeg -version
        ffmpeg version 6.0 Copyright (c) 2000-2023 the touroll.ffmpeg4j.FFmpeg developers

    Step #2
    Used this https://sagioto.github.io/maven2gradle/ to convert the maven to gradle dependencies
    Added to build.gradle

    Added maven { url 'https://jitpack.io' } to Repositories
     */
    public AudioFrame getAudioFrame() throws FileNotFoundException, FFmpegException {
        InputStream inputStream = new FileInputStream("testAudio.ogg");
        FFmpegInput input = new FFmpegInput(inputStream);
        FFmpegSourceStream stream = input.open(inputFormat);

// Read the file header, and register substreams in FFmpeg4j
        stream.registerStreams();

        AudioSourceSubstream audioSourceSubstream = null;
        for (MediaSourceSubstream substream : stream.getSubstreams()) {
            if (substream.getMediaType() != MediaType.AUDIO) continue;

            audioSourceSubstream = (AudioSourceSubstream) substream;
        }

        if (audioSourceSubstream == null) throw new NullPointerException();

        AudioFrame frame;

        while (true) {
            try {
                frame = audioSourceSubstream.next();
                float[] interleaved_ABABAB_AudioSamples = frame.getSamples();
            } catch (IOException ex) {
                break;
            }
        }
        return frame;
    }
}
