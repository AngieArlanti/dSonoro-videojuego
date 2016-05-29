package sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.org.apache.bcel.internal.util.ClassPath;




public class Sound {

	public static Mixer mixer;
	public static Clip clip;
	
	private static Clip getClip(){
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try{clip = (Clip)mixer.getLine(dataInfo);}
		catch(LineUnavailableException lue){ lue.printStackTrace();}
		
		return clip;
	}
	
	public static void playMenu(){

		Clip clip = getClip();
		
		try{
			URL soundURL = Sound.class.getResource("Menu.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
		}
		
		catch(LineUnavailableException lua){lua.printStackTrace();}
		catch(UnsupportedAudioFileException uafe) {uafe.printStackTrace();}
		catch (IOException ioe) { ioe.printStackTrace();}
		
//		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		do{
			try{Thread.sleep(50);}
			catch(InterruptedException ie){ie.printStackTrace();}
			
		}while(clip.isActive());

	}
	
}
