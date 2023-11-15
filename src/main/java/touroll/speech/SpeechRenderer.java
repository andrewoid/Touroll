package touroll.speech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.audio.AudioPlayer;
import com.sun.speech.freetts.audio.SingleFileAudioPlayer;
import org.apache.commons.io.IOUtils;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SpeechRenderer
{
    public void speechRenderer(File filepath, String audioFileName) throws IOException {
        String fileContent = readTextFile(filepath);
        Voice voice = getVoice();
        saveAudio(voice, fileContent, audioFileName);
    }

    public String readTextFile(File filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        return IOUtils.toString(reader);
    }

    private Voice getVoice() {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager manager = VoiceManager.getInstance();
        return manager.getVoice("kevin16");
    }

    public void saveAudio(Voice voice, String text, String outputFilePath) {

        AudioPlayer audioPlayer = new SingleFileAudioPlayer(outputFilePath, AudioFileFormat.Type.WAVE);
        audioPlayer.setAudioFormat(new AudioFormat(
                44100, 16, 2, true, true));
        voice.setAudioPlayer(audioPlayer);
        voice.allocate();
        voice.speak(text);
        voice.deallocate();
        audioPlayer.close();
    }
}
