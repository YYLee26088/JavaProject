/*
 * 게임 프레임 설정
 */
package javaProject;

import javax.swing.*;
import java.awt.*;

public class BMFrame extends JFrame{

	ImageIcon i=new ImageIcon("images/FrameTitle.jpg");
	Image bg=i.getImage();

	public BMFrame() {
		//현재 화면의 크기 얻기
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen=kit.getScreenSize();

		setTitle("Bomber Man: 봄버 맨");
		setSize(1013,637);//게임판 크기
		setLocation(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel background=new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg, 0, 0, null);
			}
		};//버튼과 이미지 등이 들어갈 패널
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

		setVisible(true);
	}

}
