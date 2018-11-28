package javaProject;

import javax.swing.JFrame;

public class GamePlaying extends JFrame{
	
	public GamePlaying() {
		BMFrame frame=new BMFrame();
		setSize(frame.getWidth(),frame.getHeight()+20);
		setLocation(frame.location());
		
//		this.add(background);
		
		MovingPlayer temp=new MovingPlayer();
		this.setLayout(null);
		this.add(temp);
		temp.setBounds(0, 0, 637, 637);
		
//		background.setBounds(0, 0, 637, 637);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GamePlaying();
	}
}
