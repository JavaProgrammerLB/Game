package liangfei.game.russiablock.util;

import java.applet.AudioClip;

import javax.swing.JApplet;

public class AudioPlayer {

	public static AudioClip play(String resource) {
		ClassLoader classLoader = AudioPlayer.class.getClassLoader();
		AudioClip audioClip = JApplet.newAudioClip(classLoader.getResource(resource));
		audioClip.play();
		return audioClip;
	}
	
	public static AudioClip loop(String resource) {
		ClassLoader classLoader = AudioPlayer.class.getClassLoader();
		AudioClip audioClip = JApplet.newAudioClip(classLoader.getResource(resource));
		audioClip.loop();
		return audioClip;
	}
	
	public static void stop(AudioClip audioClip) {
		audioClip.stop();
	}
}
