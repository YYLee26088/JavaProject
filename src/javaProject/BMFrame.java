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
		
		JPanel panel=new JPanel();
		this.add(panel);
		Image img=kit.getImage("BIcon.png");
		setIconImage(img);
		setVisible(true);
	}

}
