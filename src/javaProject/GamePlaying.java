package javaProject;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePlaying extends JFrame{
	
	private ImageIcon i=new ImageIcon("temp/texture2.jpg");
	private Image bg=i.getImage();
	
	JPanel background=new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, 0, 0, null);
		}
	};
	
	public GamePlaying() {
		BMFrame frame=new BMFrame();
		setSize(frame.getWidth(),frame.getHeight());
		setLocation(frame.location());
		
		this.add(background);
		
		MovingPlayer temp=new MovingPlayer();
		this.setLayout(null);
		this.add(temp);
		temp.setBounds(0, 0, 1013, 637);
		
		background.setBounds(0, 0, 637, 637);
		
		setVisible(true);
	}
}
