/*
 * 게임 프레임 설정
 * 이윤영
 */
package javaProject;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BMFrame extends JFrame{
	ImageIcon i=new ImageIcon("images/FrameTitle.jpg");
	Image bg=i.getImage();

	public BMFrame() {
		//현재 화면의 크기 얻기
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		setTitle("Bomber Man: 봄버 맨");
		setSize(1013,637);//게임판 크기
		setLocation((screenSize.width-1013)/2, (screenSize.height-637)/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel background=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg, 0, 0, null);
			}
		};
		
		background.setLayout(null);//배치관리자 생성: 절대위치로 배치위해 null
		this.add(background);//프레임에 패널 추가
		Image img=kit.getImage("images/Icon.png");//임시 아이콘
		setIconImage(img);
		
		ImageIcon gs=new ImageIcon("images/gamestart.png");
		JButton gameStart=new JButton(gs);
		gameStart.setBorderPainted(false);
		gameStart.setContentAreaFilled(false);
		gameStart.setFocusPainted(false);
		gameStart.setBounds(590, 430, gs.getIconWidth(), gs.getIconHeight());
		
		background.add(gameStart);
		
		gameStart.addActionListener(new GameStart());

		setVisible(true);
	}
	
	class GameStart implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new GamePlaying();
		}
	}

}
