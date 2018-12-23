package javaProject;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Sounds {
	
	Clip clip;
	
	public void startBgm() {
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sounds/sleepywood.wav"));
			clip=AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			clip.loop(-1);
		}
		catch(Exception ex){System.out.println("사운드없음");}
	}
	
	public void stopBgm() {
		clip.stop();
		clip.close();
	}
}


