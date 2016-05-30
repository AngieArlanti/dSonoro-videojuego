package sound;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.org.apache.bcel.internal.util.ClassPath;


public class SoundManager {

	private static Mixer mixer;
	private static HashMap<ClipName, Clip> clips = new HashMap<ClipName,Clip>();
	private static HashMap<ClipName, String> roots;
	
	
	public static void play(ClipName name){
		
		Clip clip = getClip(getRoot(name));
		
		addClip(name,clip);
		
		if(name==ClipName.MENU){
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}else{
			clip.start();
		}
				
	}
	
	public static void stop(ClipName level1) {
		clips.get(level1).stop();
		
	}
	
	public static void stopSounds(){
		for(Clip clip : clips.values()){
			clip.stop();
		}
	}

	
	

	
	private static void addClip(ClipName name, Clip clip) {
		if(clip!=null){
			clips.put(name,clip);
		}else{
			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private static Clip getClip(String path){
		Clip clip=null;
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		
		try{clip = (Clip)mixer.getLine(dataInfo);}
		catch(LineUnavailableException lue){ lue.printStackTrace();}
		
		try{
			URL soundURL = SoundManager.class.getResource(path);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);
		}
		
		catch(LineUnavailableException lua){lua.printStackTrace();}
		catch(UnsupportedAudioFileException uafe) {uafe.printStackTrace();}
		catch (IOException ioe) { ioe.printStackTrace();}
		
		return clip;
	}
	
	
	public static void loadRoots(){
		roots = new HashMap<ClipName,String>();
		roots.put(ClipName.MENU, "Menu.wav");
		roots.put(ClipName.BUTTON_LEVEL1, "Nivel1-Boton.wav");
		roots.put(ClipName.BUTTON_LEVEL2, "Nivel2-Boton.wav");
		roots.put(ClipName.BUTTON_LEVEL3, "Nivel3-Boton.wav");
	}
	
	private static String getRoot(ClipName name){
		return roots.get(name);
	}
	
}
