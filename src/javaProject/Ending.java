package javaProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import javaProject.StartMenu.GameStart;

public class Ending extends JPanel{
	private BMFrame frame;
	private JButton reStart;

	private ImageIcon gs=new ImageIcon("images/restart.png");

	private ImageIcon i=new ImageIcon("images/end.jpg");
	private Image bg=i.getImage();

	JPanel background=new JPanel() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bg, 0, 0, null);
		}
	};

	public Ending(BMFrame frame) {
		this.frame=frame;

		this.setLayout(null);
		this.setSize(frame.getWidth(),frame.getHeight());

		reStart=new JButton(gs);
		reStart.setBorderPainted(false);
		reStart.setContentAreaFilled(false);
		reStart.setFocusPainted(false);
		reStart.setBounds(400,400, gs.getIconWidth(), gs.getIconHeight());

		this.add(reStart);

		this.add(background);
		background.setBounds(0, 0, 1020, 640);

		reStart.addActionListener(new GameStart());//이벤트 추가

	}
	class GameStart implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {	
			frame.change(0);
		}
	}
}




