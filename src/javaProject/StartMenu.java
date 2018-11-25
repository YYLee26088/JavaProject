package javaProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartMenu extends JPanel{
	private GameState state;
	
	private ImageIcon gs=new ImageIcon("images/gamestart.png");
	
	private ImageIcon i=new ImageIcon("images/FrameTitle.jpg");
	private Image bg=i.getImage();
	
	//private BMFrame frame;
	
	JPanel background=new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, 0, 0, null);
		}
	};

	public StartMenu() {
		this.setSize(1013,637);
		this.setLayout(null);
		JButton gameStart=new JButton(gs);
		gameStart.setBorderPainted(false);
		gameStart.setContentAreaFilled(false);
		gameStart.setFocusPainted(false);
		gameStart.setBounds(590, 430, gs.getIconWidth(), gs.getIconHeight());
		
		this.add(gameStart);
		
		this.add(background);
		background.setBounds(0, 0, 1013, 637);
		
		gameStart.addActionListener(new GameStart());
		
	}
	class GameStart implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new GamePlaying();
		}
	}
}


