package touroll.ffmpeg;

import com.github.manevolent.ffmpeg4j.*;
import com.github.manevolent.ffmpeg4j.output.FFmpegVideoTargetSubstream;
import com.github.manevolent.ffmpeg4j.source.AudioSourceSubstream;
import com.github.manevolent.ffmpeg4j.source.MediaSourceSubstream;
import com.github.manevolent.ffmpeg4j.stream.output.FFmpegTargetStream;
import com.github.manevolent.ffmpeg4j.stream.source.FFmpegSourceStream;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Collections;
import java.util.Random;

import static org.bytedeco.ffmpeg.global.avutil.AV_PIX_FMT_YUV420P;

public class FfMpegWrapper {

    static final int WIDTH = 400;
    static final int HEIGHT = 400;

    public void generateVideo() throws IOException, FFmpegException {
        OutputStream out = new FileOutputStream("out.mp4");
        FFmpegOutput output = FFmpegIO.openOutputStream(out);
        FFmpegTargetStream stream = output.open("mp4");
        stream.setPixelFormat(AV_PIX_FMT_YUV420P);

        FFmpegVideoTargetSubstream substream = stream.registerVideoSubstream(
                "mpeg4",
                new VideoFormat(WIDTH, HEIGHT, 1),
                Collections.emptyMap()
        );

        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            graphics.setPaint(new Color(r, g, b));
            graphics.fillRect(0, 0, WIDTH, HEIGHT);

            WritableRaster raster = image.getRaster();
            DataBufferInt data = (DataBufferInt) raster.getDataBuffer();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            for (int d : data.getData()) {
                dos.writeInt(d);
            }

            VideoFrame frame = new VideoFrame(
                    0,
                    i,
                    0,
                    stream.getPixelFormat(),
                    WIDTH,
                    HEIGHT,
                    baos.toByteArray()
            );
            substream.write(frame);
            substream.flush();
        }

        try {
            substream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            stream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            output.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        out.close();
    }


    public void run() throws IOException, FFmpegException {
        InputStream inputStream = new FileInputStream("example.ogg");
        FFmpegInput input = FFmpegIO.openInputStream(inputStream);
        FFmpegSourceStream stream = input.open("ogg");

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
            } catch (EOFException ex) {
                break;
            }
        }
    }

}
