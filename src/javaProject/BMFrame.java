/*
 * 게임 프레임 설정
 */
package javaProject;

import javax.swing.*;
import java.awt.*;

public class BMFrame extends JFrame{
	public BMFrame() {
		//현재 화면의 크기 얻기
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screen=kit.getScreenSize();
		
		setTitle("Bomber Man: 봄버 맨");
		setSize(800,500);//임시 초기화
		setLocation(screen.width/2, screen.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();//버튼과 이미지 등이 들어갈 패널
		panel.setLayout(new FlowLayout());//배치관리자 생성: FlowLayout
		this.add(panel);//프레임에 패널 추가
		Image img=kit.getImage("BIcon.png");//임시 아이콘
		setIconImage(img);
		
		JButton gameStart=new JButton("게임 시작");
		JButton option=new JButton("옵션");
		panel.add(gameStart);
		panel.add(option);
		
		setVisible(true);
	}

}
