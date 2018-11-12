package javaProject;

import javax.swing.JFrame;

public class GamePlaying extends JFrame{
	public GamePlaying() {
		BMFrame frame=new BMFrame();
		setSize(frame.getWidth(),frame.getHeight());
		setLocation(frame.location());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MovingPlayer());
		setVisible(true);
	}
}
