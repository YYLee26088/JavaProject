/*
 * 게임 프레임 설정
 * 이윤영
 */
package javaProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BMFrame extends JFrame{

	public BMFrame() {
		//현재 화면의 크기 얻기
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();

		setTitle("Bomber Man: 봄버 맨");
		setSize(1013,640);//프레임 크기
		setLocation((screenSize.width-1013)/2, (screenSize.height-637)/2);
		setLayout(null);

		getContentPane().setBackground(Color.black);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image img=kit.getImage("images/Icon.png");//임시 아이콘
		setIconImage(img);//프레임에 패널 추가

		add(new StartMenu(this));
	}

	public void change() {
		getContentPane().removeAll();
		getContentPane().add(new MovingPlayer());
		revalidate();
		repaint();
	}

}

//	public void setScreen(ameState state) {
//		switch(state.getID()) {
//		case 0:
//			this.add(new StartMenu());
//		case 1:
//			this.add(new GamePlaying());
//		}
//	}

