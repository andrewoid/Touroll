package touroll.tts;

import com.sun.speech.freetts.audio.SingleFileAudioPlayer;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import java.util.Locale;

public class textToAudio
{
    public textToAudio() throws EngineException {
        System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                        + ".cmu_us_kal.KevinVoiceDirectory");

        // Register Engine
        Central.registerEngineCentral(
                "com.sun.speech.freetts"
                        + ".jsapi.FreeTTSEngineCentral");
    }

    public void speakAudioOfText(String textForAudio) throws EngineException,
            AudioException, InterruptedException {
        // Create a Synthesizer
        Synthesizer synthesizer
                = Central.createSynthesizer(
                new SynthesizerModeDesc(Locale.US));

        // Allocate synthesizer
        synthesizer.allocate();

        // Resume Synthesizer
        synthesizer.resume();

        SingleFileAudioPlayer singleFileAudioPlayer = new SingleFileAudioPlayer(
                "textToFile", AudioFileFormat.Type.WAVE);
        singleFileAudioPlayer.setAudioFormat(new AudioFormat(
                44100, 16, 2, true, true));

        singleFileAudioPlayer.begin(1000);

        SynthesizerModeDesc desc = (SynthesizerModeDesc) synthesizer.getEngineModeDesc();
        javax.speech.synthesis.Voice[] jsapiVoices = desc.getVoices();
        javax.speech.synthesis.Voice jsapiVoice = jsapiVoices[0];

        /* Non-JSAPI modification of voice audio player
         */
        if (jsapiVoice instanceof com.sun.speech.freetts.jsapi.FreeTTSVoice)
        {
            com.sun.speech.freetts.Voice freettsVoice =
                    ((com.sun.speech.freetts.jsapi.FreeTTSVoice) jsapiVoice).getVoice();
            freettsVoice.setAudioPlayer(singleFileAudioPlayer);
        }


        // Speaks the given text until the queue is empty.
        synthesizer.speakPlainText(textForAudio, null);
        synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

        singleFileAudioPlayer.close();

        // Deallocate the Synthesizer.
        synthesizer.deallocate();
    }
}
