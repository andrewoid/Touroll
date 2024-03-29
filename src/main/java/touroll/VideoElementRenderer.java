package touroll;

import touroll.image.ImageElement;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class VideoElementRenderer {

    public List<String> render(List<VideoElement> list) throws IOException {

        final File imageFile = new File("imageInput.txt");
        final File audioFile = new File("audioInput.txt");

        PrintWriter writer1 = new PrintWriter(imageFile);
        PrintWriter writer2 = new PrintWriter(audioFile);

        list.forEach(element -> {
            if (element instanceof ImageElement)
            {
                writer1.print("file '");
                writer1.print(element.getOutputFile());
                writer1.println("'");
            }
            //dont have a speach element yet
            /*else if (element instanceof SpeechElement){
                writer2.print("file '");
                writer2.print(element.getOutputFile());
                writer2.println("'");
            }*/
        });
        writer1.close();
        writer2.close();

        String imageVideo = "ffmpeg -f concat -i imageInput.txt -c:v libx264 -r 1/5 -pix_fmt yuv420p outputPart1.mp4";
        //dont have a speach element yet
        /* String outputWithAudio = "ffmpeg  -i outputPart1,mp4 -f concat -i audioFile.txt
                 -c:v libx264 -pix_fmt yuv420p output.mp4"; */

        List<String> ffmpegCommands =  new ArrayList<>();

        ffmpegCommands.add(imageVideo);
        //dont have a speach element yet
        //retval.add(outputWithAudio);

        return ffmpegCommands;
    }
}

// 2 commands....
//ffmpeg -f concat -i input2.txt -c:v libx264 -r 1/5 -pix_fmt yuv420p output1.mp4
//ffmpeg  -i output1.mp4 -f concat -i input3.txt -c:v libx264 -pix_fmt yuv420p output2.mp4
// out puts a file with ffmpeg inputs
// > ffmpeg -r FPS -i input.txt -pix_fmt yuv420p output.mp4
// make sure it output a proper working ffmpeg command for CP
//      --new method or class? zFFMpeg render
// given a frames per second
// given input file
// given an audio file
// take in name of output
