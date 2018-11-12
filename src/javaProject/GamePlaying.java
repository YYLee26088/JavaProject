package javaProject;

import javax.swing.JFrame;

public class GamePlaying extends JFrame{
	public GamePlaying() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MovingPlayer());
		setVisible(true);
	}
}
