package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
	private String musicFile;
	
	// to store current position
    Long currentFrame;
    Clip clip;
      
    // current status of clip
    String status = "";
      
    AudioInputStream audioInputStream;
	
	public MusicPlayer(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {		
		Path pt = Paths.get(path);
		musicFile = pt.toAbsolutePath().toString();
		/* URL url = new URL("http://www.concidel.com/upload/myfile.wav");
		URLConnection urlc = url.openConnection();
		InputStream is = (InputStream)urlc.getInputStream();
		byte fileBytes = new byte[is.available()];
		int len;
		while ( (len = is.read(fileBytes,0,fileBytes.length)) !=-1){
		    response.getOutputStream.write(fileBytes, 0, len);
		} */
		
		// create AudioInputStream object
        audioInputStream = 
                AudioSystem.getAudioInputStream(new File(musicFile).getAbsoluteFile());
          
        // create clip reference
        clip = AudioSystem.getClip();
          
        // open audioInputStream to the clip
        clip.open(audioInputStream);
          
        clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void play() 
    {
        //start the clip
        clip.start();
          
        status = "play";
    }
	
	public void pause() 
    {
        if (status.equals("paused")) 
        {
            return;
        }
        this.currentFrame = 
        this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }
	
	public void resumeAudio() throws UnsupportedAudioFileException,
    IOException, LineUnavailableException 
	{
		if (status.equals("play")) 
		{
			return;
		}
		clip.close();
		resetAudioStream();
		clip.setMicrosecondPosition(currentFrame);
		this.play();
	}
	
	public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
    LineUnavailableException 
	{
		audioInputStream = AudioSystem.getAudioInputStream(
		new File(musicFile).getAbsoluteFile());
		clip.open(audioInputStream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
